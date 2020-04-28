package swtLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class MyForm {
	
	Display display;
	Shell shell;
	
	public void showMyForm() {
		
		display = new Display();
		shell = new Shell(display);
		
		shell.setLayout(new FormLayout());
		
		// Group Person
		Group groupPerson = new Group(shell, SWT.SHADOW_IN );
		FormData fdGroupPerson = new FormData();
		fdGroupPerson.top = new FormAttachment(2,0);
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
		fdFemale.right = new FormAttachment(40,0);
		radioGender[0].setLayoutData(fdFemale);
		
		radioGender[1] = new Button(groupPerson, SWT.RADIO);
		radioGender[1].setText("Male");
		FormData fdMale = new FormData();
		fdMale.top = new FormAttachment(labelZipCode, 5);
		fdMale.right = new FormAttachment(75,0);
		radioGender[1].setLayoutData(fdMale);
		
		// Group Occupation
		Group groupJob = new Group(shell, SWT.SHADOW_ETCHED_IN);
		groupJob.setText("Occupation");
		FormData fdJobGroup = new FormData();
		fdJobGroup.top = new FormAttachment(groupPerson,5);
		fdJobGroup.left = new FormAttachment(2,0);
		fdJobGroup.right = new FormAttachment(98,0);	
		//fdJobGroup.bottom = new FormAttachment(90,0);
		groupJob.setLayoutData(fdJobGroup);
		
		GridLayout gridLayout = new GridLayout(4,false);
		groupJob.setLayout(gridLayout);
				
		Label labelCompany = new Label(groupJob,SWT.NONE);
		labelCompany.setText("Company:");
		GridData gdLabelCompany = new GridData();		
		gdLabelCompany.horizontalAlignment=GridData.CENTER;
		labelCompany.setLayoutData(gdLabelCompany);
		
		Text textCompany = new Text(groupJob, SWT.NONE);
		GridData gdTextCompany = new GridData(GridData.FILL_HORIZONTAL);	
		gdTextCompany.horizontalSpan=3;
		textCompany.setLayoutData(gdTextCompany);
		
		Label labelJobStreet = new Label(groupJob, SWT.NONE);
		labelJobStreet.setText("Street:");
		GridData gdLabelJobStreet = new GridData();
		gdLabelJobStreet.horizontalAlignment = GridData.CENTER;
		gdLabelJobStreet.horizontalIndent = 3; 
		labelJobStreet.setLayoutData(gdLabelJobStreet);
		
		Text textJobStreet = new Text(groupJob, SWT.NONE);		
		textJobStreet.setLayoutData(gdTextCompany);
		
		Label labelJobZip = new Label(groupJob, SWT.NONE);
		labelJobZip.setText("Zip:");
		GridData gdLabelJobZip = new GridData();
		gdLabelJobZip.horizontalAlignment = GridData.CENTER;
		gdLabelJobZip.horizontalIndent = 5;
		labelJobZip.setLayoutData(gdLabelJobZip);
		
		Text textJobZip = new Text(groupJob, SWT.NONE);
		GridData gdTextJobZip = new GridData(GridData.FILL_HORIZONTAL);
		textJobZip.setLayoutData(gdTextJobZip);
		
		Label labelJobCity = new Label(groupJob, SWT.NONE);
		labelJobCity.setText("City:");
		GridData gdLabelJobCity = new GridData(GridData.FILL);
		gdLabelJobCity.horizontalAlignment = GridData.BEGINNING;
		labelJobCity.setLayoutData(gdLabelJobCity);
		
		Text textJobCity = new Text(groupJob, SWT.NONE);
		GridData gdTextJobCity = new GridData(GridData.FILL_HORIZONTAL);		
		textJobCity.setLayoutData(gdTextJobCity);
		
		Label labelJob = new Label(groupJob, SWT.NONE);
		labelJob.setText("Occupation:");
		GridData gdLabelJob = new GridData();
		gdLabelJob.horizontalAlignment = GridData.CENTER;
		labelJob.setLayoutData(gdLabelJob);	
		
		Combo comboJob = new Combo(groupJob, SWT.DROP_DOWN | SWT.READ_ONLY);
		String items[] = {"","intern","trainee","apprentice","account manager", 
							"vice president","software developer", "CEO"};
		comboJob.setItems(items);
		GridData gdComboJob = new GridData(GridData.FILL_HORIZONTAL);		
		comboJob.setLayoutData(gdComboJob);
		
		Label labelDummy = new Label(groupJob, SWT.NONE);
		Label labelDummy1 = new Label(groupJob, SWT.NONE);
		
		Label labelSalary = new Label(groupJob, SWT.NONE);
		labelSalary.setText("Salary:");
		GridData gdLabelSalary = new GridData();		
		gdLabelSalary.horizontalAlignment = GridData.CENTER;
		labelSalary.setLayoutData(gdLabelSalary);
		
		Spinner spinnerSalary = new Spinner(groupJob, SWT.BORDER);
		spinnerSalary.setMaximum(100000);
		spinnerSalary.setIncrement(100);
		spinnerSalary.setPageIncrement(1000);
		GridData gdSpinner = new GridData(GridData.FILL_HORIZONTAL);		
		spinnerSalary.setLayoutData(gdSpinner);
		
		// Group Buttons
		Group groupBtn = new Group(shell, SWT.SHADOW_ETCHED_IN);
		groupBtn.setText("Save / Load");
		FormLayout formLayout = new FormLayout();
		groupBtn.setLayout(formLayout);
		FormData fdGroupBtn = new FormData();
		fdGroupBtn.top = new FormAttachment(groupJob,5);
		fdGroupBtn.left = new FormAttachment(2,0);
		fdGroupBtn.right = new FormAttachment(98,0);
		fdGroupBtn.bottom = new FormAttachment(98,0);
		groupBtn.setLayoutData(fdGroupBtn);		
	
		Label labelPath = new Label(groupBtn, SWT.NONE);
		labelPath.setText("Save path:");
		FormData fdLabelPath = new FormData();
		fdLabelPath.top = new FormAttachment(5,0);
		fdLabelPath.left = new FormAttachment(5,0);
		labelPath.setLayoutData(fdLabelPath);
		
		Text textPath = new Text(groupBtn, SWT.NONE);		
		Button pathBtn = new Button(groupBtn, SWT.PUSH);
		pathBtn.setText("Save Path");		
		FormData fdTextPath = new FormData();
		fdTextPath.top = new FormAttachment(5);
		fdTextPath.left = new FormAttachment(labelPath, 5);
		fdTextPath.right = new FormAttachment(pathBtn,-5);
		textPath.setLayoutData(fdTextPath);				
		FormData fdPathBtn = new FormData();
		fdPathBtn.top = new FormAttachment(1);
		fdPathBtn.right = new FormAttachment(98,0);
		pathBtn.setLayoutData(fdPathBtn);
		
		//=== Load/Save buttons
		Button loadBtn = new Button(groupBtn, SWT.PUSH);
		loadBtn.setText("Load");
		FormData fdLoadBtn = new FormData();
		fdLoadBtn.top = new FormAttachment(labelPath, 5);
		fdLoadBtn.left = new FormAttachment(5,0);
		fdLoadBtn.width = 55;
		loadBtn.setLayoutData(fdLoadBtn);
				
		Button saveBtn = new Button(groupBtn, SWT.PUSH);
		saveBtn.setText("Save");
		
		Label labelDummy2 = new Label(groupBtn, SWT.NONE);
		FormData fdDummy = new FormData();
		fdDummy.top = new FormAttachment(pathBtn,5);
		fdDummy.left = new FormAttachment(loadBtn,5);
		fdDummy.right = new FormAttachment(saveBtn,-5);
		labelDummy2.setLayoutData(fdDummy);
		//============
		FormData fdSaveBtn = new FormData();
		fdSaveBtn.top = new FormAttachment(pathBtn,5);
		fdSaveBtn.right = new FormAttachment(98,0);
		fdSaveBtn.width = 64;
		saveBtn.setLayoutData(fdSaveBtn);		
		//============
		
		shell.setText("My Formlayout");
		shell.setSize(350,400);	
		shell.setMinimumSize(350,400);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
