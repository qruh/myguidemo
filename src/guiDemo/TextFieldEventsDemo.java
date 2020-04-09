package guiDemo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TextFieldEventsDemo {
	
	Display display;
	Shell shell;
	Text text;
	Label label;
	Button quitBtn;
	
	public void showGui() {
		display = new Display();
		shell = new Shell(display);
		
		text = new Text(shell, SWT.SINGLE | SWT.BORDER);
		text.setSize(100, 25);
		text.setLocation(20,20);
		text.addListener(SWT.KeyDown, new Listener() {

			@Override
			public void handleEvent(Event event) {
				label.setText("Key pressed: "+event.character);
			}
			
		});
		text.addTraverseListener(new TraverseListener() {
			
			@Override
			public void keyTraversed(TraverseEvent e) {
				if(e.detail == SWT.TRAVERSE_TAB_NEXT || e.detail == SWT.TRAVERSE_TAB_PREVIOUS) {
					e.doit=true;
					label.setText("traverse event");
				}
			}
		}); 
		
		label = new Label(shell,SWT.BORDER);
		label.setSize(100, 25);
		label.setLocation(20,60);
		
		quitBtn = new Button(shell, SWT.PUSH);
		quitBtn.setText("Close");
		quitBtn.setBounds(20, 100, 50, 100);
		quitBtn.pack();
		quitBtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.getDisplay().dispose();
				System.exit(0);					
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		shell.setSize(250, 200);
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
