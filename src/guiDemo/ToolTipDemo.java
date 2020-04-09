package guiDemo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ToolTipDemo {
	Shell shell;
	Display display;
	
	Button button1;
	Text text1;
	
	static int counter=0;
	
	public void showToolTip() {
		
		display = new Display();
		shell = new Shell(display, (SWT.SHELL_TRIM | SWT.CENTER) & (~SWT.RESIZE));
		
		button1 = new Button(shell, SWT.PUSH);
		button1.setText("click me");
		button1.setBounds(160,40,80,25);
		button1.setToolTipText("This is a button.");
		button1.addSelectionListener( new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				setTextfiledText();
				
			}

			private void setTextfiledText() {
				counter++;
				text1.setText("button clicked " + counter);							
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
						
		text1 = new Text(shell, SWT.BORDER | SWT.CENTER);
		text1.setSize(100, 25);
		text1.setLocation(150, 80);
		text1.setToolTipText("This is a Textfield.");
				
		shell.setText("ToolTip Demo");
		shell.setSize(400, 300);
		shell.setToolTipText("This is a Shell-Window.");
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
