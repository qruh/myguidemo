package guiDemo;

import dataTypeDemo.DataTypeDemo;
import menuToolbars.MenuToolbar;
import regularExpression.RegularExpressionDemo;
import swtDialogs.SwtDialog;
import swtLayout.LayoutDemo;
import swtPainting.ColorsDemo;
import swtTableWidget.TableWidget;
import swtWidgets.WidgetsDemo;

public class App {
	
	public static void main(String[] args) {
		
		ButtonDemo buttonDemo=new ButtonDemo();
		//buttonDemo.showButtonDemo();
		
		DateTimeDemo dt = new DateTimeDemo();
		//dt.showDateTime();
		
		CenterWindowDemo centerWindow = new CenterWindowDemo();
		//centerWindow.showCenterWindow();
		
		ToolTipDemo tooltip = new ToolTipDemo();
		//tooltip.showToolTip();
		
		QuitButton quitButton = new QuitButton();
		//quitButton.showGui();
		
		ButtonStyleDemo buttonStyle = new ButtonStyleDemo();
		//buttonStyle.showGui();	
		
		TextFieldEventsDemo textDemo = new TextFieldEventsDemo();
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
		
		layoutDemo.showMyForm();
		
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
	}
}











