package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import resources.PageBase;

public class LandingPage extends PageBase{
	
	
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
	}
	 
	@FindBy(css="a[href*='signup']")
	@CacheLookup
	public WebElement txt_signup;
	
	@FindBy(css="a[href*='login']")
	@CacheLookup
	public WebElement txt_login;
	/*
	@FindBy(xpath="//div[@class='header-content']//div[1]//nav[1]//ul[1]")
	@CacheLookup
	public WebElement navBar_HeaderContent1;
	
	@FindBy(xpath="//div[2]//nav[1]//ul[1]")
	@CacheLookup
	public WebElement navBar_HeaderContent2;*/
}
