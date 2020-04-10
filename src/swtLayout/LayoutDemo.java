package swtLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class LayoutDemo {
	
	Display display;
	Shell shell;
	Button button1, button2;
	Device dev;
	Image castle;
	Label label;
	Rectangle rect;
	
	public void showGuiAbsolute() {
		display = new Display();
		shell = new Shell(display);
		
		button1 = new Button(shell, SWT.PUSH);
		button1.setText("Button 1");
		button1.setBounds(20,50,80,30);
		
		button2 = new Button(shell, SWT.PUSH);
		button2.setText("Button 2");
		button2.setSize(80,30);
		button2.setLocation(50,100);
		
		shell.setText("Absolute layout");
		shell.setSize(300,200);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public void showGuiFillLayout() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		//load image
		loadImage(shell);
		
		label = new Label(shell, SWT.IMAGE_PNG);
		label.setImage(castle);
		
		shell.setText("FillLayout");
		rect = castle.getBounds();
		shell.setSize(rect.width,rect.height);
		shell.open();
		
		while (!shell.isDisposed()) {
	          if (!display.readAndDispatch()) {
	            display.sleep();
	          }
	    }
		display.dispose();		
	}
	private void loadImage(Shell shell) {
		
		dev = shell.getDisplay();
		
		try {
			castle = new Image(dev, "redrock.png");			
		}
		catch(Exception e) {
			System.out.println("Cannot load image");
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
}
















