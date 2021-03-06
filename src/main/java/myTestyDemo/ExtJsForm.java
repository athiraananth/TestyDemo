package myTestyDemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sdl.selenium.extjs3.button.Button;
import com.sdl.selenium.extjs3.button.DownloadButton;
import com.sdl.selenium.extjs3.button.UploadButton;
import com.sdl.selenium.extjs3.form.CheckBox;
import com.sdl.selenium.extjs3.form.ComboBox;
import com.sdl.selenium.extjs3.form.DateField;
import com.sdl.selenium.extjs3.form.DisplayField;
import com.sdl.selenium.extjs3.form.RadioGroup;
import com.sdl.selenium.extjs3.form.TextArea;
import com.sdl.selenium.extjs3.panel.Panel;


import com.sdl.selenium.extjs3.button.DownloadLink;
import com.sdl.selenium.extjs3.form.TextField;
import com.sdl.selenium.extjs3.list.List;
import com.sdl.selenium.extjs3.window.MessageBox;
import com.sdl.selenium.extjs3.window.MessageBoxWindow;
import com.sdl.selenium.extjs3.window.Window;
import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;

import com.sdl.selenium.web.link.WebLink;

public class ExtJsForm extends Panel {

	private static final String YES_TEXT = "Yes";
	public static String NO_TEXT = "No";
	
	//Simple Form
	public Panel simpleFormPanel = new Panel("Simple Form");
	public TextField calendarElement = new TextField("dateFieldValue",simpleFormPanel).setClasses(" x-form-text x-form-field x-trigger-noedit");
	public DateField dateField = new DateField("ext-comp-1033", simpleFormPanel);
	public UploadButton uploadButton = new UploadButton(simpleFormPanel, "Browse");
	public DownloadButton downloadButton = new DownloadButton(simpleFormPanel, "Download");
	public DownloadButton downloadWithSpacesButton = new DownloadButton(simpleFormPanel, "Download with spaces");
	public DownloadButton downloadFileButton = new DownloadButton(simpleFormPanel, "Download File");
	public CheckBox rightCheckBox = new CheckBox(simpleFormPanel).setLabel("CatRight").setLabelPosition("//preceding-sibling::");
    public CheckBox leftCheckBox = new CheckBox(simpleFormPanel).setLabel("CatLeft:");
	public Button dontAcceptButton   = new Button().setText("Don'\"t Accept");
	public Button cancelButton       = new Button().setText("Cancel");
	
	//Condition Manager
	public Panel conditionManagerPanel = new Panel("Condition Manager");
	public Button expect1Button = new Button(conditionManagerPanel, "Expect1");
	public Button expect2Button = new Button(conditionManagerPanel, "Expect2");
	public Button expect3Button = new Button(conditionManagerPanel, "Expect3");
	public Button instantMessageButton = new Button(conditionManagerPanel, "Instant Message");
	public MessageBoxWindow alertWindow = new MessageBoxWindow("Alert");
	public MessageBoxWindow confirmWindow = new MessageBoxWindow("Confirm");
	public Button yesButton = new Button(this, YES_TEXT);
	
	//Find Elements After Timeout
	public Panel findElementsAfterTimeoutPanel = new Panel("Find Elements after Timeout");
	public TextField timeOutTextField = new TextField(findElementsAfterTimeoutPanel, "Timeout:");
	public Button showButton = new Button(findElementsAfterTimeoutPanel, "Show");
	public WebLocator hiddenElement = new WebLocator().setId("hiddenButton").setVisibility(true);
	public Button showHiddenButton= new Button(findElementsAfterTimeoutPanel, "Show Hidden Button");
	public MessageBoxWindow messageWindow = new MessageBoxWindow("Message");
	
	//Find Elements when contains quotes
	public Panel elementsPanel = new Panel("Find Elements when contains quotes");
	public Button dontAcceptButton1 = new Button(elementsPanel, "Don't Accept");
	public Button goodButton = new Button(elementsPanel, "It was \"good\" ok!");
	public Button dontDoItButton = new Button(elementsPanel, "Don't do it \"now\" ok!");
	public Button dontAcceptButton2 = new Button(elementsPanel, "Don'\"t Accept").setSearchTextType(SearchType.CONTAINS);
	public Button dontDoItButton2 = new Button(elementsPanel, "Don't do \"it\" :)");
	
	// Radio Groups
	public Window radioGroupWindow = new Window("RadioGroupsWindow");
	public RadioGroup enabledRadioGroup = new RadioGroup(radioGroupWindow, "enabledRadio");
	public RadioGroup disabledRadioGroup = new RadioGroup(radioGroupWindow, "disabledRadio");
	// ComboBox
	public Window comboBoxWindow = new Window("ComboBoxWindow");
	public ComboBox comboBox = new ComboBox("comboBox", comboBoxWindow);
	// Multi Select
	public Window multiSelectWindow = new Window("MultiSelectWindow");
	public List multiSelectList = new List(multiSelectWindow);
    //TextArea
	public Window textAreaWindow = new Window("TextAreaWindow");
	public TextArea textArea = new TextArea("textArea", textAreaWindow);
	
    //TextField
	public Window textFieldWindow = new Window("TextFieldWindow");
	public TextField firstNameTextField = new TextField(textFieldWindow, "First Name:");
	public TextField lastNameTextField = new TextField(textFieldWindow, "Las't Name:");
	public TextField disableTextField = new TextField(textFieldWindow, "Disable TextField:");
    
	public ExtJsForm(){

		setClasses("Extjs form");

	}

}
