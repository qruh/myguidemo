package swtDialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class SwtDialog {
	
	Display display;
	Shell shell;
	
	public void showMessageBox() {
		
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		RowLayout layout = new RowLayout();
		layout.marginTop = 50;
		layout.marginBottom = 150;
		layout.marginLeft = 50;
		layout.marginRight = 150;
		
		shell.setLayout(layout);
		
		Button msgBtn = new Button(shell, SWT.PUSH);
		msgBtn.setText("Show message");
		msgBtn.addListener(SWT.Selection, event -> {
			int style = SWT.ICON_INFORMATION | SWT.OK;
			
			MessageBox dia = new MessageBox(shell, style);
			dia.setText("Information");
			dia.setMessage("Download completed");
			dia.open();
		});
		
		shell.setText("Message box");
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public void showApplicationClosing() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		shell.addListener(SWT.Close, event -> {
			int style = SWT.APPLICATION_MODAL | SWT.ICON_QUESTION | SWT.YES | SWT.NO ;
			
			MessageBox messageBox = new MessageBox(shell, style);
			messageBox.setText("Information");
			messageBox.setMessage("Really close application");
			event.doit = messageBox.open() == SWT.YES;		
			//boolean result = messageBox.open() == SWT.YES;
		});
		
		shell.setText("Message Box");
		shell.setSize(350,300);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public void showDirectoryDialog() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		Label status = new Label(shell, SWT.BORDER);
		status.setText("Ready");
		
		FormLayout layout = new FormLayout();
		shell.setLayout(layout);
		
		FormData labelData = new FormData();
		labelData.left = new FormAttachment(0);
		labelData.right = new FormAttachment(100);
		labelData.bottom = new FormAttachment(100);
		status.setLayoutData(labelData);
		
		shell.addListener(SWT.MouseDown, event -> {
			DirectoryDialog dialog = new DirectoryDialog(shell);
			String path = dialog.open();
			
			if(path != null) {
				status.setText(path);
			}
		});
		
		shell.setText("DirectoryDialog");
		shell.setSize(350,300);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public void showFontDialog() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		RowLayout layout = new RowLayout();
		layout.marginHeight = 100;
		layout.marginWidth = 100;
		shell.setLayout(layout);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("ZetCode Java SWT tutorial");
		
		shell.addListener(SWT.MouseDown, event -> {
			FontDialog fontDialog = new FontDialog(shell);
			FontData fontData = fontDialog.open();
			
			if(fontData != null) {
				Font font = new Font(shell.getDisplay(), fontData);
				
				label.setFont(font);
				label.pack();
				shell.pack();
				font.dispose();
			}
		});
		
		shell.setText("Font Dialog");
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public void showColorDialog() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		RowLayout layout = new RowLayout();
		layout.marginHeight = 100;
		layout.marginWidth = 100;
		shell.setLayout(layout);
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("ZetCode Java SWT tutorial");
		
		shell.addListener(SWT.MouseDown, event -> {
			ColorDialog dialog = new ColorDialog(shell);
			RGB rgb = dialog.open();
			
			if(rgb != null) {
				Color col = new Color(shell.getDisplay(), rgb);
				label.setForeground(col);
				col.dispose();
			}
		});
		
		shell.setText("Color Dialog");
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}	
	public void showFileDialog() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		RowLayout layout = new RowLayout();
		layout.marginHeight = 50;
		layout.marginWidth = 50;
		shell.setLayout(layout);
		
		Label label = new Label(shell, SWT.NONE);
		String homeDir = System.getProperty("user.home");
		
		label.setText(homeDir);
		label.pack();
		
		shell.addListener(SWT.MouseDown, event -> {
			FileDialog dialog = new FileDialog(shell, SWT.OPEN);
			
			String [] filterNames = new String[] {"Java sources", "All Files (*)"};
			String [] filterExtensions = new String[] {"*.java","*"};
			
			dialog.setFilterNames(filterNames);
			dialog.setFilterExtensions(filterExtensions);
			
			String path = dialog.open();
			
			if(path != null) {
				label.setText(path);
				label.pack();
				shell.pack();
			}
		});
		
		shell.setText("File Dialog");
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
























