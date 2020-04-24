package swtLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

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
	
	public void showGuiNewFolder() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		shell.setLayout(new FormLayout());
		
		Label label = new Label(shell, SWT.LEFT );
		label.setText("Name:");
		
		FormData data1 = new FormData();
		data1.left = new FormAttachment(0, 5);
		data1.top = new FormAttachment(0, 10);
		label.setLayoutData(data1);
		
		Text text = new Text(shell, SWT.SINGLE );
		FormData data2 = new FormData();
		data2.left = new FormAttachment(label, 15);
		data2.top = new FormAttachment(0,10);
		data2.right = new FormAttachment(100, -5);
		text.setLayoutData(data2);
		
		Composite com = new Composite(shell, SWT.NONE);
		RowLayout rowLayout = new RowLayout();
		com.setLayout(rowLayout);
		
		Button okBtn = new Button(com, SWT.PUSH);
		okBtn.setText("OK");
		okBtn.setLayoutData(new RowData(80,30));
		
		Button closeBtn = new Button(com, SWT.PUSH);
		closeBtn.setText("Close");
		closeBtn.setLayoutData(new RowData(80,30));
		closeBtn.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				shell.getDisplay().dispose();
				System.exit(0);
			}			
		});
		
		FormData data3 = new FormData();
		data3.bottom = new FormAttachment(100, -5);
		data3.right = new FormAttachment(100, 0);
		com.setLayoutData(data3);
		
		Text mainText = new Text(shell, SWT.MULTI | SWT.BORDER);
		FormData data4 = new FormData();
		data4.width = 250;
		data4.height = 180;
		data4.top = new FormAttachment(text, 10);
		data4.left = new FormAttachment(0,5);
		data4.right = new FormAttachment(100,-5);
		data4.bottom = new FormAttachment(com, -10);
		mainText.setLayoutData(data4);
		
		shell.setText("New folder");
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public void showGuiFormData() {
		display = new Display();
		shell = new Shell(display);
		
		shell.setLayout(new FormLayout());
		
		FormData formData = new FormData();
		formData.width = 100;
		formData.height = 200;
		
		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Close");
		button1.setLayoutData(formData);
		button1.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				shell.getDisplay().dispose();
				System.exit(0);
			}			
		});
		
		shell.setText("FormData");
		shell.setSize(450,400);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public void showGuiGridLayout() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		Color color = new Color(display, 100,200,100);
		shell.setBackground(color);
		color.dispose();
		
		GridLayout gridLayout = new GridLayout(2, false);
		shell.setLayout(gridLayout);
		
		Label label1 = new Label(shell, SWT.NONE);
		label1.setText("Label 1");;
		GridData gd1 = new GridData(SWT.FILL, SWT.FILL, true, true);
		label1.setLayoutData(gd1);
		
		Color color1 = new Color(display, 250,155,100);
		label1.setBackground(color1);
		color1.dispose();
		
		Label label2 = new Label(shell, SWT.NONE);
		label2.setText("Label 2");
		GridData gd2 = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd2.heightHint=100;
		label2.setLayoutData(gd2);
		
		Color color2 = new Color(display,10,155,100);
		label2.setBackground(color2);
		color2.dispose();
		
		Label label3 = new Label(shell, SWT.CENTER );
		label3.setText("Label 3");
		GridData gd3 = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd3.widthHint = 300;
		gd3.heightHint = 100;	
		gd3.horizontalSpan = 2;
		label3.setLayoutData(gd3);
		
		Color color3 = new Color(display, 100,205,200);
		label3.setBackground(color3);
		color3.dispose();
		
		shell.setText("Grid Layout");
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public void showGuiCalculator() {
		display = new Display();
		shell = new Shell(display, SWT.DIALOG_TRIM | SWT.CENTER);
		
		GridLayout gridLayout = new GridLayout(4, true);
		gridLayout.marginHeight = 5;
		shell.setLayout(gridLayout);
		
		String [] buttons = { "Cls", "Bck", "", "Close", "7", "8", "9", "/", "4",
	            "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
		
		Text text = new Text(shell, SWT.SINGLE);
		GridData gridData = new GridData();
		gridData.horizontalSpan = 4;
		gridData.horizontalAlignment = GridData.FILL;
		text.setLayoutData(gridData);
		
		for(int i=0; i < buttons.length; i++) {
			
			if(i==2) {
				Label label = new Label(shell, SWT.CENTER);
				GridData gd = new GridData(SWT.FILL , SWT.FILL, false, false);
				label.setLayoutData(gd);
			}
			else {
				Button button = new Button(shell, SWT.PUSH);
				button.setText(buttons[i]);
				GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false);
				gd.widthHint = 70;
				gd.heightHint = 50;
				button.setLayoutData(gd);
			}			
		}
		
		shell.setText("Calculator");
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}	
	public void showMyForm() {
		display = new Display();
		shell = new Shell(display);
		
		shell.setLayout(new FormLayout());
		
		// Group Person
		Group groupPerson = new Group(shell, SWT.SHADOW_IN );
		FormData fdGroupPerson = new FormData();
		fdGroupPerson.top = new FormAttachment(5,0);
		fdGroupPerson.left = new FormAttachment(2,0);
		fdGroupPerson.right = new FormAttachment(98,0);
						
		groupPerson.setText("Person");
		groupPerson.setLayoutData(fdGroupPerson);
		FormLayout grpLayout1 = new FormLayout();		
		groupPerson.setLayout(new FormLayout());
		
		// Person data
		Label labelName = new Label(groupPerson, SWT.CENTER);
		labelName.setText("Name:");		
		FormData fdLabelName = new FormData();
		fdLabelName.top = new FormAttachment(10,0);
		fdLabelName.left = new FormAttachment(5,0);
		fdLabelName.right = new FormAttachment(20,0);
		labelName.setLayoutData(fdLabelName);
		
		Text textName = new Text(groupPerson, SWT.NONE);
		textName.setToolTipText("Enter your name here");		
		FormData fdTextName = new FormData();
		fdTextName.top = new FormAttachment(10,0);
		fdTextName.left = new FormAttachment(labelName, 5);
		fdTextName.right = new FormAttachment(100,-5);
		textName.setLayoutData(fdTextName);
		
		Label labelStreet = new Label(groupPerson, SWT.CENTER);
		labelStreet.setText("Street:");
		FormData fdLabelStreet = new FormData();
		fdLabelStreet.top = new FormAttachment(labelName, 5);
		fdLabelStreet.left = new FormAttachment(5,0);
		fdLabelStreet.right = new FormAttachment(20,0);
		labelStreet.setLayoutData(fdLabelStreet);
		
		Text textStreet = new Text(groupPerson, SWT.NONE);
		textStreet.setToolTipText("Enter your street and housenumber here");
		FormData fdTextStreet = new FormData();
		fdTextStreet.top = new FormAttachment(textName, 5);
		fdTextStreet.left = new FormAttachment(labelStreet, 5);
		fdTextStreet.right = new FormAttachment(100,-5);
		textStreet.setLayoutData(fdTextStreet);
		
		Label labelZipCode = new Label(groupPerson, SWT.CENTER);
		labelZipCode.setText("Zip:");
		FormData fdZipcode = new FormData();
		fdZipcode.top = new FormAttachment(labelStreet, 5);
		fdZipcode.left = new FormAttachment(5,0);
		fdZipcode.right = new FormAttachment(20,0);
		labelZipCode.setLayoutData(fdZipcode);		
		
		Text textZipcode = new Text(groupPerson, SWT.NONE);
		textZipcode.setToolTipText("Enter your Zipcode here");
		FormData fdTextZipcode = new FormData();
		fdTextZipcode.top = new FormAttachment(textStreet,5);
		fdTextZipcode.left = new FormAttachment(labelZipCode, 5);
		fdTextZipcode.right = new FormAttachment(50,0);
		textZipcode.setLayoutData(fdTextZipcode);
		
		Label labelCity = new Label(groupPerson, SWT.RIGHT  );
		labelCity.setText("City:");
		FormData fdLabelCity = new FormData();
		fdLabelCity.top = new FormAttachment(textStreet, 5);
		fdLabelCity.left = new FormAttachment(textZipcode, 5);		
		labelCity.setLayoutData(fdLabelCity);
		
		Text textCity = new Text(groupPerson, SWT.NONE);
		textCity.setToolTipText("Enter your city here");
		FormData fdTextCity = new FormData();
		fdTextCity.top = new FormAttachment(textStreet, 5);
		fdTextCity.left = new FormAttachment(labelCity,5);
		fdTextCity.right = new FormAttachment(100,-5);
		textCity.setLayoutData(fdTextCity);
		
		Button [] radioGender = new Button[2];
		radioGender[0] = new Button(groupPerson, SWT.RADIO);
		radioGender[0].setText("Female");
		FormData fdFemale = new FormData();
		fdFemale.top = new FormAttachment(labelZipCode, 5);
		//fdFemale.left = new FormAttachment(5,50);
		fdFemale.right = new FormAttachment(40,0);
		radioGender[0].setLayoutData(fdFemale);
		
		radioGender[1] = new Button(groupPerson, SWT.RADIO);
		radioGender[1].setText("Male");
		FormData fdMale = new FormData();
		fdMale.top = new FormAttachment(labelZipCode, 5);
		//fdMale.left = new FormAttachment(cbGender[0],50 );
		fdMale.right = new FormAttachment(75,0);
		radioGender[1].setLayoutData(fdMale);
		
		// Group Occupation
		Group groupJob = new Group(shell, SWT.SHADOW_ETCHED_IN);
		groupJob.setText("Occupation");
		FormData fdJobGroup = new FormData();
		fdJobGroup.top = new FormAttachment(groupPerson,5);
		fdJobGroup.left = new FormAttachment(2,0);
		fdJobGroup.right = new FormAttachment(98,0);	
		fdJobGroup.bottom = new FormAttachment(95,0);
		groupJob.setLayoutData(fdJobGroup);
				
		shell.setText("My Formlayout");
		shell.setSize(350,300);	
		shell.setMinimumSize(350,300);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
















