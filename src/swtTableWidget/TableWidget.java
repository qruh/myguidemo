package swtTableWidget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class TableWidget {
	
	Display display;
	Shell shell;
	
	public void showEmptyTable() {
		
		display = new Display();
		shell = new Shell(display);
		shell.setLayout(new GridLayout());
		
		Table table = new Table(shell, SWT.BORDER);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.heightHint = 300;
		gridData.widthHint = 360;
		table.setLayoutData(gridData);
		
		String [] titles = {"A","B","C"};
		
		for(int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.CENTER);
			column.setWidth(120);
			column.setText(titles[i]);			
		}
		
		for(int i = 0; i < 15; i++) {
			TableItem item = new TableItem(table, SWT.NONE);			
		}
		
		shell.setText("Empty table");
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public void showFilledTable() {
		display = new Display();
		shell = new Shell(display, SWT.DIALOG_TRIM | SWT.CENTER);
		shell.setLayout(new FillLayout());
		
		Table table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
		TableColumn tc2 = new TableColumn(table, SWT.CENTER);
		TableColumn tc3 = new TableColumn(table, SWT.CENTER);
		
		tc1.setText("First Name");
		tc2.setText("Last Name");
		tc3.setText("Profession");
		
		tc1.setWidth(70);
		tc2.setWidth(70);
		tc3.setWidth(80);
		
		TableItem item1 = new TableItem(table, SWT.NONE);
		item1.setText(new String [] {"Jane", "Brown", "Accountant"});
		TableItem item2 = new TableItem(table, SWT.NONE);
		item2.setText(new String [] {"Tim","Warner","Lawyer"});;
		TableItem item3 = new TableItem(table, SWT.NONE);
		item3.setText(new String [] {"Bob","Milton","Police officer"});
		
		shell.setText("Table widget");
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		display.dispose();
	}
	public void showSelectingRow() {
		
		String data [][] = { {"Ferarri", "33333"},{"Skoda","22000"},{"Volvo","18000"},{"Mazda","15000"},{"Mercedes","3800"} };
		
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		shell.setLayout(new GridLayout(1, true));
		
		Table table = new Table(shell, SWT.BORDER);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		String [] titles = {"Car", "Price"};
		
		for(int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NULL);
			column.setText(titles[i]);
			column.setWidth(130);
		}
		
		for(int i = 0; i < data.length; i++) {
			TableItem item = new TableItem(table, SWT.NULL);
			item.setText(0, data[i][0]);
			item.setText(1, data[i][1]);
		}
		
		Label label = new Label(shell, SWT.NONE);
		
		table.addListener(SWT.Selection, event -> onTableItemSelected(table, label));
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.widthHint = 360;
		gd.heightHint = 300;
		table.setLayoutData(gd);
		
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		shell.setText("Table widget");
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	private void onTableItemSelected(Table table, Label label) {
		TableItem[] sel = table.getSelection();
		String msg = String.format("%s: %s", sel[0].getText(0), sel[0].getText(1));
		label.setText(msg);
	}
	public void showTableAddItems() {
		
		String data [][] = { {"Ferarri", "33333"},{"Skoda","22000"},{"Volvo","18000"},{"Mazda","15000"},{"Mercedes","3800"} };
		
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		shell.setLayout(new GridLayout(5,false));
		
		Table table = new Table(shell, SWT.BORDER | SWT.MULTI);
		table.setHeaderVisible(true);
		
		String [] titles = {"Car", "Price"};
		
		for(int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NULL);
			column.setText(titles[i]);
			column.setWidth(130);
		}
		
		for(int i = 0; i < data.length; i++) {
			TableItem item = new TableItem(table, SWT.NULL);
			item.setText(0, data[i][0]);
			item.setText(1, data[i][1]);
		}
		
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.horizontalSpan =5;
		gd.widthHint = 360;
		gd.heightHint = 300;
		table.setLayoutData(gd);
				
		Label carName = new Label(shell, SWT.NONE);
		carName.setText("Car:");
		Text text1 = new Text(shell, SWT.BORDER);
		
		Label priceOfCar = new Label(shell, SWT.NONE);
		priceOfCar.setText("Price:");
		Text text2 = new Text(shell, SWT.BORDER);
		
		text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Button addBtn = new Button(shell, SWT.PUSH);
		addBtn.setText("Insert");
		addBtn.addListener(SWT.Selection, event -> {
			String val1 = text1.getText();
			String val2 = text2.getText();
			
			if(val1.isEmpty() || val2.isEmpty()) {
				return;
			}
			
			TableItem item = new TableItem(table, SWT.NULL);
			item.setText(0, val1);
			item.setText(1, val2);
			
			text1.setText("");
			text2.setText("");
		});
		
		shell.setText("Table Widget");
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




















