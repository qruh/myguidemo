package app;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import dataTypeDemo.DataTypeDemo;
import guiDemo.ButtonDemo;
import guiDemo.ButtonStyleDemo;
import guiDemo.CenterWindowDemo;
import guiDemo.DateTimeDemo;
import guiDemo.MultipleShells;
import guiDemo.QuitButton;
import guiDemo.TextFieldEventsDemo;
import guiDemo.ToolTipDemo;
import menuToolbars.MenuToolbar;
import regularExpression.RegularExpressionDemo;
import swtDialogs.SwtDialog;
import swtLayout.LayoutDemo;
import swtLayout.MyForm;
import swtPainting.ColorsDemo;
import swtTableWidget.TableWidget;
import swtWidgets.WidgetsDemo;

public class App {
	
	static Display display;
	static Shell shell;
	static Combo combo;
	
	public static void main(String[] args) {
		
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM);
		
		combo = new Combo(shell, SWT.DROP_DOWN);
		combo.setLocation(10,10);		
		String [] items = {"","Button Demo","DateTime Demo","Centered Window"
				,"show Tooltip","Button Styles","Textfield Event"};
		combo.setItems(items);
		combo.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				Combo c = (Combo) event.widget;
				int i = c.getSelectionIndex();
				
				switch(i) {
				case 1:
					ButtonDemo buttonDemo=new ButtonDemo();
					buttonDemo.showButtonDemo(shell);
					break;
				case 2:
					DateTimeDemo dt = new DateTimeDemo();
					dt.showDateTime(shell);
					break;
				case 3:
					CenterWindowDemo centerWindow = new CenterWindowDemo();
					centerWindow.showCenterWindow(shell);
					break;
				case 4:
					ToolTipDemo tooltip = new ToolTipDemo();
					tooltip.showToolTip(shell);
					break;
				case 5:
					ButtonStyleDemo buttonStyle = new ButtonStyleDemo();
					buttonStyle.showGui(shell);	
					break;
				case 6:
					TextFieldEventsDemo textDemo = new TextFieldEventsDemo();
					textDemo.showGui(shell);
					break;
				}
			}
			
		}); //new MyComboListener());
		combo.pack();
		
		//ButtonDemo buttonDemo=new ButtonDemo();
		//buttonDemo.showButtonDemo();
		
		//DateTimeDemo dt = new DateTimeDemo();
		//dt.showDateTime();
		
		//CenterWindowDemo centerWindow = new CenterWindowDemo();
		//centerWindow.showCenterWindow();
		
		//ToolTipDemo tooltip = new ToolTipDemo();
		//tooltip.showToolTip();
		
		QuitButton quitButton = new QuitButton();
		//quitButton.showGui();
		
		//ButtonStyleDemo buttonStyle = new ButtonStyleDemo();
		//buttonStyle.showGui();	
		
		//TextFieldEventsDemo textDemo = new TextFieldEventsDemo();
		//textDemo.showGui();
		
		LayoutDemo layoutDemo = new LayoutDemo();
		//layoutDemo.showGuiAbsolute();
		//layoutDemo.showGuiFillLayout();
		//layoutDemo.showGuiRowLayout();
		//layoutDemo.showGuiButtons();
		//layoutDemo.showGuiNewFolder();
		//layoutDemo.showGuiFormData();
		//layoutDemo.showGuiGridLayout();
		//layoutDemo.showGuiCalculator();
		
		
		MenuToolbar menuToolbar = new MenuToolbar();
		//menuToolbar.showSimpleMenu();
		//menuToolbar.showSubMenu();
		//menuToolbar.showCheckMenuItem();	
		//menuToolbar.showPopUpMenu();
		//menuToolbar.showSimpleToolbar();
		
		WidgetsDemo widgets = new WidgetsDemo();
		//widgets.showLabel();
		//widgets.showCheckButton();
		//widgets.showSpinner();
		//widgets.showListWidget();
		//widgets.showSlider();
		//widgets.showComboWidget();
		
		TableWidget tableWidget = new TableWidget();
		//tableWidget.showEmptyTable();
		//tableWidget.showFilledTable();
		//tableWidget.showSelectingRow();
		//tableWidget.showTableAddItems();
		
		SwtDialog dialog = new SwtDialog();
		//dialog.showMessageBox();
		//dialog.showApplicationClosing();
		//dialog.showDirectoryDialog();
		//dialog.showFontDialog();
		//dialog.showFontDialog();
		//dialog.showColorDialog();
		//dialog.showFileDialog();
		
		ColorsDemo colors = new ColorsDemo();
		//colors.showColorsDemo();
		//colors.showLineStyles();
		//colors.showBasicShapes();
		//colors.showPolygon();
		//colors.showTransparentRectangles();
		//colors.showDonut();
		//colors.showDrawingText();
		//colors.showTextLayoutStyleColor();
		
		DataTypeDemo typeDemo = new DataTypeDemo();
		//typeDemo.showDataTypes();
		
		RegularExpressionDemo regexDemo = new RegularExpressionDemo();
		//regexDemo.findWordsA("das auto ist im autohaus");
		//System.out.println(regexDemo.toString());
		//System.out.println(regexDemo);
		
		MyForm myForm = new MyForm();
		//myForm.showMyForm();
		
		shell.setText("Gui");
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











