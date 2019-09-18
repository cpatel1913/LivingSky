package LST.Lst;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LST.core.TestBase;

//import LST.core.TestBase;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import pageObjects.Browser;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class LandingPageTest extends TestBase{

public static Logger logger = LogManager.getLogger(TestBase.class.getName());
private LandingPage landing=new LandingPage(driver);
private CommonTestForAllPages common;
private LoginPage login;

	@BeforeClass 
	
	public void openBrowser() throws IOException, InterruptedException {
		driver = Browser.getInstance();
		driver.get(baseUrl);
		logger.info("Browser is initialized in landing page.");
	
	}

	@Test(priority=1)
	public void verifyHeadNavForAllPages() throws InterruptedException {
	//	landing = new LandingPage(driver);
		landing.initElement();
		common = new CommonTestForAllPages();
		common.verifyNavBarHeaderContent(driver);
		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,4000)");
		WebElement element =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;	
		js.executeScript("arguments[0].scrollIntoView();",element);
        
        //Actions actions = new Actions(driver);
       // actions.moveToElement(element).perform();
        
        Thread.sleep(2000);
		
	}
	
	
	@Test(priority = 2)
	public void clickOnLogin() throws InterruptedException {
		 
		//Need to add initlement for page factory
		landing = new LandingPage(driver);
		landing.initElement();
		landing.txt_login.click(); 
		logger.info("Click on Login page.");
		 Thread.sleep(500);
		 login= new LoginPage(landing.driver);
		 login.verifyPageUrl();
		 Thread.sleep(500);
	}
	
	
	
	@AfterClass
	public  void closeBrowser() {
	System.out.println("Closing Landing page Test");
	Browser.close();
	}
	
	}
