package guiDemo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ButtonDemo {
	
	Display display;
	Shell shell;
	Button button1,button2;
	Text text1;	
	
	public void showButtonDemo() {
		
		display = new Display();
		shell = new Shell(display);
		
		button1 = new Button(shell, SWT.PUSH);
		button1.setText("Close");
		button1.setBounds(75,40,80,30);
		button1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				changeTextField();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		button2 = new Button(shell, SWT.PUSH);
		button2.setText("Cancel");
		button2.setSize(80,30);
		button2.setLocation(75, 75);
		button2.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				clearTextField();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		text1 = new Text(shell, SWT.BORDER);
		text1.setSize(100, 30);
		text1.setLocation(75, 110);
		
		
		shell.setText("SWT Demo");
		shell.setSize(300, 200);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	private void changeTextField() {
		text1.setText("Button clicked");
	}
	private void clearTextField() {
		text1.setText("");
	}

}
