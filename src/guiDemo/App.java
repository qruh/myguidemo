package guiDemo;

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
		textDemo.showGui();
	}
}
