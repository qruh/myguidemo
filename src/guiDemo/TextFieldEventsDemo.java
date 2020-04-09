package guiDemo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TextFieldEventsDemo {
	
	Display display;
	Shell shell;
	Text text;
	Label label;
	
	public void showGui() {
		display = new Display();
		shell = new Shell(display);
		
		text = new Text(shell, SWT.BORDER);
		text.setSize(100, 25);
		text.setLocation(20,20);
		
		label = new Label(shell,SWT.BORDER);
		label.setSize(100, 25);
		label.setLocation(20,60);
		
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
