package guiDemo;

import org.eclipse.swt.widgets.Shell;

public class MultipleShells {
	Shell shell;
	
	public void showChildShell(Shell parent) {
		shell = new Shell(parent);
		shell.setSize(150,200);
		shell.open();
	}	
}
