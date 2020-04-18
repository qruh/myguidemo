package swtWidgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Spinner;

import myUtilities.MyImage;

public class WidgetsDemo {
	
	Display display;
	Shell shell;
		
	public void showLabel() {
				
		final String lyrics =
		"And I know that he knows I'm unfaithful\n"+
		"And it kills him inside\n"+
		"To know that I am happy with some other guy\n"+
		"I can see him dyin'\n"+
		"\n"+
		"I don't wanna do this anymore\n"+
		"I don't wanna be the reason why\n"+
		"Every time I walk out the door\n"+
		"I see him die a little more inside\n"+
		"I don't wanna hurt him anymore\n"+
		"I don't wanna take away his life\n"+
		"I don't wanna be... A murderer";
		
		display = new Display();
		shell = new Shell(display, SWT.CENTER | SWT.DIALOG_TRIM);
		
		FillLayout fillLayout= new FillLayout();
		fillLayout.marginHeight=5;
		fillLayout.marginWidth=5;
		shell.setLayout(fillLayout);
		
		Label label = new Label(shell, SWT.LEFT | SWT.BORDER);
		label.setText(lyrics);
		
		Point p = label.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		label.setBounds(5,5,p.x+5, p.y+5);
				
		shell.setText("Unfaithful");
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	public void showCheckButton() {
		
		display = new Display();
		shell = new Shell(display);
		
		RowLayout layout = new RowLayout();
		layout.marginLeft = 30;
		layout.marginTop = 30;
		shell.setLayout(layout);
		
		Button button = new Button(shell, SWT.CHECK);
		button.setText("Show title");
		button.setSelection(true);
		button.addListener(SWT.Selection, event -> onButtonSelect(button));
		
		shell.setText("Check button");
		shell.setSize(250,200);
		shell.open();
		
		while (!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}	
	private void onButtonSelect(Button button) {
		if(button.getSelection()) {
			shell.setText("Check button");
		}
		else {
			shell.setText("");
		}
	}
	public void showSpinner() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		RowLayout layout = new RowLayout();
		layout.marginLeft = 10;
		layout.marginTop = 10;
		layout.spacing = 30;
		layout.center = true;
		shell.setLayout(layout);
		
		
		
		Spinner spinner = new Spinner(shell, SWT.BORDER);
		spinner.setMinimum(0);
		spinner.setMaximum(100);
		spinner.setSelection(0);
		spinner.setIncrement(1);
		spinner.setPageIncrement(10);
		spinner.setLayoutData(new RowData(30,-1));
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("0");
		label.pack();
		
		//spinner.addListener(SWT.Selection, event -> onSelected(spinner,label));
		spinner.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String val = spinner.getText();
				label.setText(val);
				label.pack();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		shell.setText("Spinner");
		shell.setSize(200,150);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	private void onSelected(Spinner spinner, Label label) {
		String val = spinner.getText();
		label.setText(val);
	}
	public void showListWidget() {
		
		display = new Display();
		shell = new Shell(display);
		
		Label status = new Label(shell,SWT.NONE);
		status.setText("Ready");
		
		FormLayout layout = new FormLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		layout.spacing = 5;
		shell.setLayout(layout);
		
		FormData labelData = new FormData();
		labelData.left = new FormAttachment(0);
		labelData.right = new FormAttachment(100);
		labelData.bottom = new FormAttachment(100);
		status.setLayoutData(labelData);
		
		List list = new List(shell, SWT.BORDER);
		
		list.add("Aliens");
		list.add("Capote");
	    list.add("Neverending story");
	    list.add("Starship troopers");
	    list.add("Exorcist");
	    list.add("Omen");
	    
	    list.addListener(SWT.MouseDoubleClick, event -> onListItemSelect(list, status));
	    
	    FormData listData = new FormData();
	    listData.width = 250;
	    listData.height = 200;
	    listData.left = new FormAttachment(shell, 0);
	    listData.top = new FormAttachment(shell, 0);
	    listData.right = new FormAttachment(100,0);
	    listData.bottom = new FormAttachment(status, 0);
	    list.setLayoutData(listData);
	    
	    shell.setText("List");
	    shell.pack();
	    shell.open();
	    
	    while(!shell.isDisposed()) {
	    	if(!display.readAndDispatch()) {
	    		display.sleep();
	    	}
	    }
	    display.dispose();		
	}
	private void onListItemSelect(List list, Label label) {
		String [] items = list.getSelection();
		label.setText(items[0]);
	}
	
	Image mute=null, min=null, med=null, max=null;
	public void showSlider() {
		
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		
		Device dev = shell.getDisplay();
		
		try {
			MyImage myImage = new MyImage();
			mute = new Image(dev, "images/mute.png");
			mute = myImage.resizeImage(dev,mute,25,25);
			
			min = new Image(dev, "images/min.png");
			min = myImage.resizeImage(dev,min,25,25);			
			
			med = new Image(dev, "images/med.png");
			med = myImage.resizeImage(dev,med,25,25);
			
			max = new Image(dev, "images/max.png");
			max = myImage.resizeImage(dev,max,25,25);
		}
		catch (Exception e) {
			System.out.println("Cannon load images");
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		RowLayout layout = new RowLayout();
		layout.marginLeft = 30;
		layout.marginTop = 30;
		layout.spacing = 30;
		//layout.fill = true;
		shell.setLayout(layout);
		
		Slider slider = new Slider(shell, SWT.HORIZONTAL);
		slider.setMaximum(100);	
		slider.setLayoutData(new RowData(180, -1));
		
		Label label = new Label(shell, SWT.IMAGE_PNG);
		label.setImage(mute);
		
		slider.addListener(SWT.Selection, event -> onSelection(slider, label,mute,min,med,max));
		
		shell.setText("Slider");
		shell.setSize(350,200);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		mute.dispose();
		min.dispose();
		med.dispose();
		max.dispose();
	}
	private void onSelection(Slider slider, Label label, Image mute, Image min, Image med, Image max) {
		
		int value = slider.getSelection();
		
		if(value == 0) {
			label.setImage(mute);
			label.pack();
		}
		else if(value > 0 && value <= 30) {
			label.setImage(min);			
		}
		else if(value > 30 && value < 80) {
			label.setImage(med);
		}
		else {
			label.setImage(max);
		}
	}	
	public void showComboWidget() {
		
		display = new Display();
		shell = new Shell(display , SWT.SHELL_TRIM | SWT.CENTER);
		
		RowLayout layout = new RowLayout(SWT.VERTICAL);
		layout.marginLeft = 50;
		layout.marginTop = 30;
		layout.spacing = 30;
		shell.setLayout(layout);
		
		Combo combo = new Combo(shell, SWT.DROP_DOWN);
		combo.add("Ubuntu");
	    combo.add("Fedora");
	    combo.add("Arch");
	    combo.add("Red Hat");
	    combo.add("Mint");
	    
	    combo.setLayoutData(new RowData(150,-1));    
	    
	    Label label = new Label(shell, SWT.LEFT);
	    label.setText("...");
	    
	    combo.addListener(SWT.Selection, event -> {
	    	label.setText(combo.getText());
	    	label.pack();
	    });
	    
	    shell.setText("Combo");
	    shell.setSize(300,250);
	    shell.open();
	    
	    while(!shell.isDisposed()) {
	    	if(!display.readAndDispatch()) {
	    		display.sleep();
	    	}
	    }
	    display.dispose();
	}
}













