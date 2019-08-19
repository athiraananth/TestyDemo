package myTestyDemoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.sdl.selenium.utils.config.WebDriverConfig;


public class TestFixtures {

	//public String browserType;
	public static WebDriver driver;
	public static String websiteUrl;


	@BeforeTest
	@Parameters("browser")
	public void initWebDriver(String browser) {
		//Chrome
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "F:\\Athira\\Selenium\\Selenium 3.141.59\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			WebDriverConfig.init(driver);
		}
		//Firefox
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "F:\\Athira\\Selenium\\Selenium 3.141.59\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			WebDriverConfig.init(driver);
			WebDriverConfig.setDownloadPath("C:\\Users\\kmana\\Downloads");
		}
	}

	/*
	 * @AfterTest public void tearDownTestMethod() { if(driver!=null) {
	 * driver.close();
	 * 
	 * } }
	 */

}
