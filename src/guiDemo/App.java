package guiDemo;

import menuToolbars.MenuToolbar;
import swtLayout.LayoutDemo;

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
		
		MenuToolbar menuToolbar = new MenuToolbar();
		//menuToolbar.showSimpleMenu();
		//menuToolbar.showSubMenu();
		menuToolbar.showCheckMenuItem();		
		
	}
}











