package testcase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestConfigurable {
	private WebDriver driver;	
	
	static Logger logger = Logger.getLogger(TestConfigurable.class);
	
	HashMap<String,String> button_map = new HashMap<String, String>();
	HashMap<String,String> a_map = new HashMap<String, String>();
	HashMap<String,String> input_map = new HashMap<String, String>();
	HashMap<String,String> li_map = new HashMap<String, String>();
	
	@Parameters({"browser", "driverPath"})
	@BeforeTest
	public void initDriver(String browser, @Optional("") String driverPath) throws Exception {
		logger.info("You are testing on browser " + browser);
		browser = browser.toLowerCase();
		if (!driverPath.equals("")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
		}
		if (browser.equals("chrome")) {			
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Please create a driver for " + browser);
		}
	}
	
	
	@Test
	public void searchTestExtractElements() throws InterruptedException {
		driver.navigate().to("http://www.github.com");
		System.out.println(driver.getTitle());
		System.out.println("########## ########## ##########");
		
		System.out.println("Done.");
	}
	
	@AfterSuite
	public void quitDriver() throws Exception {
		driver.quit();
	}

	
	
	/**
	 * helper functions 
	 */
	
	//	http://stackoverflow.com/questions/4176560/webdriver-get-elements-xpath 
	public String getElementXPath(WebDriver driver, WebElement element) {
	    return (String)((JavascriptExecutor)driver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", element);
	}

}
