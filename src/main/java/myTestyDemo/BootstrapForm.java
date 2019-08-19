package myTestyDemo;

import org.openqa.selenium.WebDriver;

import com.sdl.selenium.bootstrap.button.Button;
import com.sdl.selenium.bootstrap.button.DownloadFile;
import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.CheckBox;
import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.bootstrap.form.InputAppend;
import com.sdl.selenium.bootstrap.form.MultiSelect;
import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.bootstrap.form.UneditableInput;
import com.sdl.selenium.bootstrap.window.Window;
import com.sdl.selenium.extjs3.button.UploadButton;
import com.sdl.selenium.extjs3.panel.Panel;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.table.Table;


public class BootstrapForm extends Panel{

	public static WebDriver driver;
	public static String websiteUrl;
	public Form form = new Form(null, "Form Title");
	//Date Picker
	public DatePicker datePicker = new DatePicker(form, "dp3");
	//Check Box
	public CheckBox stopTheProcess = new CheckBox(form);
	public CheckBox labelWithEnter = new CheckBox(form).setLabel("Label with Enter.", SearchType.CHILD_NODE).setLabelPosition("//");
	//Select Picker
	public SelectPicker selectPicker = new SelectPicker(form, "Tech:");
	// Select File
	public UploadFile  selectFile  = new UploadFile(form, "TPT Test:");
	//Uneditable Input
	public UneditableInput spanInput = new UneditableInput(form, "Span:");
	public UneditableInput budgetInput = new UneditableInput(form, "Budget:");
	//Download File
	public DownloadFile projectData = new DownloadFile(form).setText("Download");
	//LPID for Merge
	public InputAppend lPIDInput = new InputAppend(form, "LPID for Merge:");
	//Select Source
	public MultiSelect multiSelect = new MultiSelect(form, "Source:");
	//Disable Button
	public Button disableBtn = new Button(form, "DisableBtn");
	public Button disableBtnCls = new Button(form, "DisableBtnCls");
	//Link
	public WebLink link = new WebLink(form, "Link");
	// Form Table 
	public Form tableForm = new Form(null, "Form Table");
	public Table formTable = new Table(tableForm);
	// Page Object And Page Factory
	public SelectPicker execute = new SelectPicker().setLabel("Execute");
	public UneditableInput disabledExecute = new UneditableInput().setLabel("Execute");
	public UneditableInput disabledEmail = new UneditableInput().setLabel("Email");
	public UneditableInput disabledUserName = new UneditableInput().setLabel("User Name");
	public Form pageObjectForm = new Form("Page Object And Page Factory");
	public Button demoButton = new Button().setContainer(pageObjectForm).setText("Launch demo modal");
	public Window demoModalWindow = new Window("Modal title");
	public TextField emailField = new TextField(demoModalWindow).setLabel("Email:");
	public TextField nameField = new TextField(demoModalWindow).setLabel("User Name:");
	public Button saveButton = new Button(demoModalWindow, "Save");
	public Button closeButton = new Button(demoModalWindow, "Close");
	
	public BootstrapForm(){

		setClasses("Bootstrap Form");

	}
}
