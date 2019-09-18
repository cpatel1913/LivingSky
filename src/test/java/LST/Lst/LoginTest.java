package LST.Lst;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import LST.core.TestBase;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import pageObjects.Browser;
import pageObjects.Dashboard;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class LoginTest extends TestBase{
	
	public static Logger logger = LogManager.getLogger(TestBase.class.getName());
	private LandingPage landing;
	private LoginPage log;
	private CommonTestForAllPages common;
	
@BeforeClass
	public void openBrowser() throws IOException, InterruptedException {
	//basePageNavigation();
	driver = Browser.getInstance();
	driver.get(baseUrl);
	
	}	

@Test(priority=1)
public void verifyLoginPageAttributes() throws InterruptedException {
	
	landing= new LandingPage(driver);
	landing.initElement();
	landing.txt_login.click();
	 Thread.sleep(500);
	 log =new LoginPage(landing.getDriver());
	 log.initElement();
	 AssertJUnit.assertTrue(log.txt_userName.isDisplayed());
	 logger.info("Email textbox is displayed.");
	 AssertJUnit.assertTrue(log.txt_password.isDisplayed());
	 logger.info("Password textbox is displayed.");
	 AssertJUnit.assertTrue(log.btn_login.isDisplayed());
	 logger.info("Login Button is displayed.");
	 AssertJUnit.assertTrue(log.radio_remember_me.isDisplayed());
	 logger.info("Remember Me radio is displayed.");
	 AssertJUnit.assertTrue(log.btn_signInFb.isDisplayed());
	 logger.info("SigninFB button is displayed.");
	 AssertJUnit.assertTrue(log.btn_signInGoogle.isDisplayed());
	 logger.info("SigninGoogle button is displayed.");
	 
}


@Test(priority=2)
public void verifyHeadNavForAllPages() {
	log = new LoginPage(driver);
	log.initElement();
	common = new CommonTestForAllPages();
	common.verifyNavBarHeaderContent(driver);
	
}

@Test(dataProvider= "getLoginData",priority=3) 
public void doSignin(String username, String password) throws IOException, InterruptedException {
	
	 landing= new LandingPage(driver);
	 landing.initElement(); 
	 landing.txt_login.click();
	 
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 
	 log =new LoginPage(landing.getDriver());
	 landing.initElement(log);
	 //LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	 
	 log.txt_userName.sendKeys(username);
	 log.txt_password.sendKeys(password);
	 log.btn_login.click();
 
	 // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 Dashboard dash = new Dashboard(log.getDriver());
			 //PageFactory.initElements(driver, Dashboard.class);
	 landing.initElement(dash);
	 
	 try {
 
		 WebElement element = dash.link_projects;
		 Actions builder = new Actions(driver);
		 builder.moveToElement(element).click().build().perform();
		
		 AssertJUnit.assertEquals(dash.link_projects.getText(),"Projects");
		 logger.info("Projects is displayed in Dashboard.");
		 
		// System.out.println("++++++++In Side Try++++++++++++"+ dash.link_projects.getText());
		 WebElement element2 = dash.link_collections;
		 Actions builder2 = new Actions(driver);
		 builder2.moveToElement(element2).click().build().perform();
		
		 AssertJUnit.assertEquals(dash.link_collections.getText(), "Collection");
		 logger.info("Collection is displayed in Dashboard.");
		 
		 dash.btn_logout.click();
		 }catch(Exception e) { 
		 AssertJUnit.assertEquals(driver.findElement(By.xpath("//p[@class='statusText error-msg']")).getText(), "Wrong email or password was provided."); 
		 logger.info("Wrong login message in showing successfully.");
		 
		 //System.out.println("++++++++In Side Catch++++++++++++");
		} 
	  
	 
//driver.quit();
//driver=null;

Thread.sleep(2000);

//basePageNavigation();
//Thread.sleep(2000);

}


@Test(priority=4)
public void doSigninAssertion() { 

 AssertJUnit.assertEquals(driver.getTitle(), "Write Way");
 logger.info("Writeway title is displayed successfully.");
 //System.out.println("+++++++++++++++++++++++IN Assertion+++++++++++++++++");
}

@DataProvider
public Object[][] getLoginData(){
 
 Object[][] data= new Object[2][2];
 data[0][0]= "niti@yopmail.com";
 data[0][1]= "asdF1234";
 
 data[1][0]= "niti5@yopmail.com";
 data[1][1]= "asdF1234";
 return data;
}

@AfterClass
public void closeBrowser() {
	System.out.println("Closing Landing page Test");
	Browser.close();
}


}

