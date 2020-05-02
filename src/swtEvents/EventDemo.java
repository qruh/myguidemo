package swtEvents;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class EventDemo {
	Display display;
	Shell shell;
	
	// ***
	// Event Model Pattern
	// ***
	public void showEventModelPattern(Shell parent) {
		//display = new Display();
		shell = new Shell(parent);		
		shell.setLayout(new FillLayout());
		
		Button button = new Button(shell, SWT.PUSH);
		button.setText("push me");
		button.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Button pushed");
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub				
			}			
		});
		shell.pack();
		shell.setSize(300,200);
		shell.open();		
	}
	
	public void close() {
		while(!shell.isDisposed()) { //event loop
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();		
	}	
	
	// ***
	// Display Filter Event
	// ***
	public void showDisplayFilterEvent(Shell parent, Display d) {
		display = d;
		shell = new Shell(parent);
		shell.setText("Left cklick your mouse");
		shell.setSize(200,100);
		shell.open();
		
		shell.addListener(SWT.MouseDown,  new SimpleListener("Shell mouse down listener"));
		
		display.addFilter(SWT.MouseDown, new SimpleListener("Display mouse down listener"));
		
		display.addFilter(SWT.MouseUp, new SimpleListener("Display mouse up listener"));		
		
	}
	class SimpleListener implements Listener{
		String name;

		public SimpleListener(String name) {
			this.name = name;
		}
		
		@Override
		public void handleEvent(Event event) {
			System.out.println("Event: [" + event.toString() + "] from " + name 
					+ ". \tCurrent Time (in ms: " + System.currentTimeMillis() );
		}		
	}
	
	// ***
	// Typed Events
	// ***
	public void showTypedEvent(Shell parent, Display d){
		display = d;
		shell = new Shell(parent);
		shell.setLayout(new GridLayout());
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("Click and check the console");
		button.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("widgetSelected");				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println("widgetDefaultSelected");				
			}			
		});
		
		shell.setSize(300,300);
		shell.open();		
	}
	
	// ***
	// Untyped Event
	// ***
	public void showUntypedEventListener(Shell parent, Display d) {
		
		display = d;
		shell = new Shell(parent);
		shell.setLayout(new GridLayout());
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("Click and check the console");
		button.setSize(100,50);
		button.addListener(SWT.Selection , new Listener() {

			@Override
			public void handleEvent(Event event) {
				System.out.println(event.button);
				
				switch(event.type) {
				case SWT.Selection:
					System.out.println("Button pressed");
					break;
				case SWT.MouseEnter:
					System.out.println("Mouse enter");
					break;
				}
			}			
		});
		button.addListener(SWT.MouseEnter, new MyButtonListener());
		
		Button button2 = new Button(shell, SWT.PUSH);
		button2.setText("button 2");
		button2.setSize(100,50);
		button2.addListener(SWT.Selection, new MyButtonListener());
		button2.addListener(SWT.MouseEnter, new MyButtonListener());
				
		shell.setSize(250,300);
		shell.open();
	}	
	class MyButtonListener implements Listener{

		@Override
		public void handleEvent(Event event) {
			System.out.println(event.button);
			
			switch(event.type) {
			case SWT.Selection:
				System.out.println("Button pressed");
				break;
			case SWT.MouseEnter:
				System.out.println("Mouse enter");
				break;
			}
		}		
	}
	
	// ***
	// Get Event Type
	// ***
	public void showEventTypeGet(Shell parent, Display d) {
		display = d;
		shell = new Shell(parent);
		shell.setLayout(new GridLayout());
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("Click and check the console");
		button.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				System.out.println(getEventName(event.type));
				switch(event.type) {
				case SWT.Selection:
					System.out.println("Button pressed");					
					break;
				}
			}			
		});
		shell.setSize(200,300);
		shell.open();		
	}
	
	private String getEventName(int eventType) {
		switch(eventType) {
		case SWT.None:
			return "null";
		case SWT.KeyDown:
			return "key down";
		case SWT.KeyUp:
			return "key up";
		case SWT.MouseDown:
			return "mouse down";
		 case SWT.MouseUp:
		        return "mouse up";
		      case SWT.MouseMove:
		        return "mouse move";
		      case SWT.MouseEnter:
		        return "mouse enter";
		      case SWT.MouseExit:
		        return "mouse exit";
		      case SWT.MouseDoubleClick:
		        return "mouse double click";
		      case SWT.Paint:
		        return "paint";
		      case SWT.Move:
		        return "move";
		      case SWT.Resize:
		        return "resize";
		      case SWT.Dispose:
		        return "dispose";
		      case SWT.Selection:
		        return "selection";
		      case SWT.DefaultSelection:
		        return "default selection";
		      case SWT.FocusIn:
		        return "focus in";
		      case SWT.FocusOut:
		        return "focus out";
		      case SWT.Expand:
		        return "expand";
		      case SWT.Collapse:
		        return "collapse";
		      case SWT.Iconify:
		        return "iconify";
		      case SWT.Deiconify:
		        return "deiconify";
		      case SWT.Close:
		        return "close";
		      case SWT.Show:
		        return "show";
		      case SWT.Hide:
		        return "hide";
		      case SWT.Modify:
		        return "modify";
		      case SWT.Verify:
		        return "verify";
		      case SWT.Activate:
		        return "activate";
		      case SWT.Deactivate:
		        return "deactivate";
		      case SWT.Help:
		        return "help";
		      case SWT.DragDetect:
		        return "drag detect";
		      case SWT.Arm:
		        return "arm";
		      case SWT.Traverse:
		        return "traverse";
		      case SWT.MouseHover:
		        return "mouse hover";
		      case SWT.HardKeyDown:
		        return "hard key down";
		      case SWT.HardKeyUp:
		        return "hard key up";
		      case SWT.MenuDetect:
		        return "menu detect";
		}
		return null;
	}

	
}




















