package LST.Lst;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import LST.core.TestBase;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SignUP;
import resources.CommonTask;
import resources.HeaderNavigation;

public class CommonTestForAllPages {
	//private WebDriver driver;
	private HeaderNavigation headNav;
	public static Logger logger = LogManager.getLogger(TestBase.class.getName());

	//Verify the Navigation
	public void verifyNavBarHeaderContent(WebDriver driver) {
		
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		headNav = new HeaderNavigation(driver);
		headNav.initElement();
		WebElement path = headNav.navBar_HeaderContent1;
		CommonTask ct = new CommonTask();
		List<WebElement> navBarContent1 = ct.getLiElementInUl(path);
		
		 Assert.assertEquals(navBarContent1.get(0).getText(), "Features");
		 logger.info("Features link is available in header.");
		 Assert.assertEquals(navBarContent1.get(1).getText(), "Pricing");
		 logger.info("Pricing link is available in header.");

		 WebElement path1 = headNav.navBar_HeaderContent2;
		 List<WebElement> navBarContent2 = ct.getLiElementInUl(path1);
			
		 Assert.assertEquals(navBarContent2.get(0).getText(), "Sign In");
		 logger.info("Sign In link is available in header.");
		 Assert.assertEquals(navBarContent2.get(1).getText(), "Try it for free");
		 logger.info("Try it for free link is available in header.");
			
		 
	}
}
 