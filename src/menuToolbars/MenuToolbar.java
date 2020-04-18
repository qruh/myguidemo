package menuToolbars;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import myUtilities.MyImage;

public class MenuToolbar {

	Display display;
	Shell shell;
	
	public void showSimpleMenu() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		Menu menuBar = new Menu(shell, SWT.BAR );		
		
		MenuItem cascadeFileMenu = new MenuItem(menuBar,SWT.CASCADE); //| SWT.COLOR_BLUE);		
		cascadeFileMenu.setText("&File");
		MenuItem cascadeEditMenu = new MenuItem(menuBar, SWT.CASCADE);
		cascadeEditMenu.setText("Edit");
		
		Menu fileMenu = new Menu(shell,SWT.DROP_DOWN);
		cascadeFileMenu.setMenu(fileMenu);
		Menu editMenu = new Menu(shell, SWT.DROP_DOWN);
		cascadeEditMenu.setMenu(editMenu);
		
		MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH); // | SWT.COLOR_DARK_MAGENTA);
		exitItem.setText("&Exit");		
		
				
		exitItem.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				shell.getDisplay().dispose();
				System.exit(0);
			}			
		});				
				/* anstatt ...new Listerner(){}: event->{
			shell.getDisplay().dispose();
			System.exit(0);
		} );*/
		
		MenuItem copyItem = new MenuItem(editMenu, SWT.PUSH);
		copyItem.setText("&Copy");
				
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
	public void showSubMenu() {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Date date = new Date();
		
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER );
		
		Label label = new Label(shell, SWT.BORDER);
		label.setSize(100,25);
		label.setLocation(5,5);
		
		Menu menuBar = new Menu(shell, SWT.BAR);
		
		MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
		cascadeFileMenu.setText("&File");
		
		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		cascadeFileMenu.setMenu(fileMenu);
		
		MenuItem subMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
		subMenuItem.setText("Import");
		
		Menu subMenu = new Menu (shell, SWT.DROP_DOWN);
		subMenuItem.setMenu(subMenu);
		
		MenuItem feedItem = new MenuItem(subMenu, SWT.PUSH);
		feedItem.setText("&Import news feed...");
		
		MenuItem bmarks = new MenuItem(subMenu, SWT.PUSH);
		bmarks.setText("&Import bookmarks...");
		
		MenuItem mailItem = new MenuItem(subMenu, SWT.PUSH);
		mailItem.setText("&Import mail...");
		
		MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
		exitItem.setText("&Exit");
		exitItem.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				shell.getDisplay().dispose();
				System.exit(0);
			}			
		});
		
		MenuItem cascadeEditMenu = new MenuItem(menuBar, SWT.CASCADE);
		cascadeEditMenu.setText("&Edit");
				
		Menu editMenu = new Menu(shell, SWT.DROP_DOWN);
		cascadeEditMenu.setMenu(editMenu);		
		MenuItem copyItem = new MenuItem(editMenu, SWT.PUSH);
		copyItem.setText("Copy");		
		
		MenuItem pasteItem = new MenuItem(editMenu, SWT.CASCADE);
		pasteItem.setText("Paste");	
		Menu subPasteMenu = new Menu(shell, SWT.DROP_DOWN);
		pasteItem.setMenu(subPasteMenu);	
		MenuItem subPasteItem = new MenuItem(subPasteMenu, SWT.PUSH);
		subPasteItem.setText("Paste in form...");
		subPasteItem.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				label.setText(dateFormat.format(date));				
			}			
		});
		
		shell.setMenuBar(menuBar);
		shell.setText("Submenu");
		shell.setSize(300,250);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public void showCheckMenuItem() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		Menu menuBar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menuBar);
		
		MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
		cascadeFileMenu.setText("&File");
		
		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		cascadeFileMenu.setMenu(fileMenu);
		
		MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
		exitItem.setText("&Exit");
		
		MenuItem cascadeViewMenu = new MenuItem(menuBar, SWT.CASCADE);
		cascadeViewMenu.setText("&View");
		
		Menu viewMenu = new Menu(shell, SWT.DROP_DOWN);
		cascadeViewMenu.setMenu(viewMenu);
		
		Label status = new Label(shell, SWT.BORDER);
		status.setText("Ready");
		
		MenuItem statItem = new MenuItem(viewMenu, SWT.CHECK);
		statItem.setSelection(true);
		statItem.setText("&View Statusbar");
		
		statItem.addListener(SWT.Selection, new MyStatusListener(statItem,status));
		
		exitItem.addSelectionListener(new MySelectionAdapter());
		
		
		FormLayout layout = new FormLayout();
		shell.setLayout(layout);
		
		FormData labelData = new FormData();
		labelData.left = new FormAttachment(0);
		labelData.right = new FormAttachment(100);
		labelData.bottom = new FormAttachment(100);
		status.setLayoutData(labelData);
		
		shell.setText("Check menu item");
		shell.setSize(300,250);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
	private class MyStatusListener implements Listener{
		MenuItem statItem;
		Label status;
		
		public MyStatusListener(MenuItem item, Label label){
			statItem = item;
			status = label;			
		}
		@Override
		public void handleEvent(Event event) {
			if(statItem.getSelection()) {
				status.setVisible(true);
			}
			else {
				status.setVisible(false);
			}
		}	
	}
	
	private class MySelectionAdapter extends SelectionAdapter{
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			shell.getDisplay().dispose();
			System.exit(0);			
		}
		
	}
	
	public void showPopUpMenu() {
		display = new Display();
		shell = new Shell(display);
		
		Menu menu = new Menu(shell, SWT.POP_UP);
		MenuItem minItem = new MenuItem(menu, SWT.PUSH);
		minItem.setText("Minimize");
		
		minItem.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				shell.setMinimized(true);
			}			
		});
		
		MenuItem exitItem = new MenuItem(menu, SWT.PUSH);
		exitItem.setText("Exit");
		exitItem.addListener(SWT.Selection, event -> {
			shell.getDisplay().dispose();
			System.exit(0);
		});
		
		shell.setText("Popup menu");
		shell.setMenu(menu);
		shell.setSize(300,250);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();		
	}
	public void showSimpleToolbar() {
		
		Image newi = null;
		Image  opei = null;
		Image quii = null;
		
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		Device dev = shell.getDisplay();
	
		try {
			MyImage myImage = new MyImage();			
			newi = new Image(dev, "images/newi.png");
			newi = myImage.resizeImage(dev,newi, 50,50);			
			opei = new Image(dev, "images/opei.png");
			opei = myImage.resizeImage(dev, opei, 50,50);
			quii = new Image(dev, "images/quii.png");
			quii = myImage.resizeImage(dev, quii,50,50);
		}
		catch (Exception e){
			System.out.println("Cannot load images");
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		ToolBar toolBar = new ToolBar(shell,  SWT.FLAT );
		
		ToolItem item1 = new ToolItem(toolBar, SWT.PUSH );
		item1.setImage(newi);
		
		ToolItem item2 = new ToolItem(toolBar, SWT.PUSH );		
		item2.setImage(opei);
		
		ToolItem separator = new ToolItem(toolBar, SWT.SEPARATOR | SWT.FILL );
		
		ToolItem item3 = new ToolItem(toolBar, SWT.PUSH);
		item3.setImage(quii);
		
		toolBar.pack();
		
		item3.addListener(SWT.Selection, event -> {
			shell.getDisplay().dispose();
			System.exit(0);
		});
		
		shell.setText("Simple toolbar");
		shell.setSize(300,250);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		newi.dispose();
		opei.dispose();
		quii.dispose();
		display.dispose();		
	}	
}


























