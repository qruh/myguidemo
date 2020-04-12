package swtLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class LayoutDemo {
	
	Display display;
	Shell shell;
	Device dev;
	Image castle;	
	
	public void showGuiAbsolute() {
		Button button1, button2;
		
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
		
		Label label;
		Rectangle rect;
		
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER );
		shell.setLayout(new FillLayout());
				
		//load image
		loadImage(shell);
				
		label = new Label(shell, SWT.IMAGE_PNG);
		label.setImage(castle);
		Button btn = new Button(shell, SWT.PUSH);
		btn.setText("Button Size 50,50");
		btn.setSize(50,50);
		
		shell.setText("FillLayout");
		rect = castle.getBounds();
		shell.setSize(rect.width,rect.height);
		shell.open();
		
		while (!shell.isDisposed()) {
	          if (!display.readAndDispatch()) {
	            display.sleep();
	          }
	    }
		castle.dispose();
		display.dispose();		
	}
	private void loadImage(Shell shell) {
		
		dev = shell.getDisplay();
		
		try {
			castle = new Image(dev, "images/redrock.png");			
		}
		catch(Exception e) {
			System.out.println("Cannot load image");
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	public void showGuiRowLayout() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.marginTop=10;
		rowLayout.marginBottom=10;
		rowLayout.marginLeft=5;
		rowLayout.marginLeft=5;
		rowLayout.marginRight=5;
		rowLayout.spacing=10;
		
		shell.setLayout(rowLayout);
		
		Button btn1 = new Button(shell, SWT.PUSH);
		btn1.setText("Button 1");
		btn1.setLayoutData(new RowData(80,30));
		
		Button btn2 = new Button(shell, SWT.PUSH);
		btn2.setText("Button 2");
		btn2.setLayoutData(new RowData(80,30));
		
		Button btn3 = new Button(shell, SWT.PUSH);
		btn3.setText("Button 3");
		btn3.setLayoutData(new RowData(80,30));
		
		shell.setText("RowLayout");
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public void showGuiButtons() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		FormLayout layout = new FormLayout();
		shell.setLayout(layout);
		
		Button okBtn = new Button(shell, SWT.PUSH);
		okBtn.setText("OK");
		
		Button cancelBtn = new Button(shell, SWT.PUSH);
		cancelBtn.setText("Cancel");
		
		FormData cancelData = new FormData(80,30);
		cancelData.right = new FormAttachment(98);
		cancelData.bottom = new FormAttachment(95);
		cancelBtn.setLayoutData(cancelData);
		
		FormData okData = new FormData(80,30);
		okData.right = new FormAttachment(cancelBtn, -5, SWT.LEFT);
		okData.bottom = new FormAttachment(cancelBtn, 0, SWT.BOTTOM);
		okBtn.setLayoutData(okData);
		
		shell.setText("Buttons");
		shell.setSize(350,200);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
















