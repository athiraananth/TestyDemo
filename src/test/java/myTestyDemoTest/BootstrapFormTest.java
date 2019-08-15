package myTestyDemoTest;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.bootstrap.button.Button;
import com.sdl.selenium.bootstrap.form.CheckBox;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.utils.FileUtils;

import myTestyDemo.BootstrapForm;
import myTestyDemo.ExtJsForm;

public class BootstrapFormTest extends TestFixtures {

	BootstrapForm bform = new BootstrapForm();
	public static String RESOURCES_DIRECTORY_PATH = new File("src/test/resources/").getAbsolutePath();
	
	@Test(priority=1)
	public void openUrl() {
		websiteUrl ="https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/bootstrap/index.html";
		WebDriverConfig.getDriver().get(websiteUrl);
	}
	
	@Test(priority=2)
	public void bFormTitleTest() {
		
		//Date Picker
		bform.datePicker.select("13/08/2019");
		//future date
		bform.datePicker.select("25/04/2021");
		//Check Box
		bform.stopTheProcess.click();
		bform.labelWithEnter.click();
		//Select Tech
		bform.selectPicker.select("No ADB");
		System.out.println(bform.selectPicker.getValue());
		// Upload File
		bform.selectFile.upload("Select file",RESOURCES_DIRECTORY_PATH +"\\upload\\text.docx");
		bform.selectFile.change(RESOURCES_DIRECTORY_PATH +"\\upload\\test123.docx");
		//Uneditable Input
		Assert.assertTrue("test".equals(bform.spanInput.getText()));
		Assert.assertTrue("123".equals(bform.budgetInput.getText()));
		//Download File throws IOException
		bform.projectData.download("text2.docx");
		//lPIDInput
		bform.lPIDInput.setValue("test123");
		System.out.println(bform.lPIDInput.getValue());
		//Select Source
		bform.multiSelect.select("Onions", "Carrots");
		List<String> sourceList = bform.multiSelect.getValueSelected();
		Iterator<String> it= sourceList.iterator();
		System.out.println("Selected Source:");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		bform.multiSelect.select("Select all");
		List<String> selectedList = bform.multiSelect.getValueSelected();
		it= selectedList.iterator();
		System.out.println("Selected Source:");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//Disable Button
		Assert.assertTrue(bform.disableBtn.isDisabled());
		Assert.assertTrue(bform.disableBtnCls.isDisabled());
		//Link Test
		bform.link.openInNewWindow();
		bform.link.returnDefaultWindow();
	}

	@Test(priority=3)
	public void bFormPOAPFTest() {
		bform.execute.select("No");
		System.out.println(bform.disabledEmail.isDisabled());
		System.out.println(bform.disabledUserName.isDisabled());
	}
	
}
