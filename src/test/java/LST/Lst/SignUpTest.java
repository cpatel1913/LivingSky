package LST.Lst;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import LST.core.TestBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import pageObjects.Browser;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SignUP;

public class SignUpTest extends TestBase{
	
private LandingPage landing;	
private SignUP signup;
private CommonTestForAllPages common;
	
@BeforeClass
	
	public void openBrowser() throws IOException, InterruptedException {
	driver = Browser.getInstance();
	driver.get(baseUrl);
	
	}
	

@Test(priority=1)
public void verifyHeadNavForAllPages() {
	signup = new SignUP(driver);
	signup.initElement();
	common = new CommonTestForAllPages();
	common.verifyNavBarHeaderContent(driver);
	
}
 
	
 @Test(priority=2)
 public void checkSignupA() throws InterruptedException {
	// basePageNavigation();
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 

	 landing= new LandingPage(driver);
	 landing.initElement();
	 signup = new SignUP(landing.getDriver());
	 signup.initElement();
	 
	 landing.txt_signup.click();
		 
	 signup.verifyPageUrl();
	 
	 signup.txt_userName.click();
	 signup.txt_userName.sendKeys("abtyuy1@yopmail.com");
	    
	 signup.txt_password.click();
	    
	 signup.txt_password.sendKeys("asdF1234");
	   	
	 signup.txt_confirmPassword.click();
	 signup.txt_confirmPassword.sendKeys("asdF1234");
	 signup.radio_termsandCond.click();
	 signup.radio_updates.click();
	 signup.btn_signUp.click();
	 signup.txt_capcha.click();
	 signup.txt_capcha.sendKeys("ssssfdg");
	    Thread.sleep(200); 
	    signup.btn_capcha.click();
	    Thread.sleep(20000); 
	    //driver.findElement(By.cssSelector(".content-canvas__container")).click();
	 
	 
	 System.out.println("+++++++++++++++++++++++IN Signup+++++++++++++++++");
			
 }


@AfterClass
public  void closeBrowser() {
	System.out.println("Closing Signup page Test");
    Browser.close();
}

}
