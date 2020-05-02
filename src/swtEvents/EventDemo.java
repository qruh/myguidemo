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




















package swtEvents;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
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

	// ***
	// Implements general Event Listener
	// ***
	public void showListenerGeneral(Shell parent, Display d) {
		display = d;
		shell = new Shell(display);
		shell.setLayout(new GridLayout());
		
		Label label = new Label(shell, SWT.BORDER | SWT.CENTER);
		label.setText("Point your cursor here...");
		label.setBounds(30,30,200,30);
		
		Listener listener = new MouseEnterExitListener();
		label.addListener(SWT.MouseEnter, listener);
		label.addListener(SWT.MouseExit, listener);
		
		shell.setSize(260,120);
		shell.open();
	}
	class MouseEnterExitListener implements Listener{

		@Override
		public void handleEvent(Event event) {
			switch(event.type) {
			case SWT.MouseEnter:
				System.out.println("Cursor enters the label");
				break;
			case SWT.MouseExit:
				System.out.println("Cursor leaves the label");
				break;
			}
		}		
	}
	
	// ***
	// SelectionListener Event
	// ***
	public void showSelectionAdapter(Shell parent, Display d) {
		display = d;
		shell = new Shell(parent);
		shell.setLayout(new GridLayout());
		
		Button button = new Button(shell, SWT.NONE);
		button.setText("Click and check the console");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				System.out.println("selection event occured");
			}
		});
				
		shell.setSize(300,300);
		shell.open();
	}
	
	// ***
	// Listener for Shell resize
	// ***
	public void showListenerShellResize(Shell parent, Display d) {
		display = d;
		shell = new Shell(parent, SWT.SHELL_TRIM);// | SWT.H_SCROLL | SWT.V_SCROLL);
		
		Listener listener = new ShellResizeListener();
		shell.addListener(SWT.Resize, listener);
		
		shell.open();
	}
	class ShellResizeListener implements Listener{

		@Override
		public void handleEvent(Event event) {
			System.out.println("my Event Class");
			Rectangle rect = shell.getClientArea();
			System.out.println(rect);
		}		
	}
	
	// ***
	// PaintListener
	// ***
	public void showCompositePaintListener(Shell parent, Display d) {
		display = d;
		shell = new Shell(parent, SWT.SHELL_TRIM | SWT.H_SCROLL | SWT.V_SCROLL);
		
		Composite composite = new Composite(shell, SWT.BORDER);
		composite.setSize(700,600);
		
		Color red = display.getSystemColor(SWT.COLOR_RED);
		composite.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				System.out.println("paintevent");
				e.gc.setBackground(red);
				e.gc.fillOval(5, 5, 690, 590);
			}			
		});
		
		shell.open();		
	}
	
	// ***
	// Combo Selection Listener
	// ***
	public void showComboSelectionListener(Shell parent, Display d) {
		display = d;
		shell = new Shell(display);
		shell.setLayout(new RowLayout());
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"A-1","B-1","C-1"});
		
		combo.addListener(SWT.DefaultSelection, new Listener() {

			
			public void handleEvent(Event event) {
				System.out.println( " - Default Selection");
			}			
		});
		
		shell.pack();
		shell.open();
	}
	
	
}




















