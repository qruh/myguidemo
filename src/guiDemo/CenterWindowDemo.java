package guiDemo;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CenterWindowDemo {
	Shell shell;
	Display display;
	Rectangle bds;
	Point p;
	
	public void showCenterWindow() {
		display = new Display();
		shell = new Shell(display);
		shell.setText("Center");
		shell.setSize(250,200);		
				
		bds  = shell.getDisplay().getBounds();
		p=shell.getSize();
		
		int nLeft = (bds.width - p.x) / 4;
		int nTop = (bds.height - p.y) / 2;
		
		shell.setBounds(nLeft, nTop, p.x, p.y);	
		shell.open();
		
		while(!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	

}
