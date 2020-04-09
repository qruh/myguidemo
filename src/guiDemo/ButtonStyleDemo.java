package guiDemo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class ButtonStyleDemo {
	
	Shell shell;
	Display display;
	
	Group groupCheckBox, groupRadioBtn;
	
	Button pushBtn, leftBtn, rightBtn, upBtn, downBtn, toggleBtn, radioBtn, quitBtn;
	Button [] checkBoxes;
	Button [] radioButtons;
	
	Label label;
	
	public void showGui() {	
		display = new Display();
		shell = new Shell(display);
		
		// push button
		pushBtn = new Button(shell, SWT.PUSH);
		pushBtn.setLocation(50,50);
		pushBtn.setText("Push Button");
		pushBtn.pack();
		pushBtn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				writeToTextfield("Push Button clicked");
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		// arrow button
		leftBtn = new Button(shell, SWT.ARROW | SWT.LEFT);
		leftBtn.setLocation(50, 100);
		leftBtn.setText("LEFT");
		leftBtn.pack();
		leftBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				writeToTextfield("Left-Arrow Button clicked");				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		rightBtn = new Button(shell, SWT.ARROW | SWT.RIGHT);
		rightBtn.setLocation(80, 100);
		rightBtn.setText("RIGHT");
		rightBtn.pack();
		rightBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				writeToTextfield("Right-Arrow Button clicked");				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		upBtn = new Button(shell, SWT.ARROW | SWT.UP);
		upBtn.setLocation(110, 100);
		upBtn.setText("UP");
		upBtn.pack();
		upBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				writeToTextfield("Up-Arrow Button clicked");				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		downBtn = new Button(shell, SWT.ARROW | SWT.DOWN);
		downBtn.setLocation(140, 100);
		downBtn.setText("DOWN");
		downBtn.pack();
		downBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				writeToTextfield("Down-Arrow Button clicked");				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// toggle Button
		toggleBtn = new Button(shell, SWT.TOGGLE);
		toggleBtn.setSelection(false);
		toggleBtn.setLocation(50, 150);
		toggleBtn.setText("Toggle Button");
		toggleBtn.pack();
		toggleBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				writeToTextfield("Toggle-Button clicked");				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// group element for checkboxes
		groupCheckBox = new Group(shell, SWT.SHADOW_IN);
		groupCheckBox.setLocation(50,200);
		groupCheckBox.setText("Group of Checkboxes (Shadow_IN)");
		
		// check box (Button)
		checkBoxes = new Button[3];
		checkBoxes[0] = new Button(groupCheckBox, SWT.CHECK);
		checkBoxes[0].setSelection(true);
		checkBoxes[0].setText("Choice 1");
		checkBoxes[0].setLocation(20,20);
		checkBoxes[0].pack();
		checkBoxes[0].addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(checkBoxes[0].getSelection()) {
					writeToTextfield("Check-Box 1 checked");
				}
				else {
					writeToTextfield("Check-Box 1 unchecked");
				}
					
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		checkBoxes[1] = new Button(groupCheckBox, SWT.CHECK);
		checkBoxes[1].setText("Choice 2");
		checkBoxes[1].setLocation(90, 20);
		checkBoxes[1].pack();
		checkBoxes[1].addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(checkBoxes[1].getSelection()) {
					writeToTextfield("Check-Box 2 checked");
				}
				else {
					writeToTextfield("Check-Box 2 unchecked");
				}
					
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		checkBoxes[2] = new Button(groupCheckBox, SWT.CHECK);
		checkBoxes[2].setText("Choice 3");
		checkBoxes[2].setLocation(160, 20);
		checkBoxes[2].pack();
		checkBoxes[2].addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(checkBoxes[2].getSelection()) {
					writeToTextfield("Check-Box 3 checked");
				}
				else {
					writeToTextfield("Check-Box 3 unchecked");
				}
					
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
		groupCheckBox.pack();
		
		// radio Button
		
		groupRadioBtn = new Group(shell, SWT.SHADOW_OUT);
		groupRadioBtn.setLocation(50,250);
		groupRadioBtn.setText("Group Radio-Button Shadow_OUT)");
		
		radioButtons = new Button[3];
		radioButtons[0] = new Button(groupRadioBtn, SWT.RADIO);
		radioButtons[0].setSelection(true);
		radioButtons[0].setText("Choice 1");
		radioButtons[0].setLocation(20, 20);
		radioButtons[0].pack();
		radioButtons[0].addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				writeToTextfield("Radio-Button 1 selected");				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		radioButtons[1] = new Button(groupRadioBtn, SWT.RADIO);
		radioButtons[1].setText("Choice 2");
		radioButtons[1].setLocation(90, 20);
		radioButtons[1].pack();
		radioButtons[1].addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				writeToTextfield("Radio-Button 2 selected");				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		radioButtons[2] = new Button(groupRadioBtn, SWT.RADIO);
		radioButtons[2].setText("Choice 3");
		radioButtons[2].setLocation(160, 20);
		radioButtons[2].pack();
		radioButtons[2].addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				writeToTextfield("Radio-Button 3 selected");				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		radioBtn = new Button(groupRadioBtn, SWT.RADIO);
		radioBtn.setText("out of array");
		radioBtn.setLocation(230, 20);
		radioBtn.pack();
		radioBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				writeToTextfield("Radio-Button out of Array selected");				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		groupRadioBtn.pack();
		
		label = new Label(shell, SWT.BORDER | SWT.CENTER);
		label.setSize(250,25);
		label.setLocation(50, 320);
		//label.pack();
		
		quitBtn = new Button(shell, SWT.PUSH);
		quitBtn.setText("&Close");
		quitBtn.setLocation(50, 370);
		quitBtn.pack();
		quitBtn.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				shell.getDisplay().dispose();
				System.exit(0);				
			}			
		});		
		/*quitBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.getDisplay().dispose();
				System.exit(0);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		*/
		
		shell.setSize(500,500);
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
	private void writeToTextfield(String s) {
		label.setText("");
		label.setText(s);
	}
	
}















