package myTestyDemoTest;

import java.io.File;
import java.io.IOException;
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
	ExtJsFormTest bform1 = new ExtJsFormTest();
	public static String RESOURCES_DIRECTORY_PATH = new File("src/test/resources/").getAbsolutePath();

	@Test(priority=1)
	public void openUrl() {
		websiteUrl ="https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/bootstrap/index.html";
		WebDriverConfig.getDriver().get(websiteUrl);
	}

	//Form Title Implementation
	@Test(priority=2)
	public void bFormTitleTest() throws IOException {

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
		if(WebDriverConfig.isFireFox()) {
			bform1.cleanDownloadedFile("text.docx");
			String cmd = "F:\\AutoITScripts\\Download.exe";
			Assert.assertTrue(bform.projectData.download(cmd));
		}
		else{
			String cmd ="c:\\Program Files (x86)\\Microsoft Office\\Office12\\WINWORD.exe /mOpenPage C:\\Users\\kmana\\Downloads\\Text.docx";
			Assert.assertTrue(bform.projectData.download(cmd));
			bform1.cleanDownloadedFile("text.docx");	
		}
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

	//Form Table Implementation
	@Test(priority=3)
	public void bFormTableTest() {

		//Verify Row with Text Nick
		Row row=bform.formTable.getRow(new Cell(2, "Nick",SearchType.EQUALS));
		Assert.assertTrue(row.isElementPresent());
		//Verify check box
		Cell cell = bform.formTable.getCell(1, new Cell(2, "John", SearchType.EQUALS), new Cell(3, "Carter", SearchType.EQUALS));
		CheckBox ck=new CheckBox(cell);
		ck.click();
		System.out.println(" Check box present: "+ck.isElementPresent());
		//Verify cell with Text
		row = bform.formTable.getRow(new Cell("Carter", SearchType.EQUALS));
		System.out.println(" Text Carter present: "+row.isElementPresent());
		//Verify Buttons
		row = bform.formTable.getRow(1, new Cell(2, "John", SearchType.EQUALS), new Cell(3, "Carter", SearchType.EQUALS));
		Button detailsButton = new Button(row).setText("Details", SearchType.CONTAINS);
		Button removeButton = new Button(row, "Remove");
		System.out.println(detailsButton.isEnabled());
		System.out.println("Details Button Present: "+detailsButton.isElementPresent());
		System.out.println("Remove Button Present:"+removeButton.isElementPresent());
		//get all table data
		List<List<String>> tableList = bform.formTable.getCellsText(1, 5);
		System.out.println(" ## Table Data ##");
		for (List<String> listEl : tableList) {
			for (int i=0;i<listEl.size()-1;i++) {
				String el=listEl.get(i);
				if(i%2==0) {
					System.out.print(el +"\t \t");
				}
				else{System.out.println(el);
				}
			}
		}	
	}


	//Page Object And Page Factory Implementation
	@Test(priority=4)
	public void bFormPOAPFTest() {
		bform.execute.select("No");
		System.out.println(bform.disabledEmail.isDisabled());
		System.out.println(bform.disabledUserName.isDisabled());
		bform.demoButton.click();;
		bform.demoModalWindow.waitToRender(2000);
		bform.emailField.setValue("test.t@bgmail.com");
		bform.nameField.setValue("tester");
		bform.saveButton.click();
		bform.closeButton.click();
	}

}
