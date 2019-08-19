package myTestyDemoTest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;


import org.testng.annotations.Test;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.FileUtils;

import myTestyDemo.ExtJsForm;

import static org.testng.Assert.assertTrue;
import com.sdl.selenium.extjs3.window.Window;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sdl.selenium.extjs3.button.Button;
import com.sdl.selenium.extjs3.button.DownloadButton;
import com.sdl.selenium.extjs3.form.DateField;
import com.sdl.selenium.extjs3.form.TextField;
import com.sdl.selenium.utils.config.WebDriverConfig;



public class ExtJsFormTest extends TestFixtures {

	ExtJsForm eform = new ExtJsForm();
	public static String RESOURCES_DIRECTORY_PATH = new File("src/test/resources/").getAbsolutePath();

	@Test(priority=1)
	public void openUrl() {
		websiteUrl ="https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/extjs/index.html";
		WebDriverConfig.getDriver().get(websiteUrl);
	}

	/*Download File Implementation 
	 *requires manually closing the opened file to proceed*/
	@Test(priority=2) 
	public void downloadFileTest() throws IOException, InterruptedException {
		
		// For Firefox
		if(WebDriverConfig.isFireFox()) {
			cleanDownloadedFile("text.docx");
			String cmd = "F:\\AutoITScripts\\Download.exe";
			Assert.assertTrue(eform.downloadFileButton.download(cmd));
			//download
			cleanDownloadedFile("text.docx");
			Thread.sleep(2000);
			Assert.assertTrue(eform.downloadButton.download(cmd));
			// download File With Spaces
			cleanDownloadedFile("text t.docx");
			Thread.sleep(2000);
			cmd="F:\\AutoITScripts\\Download.exe";
			Assert.assertTrue(eform.downloadWithSpacesButton.download(cmd));
		}
		else{
			// download File from Link
			cleanDownloadedFile("text.docx");
			Thread.sleep(2000);
			String cmd = "c:\\Program Files (x86)\\Microsoft Office\\Office12\\WINWORD.exe /mOpenPage C:\\Users\\kmana\\Downloads\\Text.docx";
			Assert.assertTrue(eform.downloadFileButton.download(cmd));
			cleanDownloadedFile("text.docx");
			//download
			Thread.sleep(2000);
			Assert.assertTrue(eform.downloadButton.download(cmd));
			cleanDownloadedFile("text.docx");
			// download File With Spaces
			cmd = "c:\\Program Files (x86)\\Microsoft Office\\Office12\\WINWORD.exe /mOpenPage \"C:\\Users\\kmana\\Downloads\\text t.docx\"";
			Thread.sleep(2000);
			Assert.assertTrue(eform.downloadWithSpacesButton.download(cmd));
			cleanDownloadedFile("text t.docx");
		}
	}
	@Test(priority=3) 
	public void simpleFormTest() throws InterruptedException, IOException {

		//DisplayFieldValue
		eform.displayFieldValue.click();
		DateField datePicker = new DateField(eform.simpleFormPanel);
		datePicker.waitToRender();
		datePicker.select("15/09/2019");
		System.out.println(datePicker.getValue());
		//check box
		eform.rightCheckBox.waitToRender(1500);
		eform.rightCheckBox.click();
		eform.leftCheckBox.click();
		//upload file
		eform.uploadButton.upload(RESOURCES_DIRECTORY_PATH + "\\upload\\text.docx");
		TextField uploadTextField = new TextField(eform.simpleFormPanel, "Upload File:");
		Thread.sleep(2000);
		Assert.assertFalse(uploadTextField.getAttribute("class").contains("x-form-empty-field"),"Upload Failed");
		eform.dontAcceptButton.click();
		eform.cancelButton.click();
	}

	//condition Manager Implementation
	@Test(priority=4)
	public void conditionManagerTest() {

		eform.expect1Button.click();
		System.out.println(eform.alertWindow.getMessage(5));
		eform.alertWindow.pressOK();
		eform.expect2Button.click();
		System.out.println(eform.alertWindow.getMessage(5));
		eform.alertWindow.pressOK();
		eform.expect3Button.click();
		System.out.println(eform.confirmWindow.getMessage(15));
		eform.confirmWindow.pressYes();
		eform.instantMessageButton.click();
		System.out.println(eform.alertWindow.getMessage());
		eform.alertWindow.pressOK();
	}


	// Find Elements After Timeout Implementation
	@Test(priority=5)
	public void findElementsAfterTimeoutTest() {
		eform.timeOutTextField.setValue("2000");
		eform.showButton.click();
		System.out.println(eform.messageWindow.getMessage(5));
		eform.messageWindow.pressOK();
		eform.showHiddenButton.click();
		eform.hiddenElement.click();
		System.out.println(eform.messageWindow.getMessage(15));
		eform.messageWindow.pressOK();
	}

	// Find Elements with Quotes Implementation
	@Test(priority=6)
	public void findElementsQuotesTest() {
		eform.dontAcceptButton1.click();
		eform.goodButton.click();
		eform.dontDoItButton.click();
		eform.dontAcceptButton2.click();
		eform.dontDoItButton2.click();
	}

	// Radio button Implementation
	@Test(priority=7)
	public void radioGroupTest() {
		//selectRadioGroup
		Button radioGroupsButton = new Button(null, "RadioGroups");
		radioGroupsButton.click();
		eform.enabledRadioGroup.selectByLabel("Item 1");
		eform.enabledRadioGroup.selectByLabel("3", SearchType.CONTAINS);
		eform.enabledRadioGroup.selectByLabel("5", SearchType.CONTAINS);	 
		System.out.println(eform.disabledRadioGroup.getLabelName("2"));
		assertFalse(eform.enabledRadioGroup.isDisabled());
		assertTrue(eform.disabledRadioGroup.isDisabled());
		eform.radioGroupWindow.close();
	}

	//Combo Box Implementation
	@Test(priority=8)
	public void comboBoxTest() {
		//select comboBox
		Button comboBoxButton = new Button(null, "ComboBox");
		comboBoxButton.click();
		eform.comboBox.select("Chine", SearchType.STARTS_WITH);
		eform.comboBox.select("language", SearchType.CONTAINS);
		System.out.println(eform.comboBox.getValue());
		eform.comboBoxWindow.close();
	}

	// multi Select Implementation
	@Test(priority=9)
	public void multiSelectTest() {

		Button multiSelectButton = new Button(null, "MultiSelect");
		multiSelectButton.click();
		eform.multiSelectList.selectRows("Italian", "French", "Russian");
		eform.multiSelectWindow.close();
	}

	// TextArea Implementation
	@Test(priority=10)
	public void textAreaTest() {

		Button textAreaButton = new Button(null, "TextArea");
		textAreaButton.click();
		System.out.println(eform.textArea.getValue());
		eform.textArea.setValue(" Sample Text");
		eform.textAreaWindow.close();
	}

	// Text Field Implementation
	@Test(priority=11)
	public void textFieldTest() {

		Button textFieldButton = new Button(null, "TextField");
		textFieldButton.click();
		System.out.println(eform.firstNameTextField.getValue());
		eform.lastNameTextField.setValue("Test2");
		Assert.assertTrue(eform.disableTextField.isDisabled());
		System.out.println(eform.lastNameTextField.getValue());
		eform.textFieldWindow.close();
	}

	// Tab Panel Implementation
	@Test(priority=12)
	public void tabPanelTest() {
		Button tabPanelButton = new Button(null, "TabPanel");
		tabPanelButton.click();
		eform.tabPanel1.waitToRender(1500);
		eform.tabPanel1. setActive();
		Assert.assertTrue(eform.panelWithFrame.isElementPresent());
		System.out.println(eform.elTab1.getText());
		System.out.println(eform.elTab11.getText());
		eform.tabPanel21.setActive();
		System.out.println(eform.elTab21.getText());
		eform.tabPanel2.setActive();
		Assert.assertTrue(eform.panelNoWithFrame.isElementPresent());
		System.out.println(eform.elTab2.getText());
		eform.panelNoFrame2.setActive();
		System.out.println(eform.elTabNF2.getText());
		eform.panelWithFrame2.setActive();
		System.out.println(eform.elTabF2.getText());
		eform.tabPanelWindow.close();
	}
	
	@Test(priority=13)  
	public void dateFieldTest() {
		WebLocator tbar = new WebLocator().setId("top-toolbar");
		Button dateFieldButton = new Button(tbar, "DateField");
		dateFieldButton.click();
		eform.dateField.selectToday();
		eform.dateField.select("29/08/2019");
		eform.dateFieldWindow.close();
	}
	
	@Test(priority=14)
	public void editorGridPanelTest() {
		WebLocator tbar = new WebLocator().setId("top-toolbar");
		Button editorGridButton = new Button(tbar, "EditorGridPanel");
		editorGridButton.click();
	
		eform.editorGridPanel.startEdit(1, 1);
		TextField textField = eform.editorGridPanel.getActiveEditor();
		eform.editorGridPanel.waitToActivate();
		eform.editorGridPanel.setRowValue(1, 1, "Test Plant");
		eform.editorGridPanel.startEdit(1, 2);
		eform.editorGridPanel.setRowValue(1, 2, "TestTest Botanical");
		eform.editorGridPanel.setRowValue(1, 3, "Sun or Shade");
		eform.editorGridPanel.startEdit(5, 2);
		textField = eform.editorGridPanel.getActiveEditor();
		eform.editorGridPanel.setRowValue(5, 2, "Test Plant2");
		eform.editorGridPanel.checkboxColumnSelect("Anemone", 6, true);
		eform.editorGridPanel.scrollBottom();
		Assert.assertTrue(eform.editorGridPanel.rowSelect("Wake Robin"),"Search Text Not Found");
		Assert.assertTrue(eform.editorGridPanel.rowSelect("Greek", SearchType.STARTS_WITH),"Search Text Not Found");
		Assert.assertTrue(eform.editorGridPanel.rowSelect("/Spring/Beauty", 1, SearchType.CONTAINS_ALL),"Search Text Not Found");
		Assert.assertTrue(eform.submitButton.isDisabled());
		eform.editorGridPanelWindow.close();
	}
	

	// Clears the downloaded file from directory
	public void cleanDownloadedFile(String fileName) throws IOException {
		
		String downloadPath ="C:\\Users\\kmana\\Downloads";
		File directory = new File(downloadPath);
		File[] filesList =directory.listFiles();
		for (File file : filesList) {
			String fName = file.getName();
			if(fName.contains(fileName)||fName.contains(".crdownload")) {
				file.delete();
				System.out.println(fileName +"  deleted from downloaded path");					
				break;
			}
				
			
        }

	}
}
