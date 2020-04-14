package menuToolbars;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MenuToolbar {

	Display display;
	Shell shell;
	
	public void showSimpleMenu() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		Menu menuBar = new Menu(shell, SWT.BAR );		
		MenuItem cascadeFileMenu = new MenuItem(menuBar,SWT.CASCADE); //| SWT.COLOR_BLUE);		
		cascadeFileMenu.setText("&File");
		
		Menu fileMenu = new Menu(shell,SWT.DROP_DOWN);
		cascadeFileMenu.setMenu(fileMenu);
		
		MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH); // | SWT.COLOR_DARK_MAGENTA);
		exitItem.setText("&Exit");		
		shell.setMenuBar(menuBar);;
		
		exitItem.addListener(SWT.Selection, event->{
			shell.getDisplay().dispose();
			System.exit(0);
		} );
		
		shell.setMenuBar(menuBar);
		
		shell.setText("Simple menu");
		shell.setSize(300,200);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}	
}
