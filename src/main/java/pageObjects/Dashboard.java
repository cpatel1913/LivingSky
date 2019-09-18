package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import resources.PageBase;


public class Dashboard extends PageBase {
	
	
	public Dashboard(WebDriver driver) { 
		super(driver);
	} 
	
@FindBy(xpath= "//input[@placeholder='Search for a project']")
@CacheLookup
public WebElement nav_menuBar;

@FindBy(xpath= "//div[contains(text(),'Projects')]")
@CacheLookup
public WebElement link_projects;

@FindBy(xpath= "//div[contains(text(),'Collection')]")
@CacheLookup
public WebElement link_collections;

@FindBy(xpath=("//button[@class='logout']"))
@CacheLookup
public WebElement btn_logout;
}
