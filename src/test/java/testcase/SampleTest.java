package testcase;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleTest {
	private HtmlUnitDriver driver;
//	private WebDriver driver;
//	RemoteWebDriver driver;
	
	public String getElementXPath(WebDriver driver, WebElement element) {
	    return (String)((JavascriptExecutor)driver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", element);
	}

	@BeforeSuite
	public void initDriver() throws Exception {
		driver = new HtmlUnitDriver();
		driver.setJavascriptEnabled(true);
		
/*		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");*/
		
/*		DesiredCapabilities dr=null;
		dr=DesiredCapabilities.firefox();
		dr.setBrowserName("firefox");
		dr.setPlatform(Platform.WINDOWS);
		dr.setCapability( "applicationName", "abhi2_firefox");

		driver=new RemoteWebDriver(new URL("http://192.168.1.200:4444/wd/hub"), dr);*/
		
	}

	@Test
	public void searchTestExtractElements() {
		driver.navigate().to("http://www.github.com");
		System.out.println(driver.getTitle());
		System.out.println("########## ########## ##########");
		
		System.out.println("Done.");
	}

	@AfterSuite
	public void quitDriver() throws Exception {
		driver.quit();
	}
}
