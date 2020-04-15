package guiDemo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class QuitButton {
	
	Display display;
	Shell shell;
	Button quitBtn;
	
	public void showGui() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		RowLayout layout = new RowLayout();
		layout.marginLeft = 85;
		layout.marginTop = 50;
		shell.setLayout(layout);
		
		quitBtn = new Button(shell, SWT.PUSH );
		quitBtn.setText("Quit");
		quitBtn.setLayoutData(new RowData(80,30));
		
		quitBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.getDisplay().dispose();
				System.exit(0);
			}
		});
		
		shell.setText("Quit button");
		shell.setSize(250,200);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}	
}
