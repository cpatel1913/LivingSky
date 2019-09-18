package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HeaderNavigation extends PageBase{
	
public WebDriver driver;
	
	public HeaderNavigation(WebDriver driver)
	{
		super(driver); 
	}
	
	
	@FindBy(xpath="//div[@class='header-content']//div[1]//nav[1]//ul[1]")
	@CacheLookup
	public WebElement navBar_HeaderContent1;
	
	@FindBy(xpath="//div[2]//nav[1]//ul[1]")
	@CacheLookup
	public WebElement navBar_HeaderContent2;

}
