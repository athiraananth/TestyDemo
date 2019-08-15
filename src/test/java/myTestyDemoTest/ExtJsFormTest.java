package myTestyDemoTest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;


import org.testng.annotations.Test;

import com.sdl.selenium.web.SearchType;
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
import com.sdl.selenium.utils.config.WebDriverConfig;



public class ExtJsFormTest extends TestFixtures {

	ExtJsForm eform = new ExtJsForm();
	public static String RESOURCES_DIRECTORY_PATH = new File("src/test/resources/").getAbsolutePath();
	
	@Test(priority=1)
	public void openUrl() {
		websiteUrl ="https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/extjs/index.html";
		WebDriverConfig.getDriver().get(websiteUrl);
	}
	
	@Test(priority=2)
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
	
	
	@Test(priority=3)
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

	@Test(priority=4)
	public void findElementsQuotesTest() {
		eform.dontAcceptButton1.click();
		eform.goodButton.click();
		eform.dontDoItButton.click();
		eform.dontAcceptButton2.click();
		eform.dontDoItButton2.click();
	}
	
	 @Test(priority=5)
	public void radioGroupTest() {
		 //selectRadioGroup
		 Button radioGroupsButton = new Button(null, "RadioGroups");
	     radioGroupsButton.click();
		 eform.enabledRadioGroup.selectByLabel("Item 1");
		 eform.enabledRadioGroup.selectByLabel("3", SearchType.CONTAINS);
		 eform.disabledRadioGroup.selectByValue("4");	 
		 System.out.println(eform.disabledRadioGroup.getLabelName("2"));
		 assertFalse(eform.enabledRadioGroup.isDisabled());
		 assertTrue(eform.disabledRadioGroup.isDisabled());
		 eform.radioGroupWindow.close();
	}
	
	@Test(priority=6)
	public void comboBoxTest() {
		 //select comboBox
		 Button comboBoxButton = new Button(null, "ComboBox");
		 comboBoxButton.click();
		 eform.comboBox.select("Chine", SearchType.STARTS_WITH);
		 eform.comboBox.select("language", SearchType.CONTAINS);
		 System.out.println(eform.comboBox.getValue());
		 eform.comboBoxWindow.close();
	}
	
	@Test(priority=7)
	public void multiSelectTest() {
		 
		 Button multiSelectButton = new Button(null, "MultiSelect");
		 multiSelectButton.click();
		 eform.multiSelectList.selectRows("Italian", "French", "Russian");
		 eform.multiSelectWindow.close();
	}
	
	@Test(priority=8)
	public void textAreaTest() {
		
		Button textAreaButton = new Button(null, "TextArea");
        textAreaButton.click();
        System.out.println(eform.textArea.getValue());
		eform.textArea.setValue(" Sample Text");
		eform.textAreaWindow.close();
	}
	
	
	@Test(priority=9)
	public void textFieldTest() {
		
		Button textFieldButton = new Button(null, "TextField");
		textFieldButton.click();
		System.out.println(eform.firstNameTextField.getValue());
		eform.lastNameTextField.setValue("Test2");
		Assert.assertTrue(eform.disableTextField.isDisabled());
		System.out.println(eform.lastNameTextField.getValue());
		eform.textFieldWindow.close();
	}
	
		@Test(priority=10)
		public void simpleFormTest() throws InterruptedException {
			
			//check box
			eform.rightCheckBox.waitToRender(1500);
			eform.rightCheckBox.click();
			eform.leftCheckBox.click();
			eform.dontAcceptButton.click();
			eform.cancelButton.click();
			//download
			 eform.downloadButton.download("test123.docx");
			 // download File from Link
			 eform.downloadFileButton.download("text.docx");
			 // download File With Spaces
			 eform.downloadWithSpacesButton.download("text t.docx");
			 //upload file
			 eform.uploadButton.upload(RESOURCES_DIRECTORY_PATH + "\\upload\\text.docx");
		}
}
