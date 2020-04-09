package guiDemo;



import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

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
		buttonStyle.showGui();
	}
	
	
	
	

}
