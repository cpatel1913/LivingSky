package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import resources.PageBase;

public class LoginPage extends PageBase{
	
	
	public LoginPage(WebDriver driver) {
	
		super(driver);
		this.setUrl("login");
	}


@FindBy(name= "email")
@CacheLookup
public WebElement txt_userName;

@FindBy(name= "password")
@CacheLookup
public WebElement txt_password;

@FindBy(css= ".continue > svg")
@CacheLookup
public WebElement btn_login;

@FindBy(xpath= "//span[@class='label-text']")
@CacheLookup
public WebElement radio_remember_me;

@FindBy(xpath= "//div[contains(text(),'Sign in with Facebook')]")
@CacheLookup
public WebElement btn_signInFb;

@FindBy(xpath= "//div[contains(text(),'Sign in with Google')]")
@CacheLookup
public WebElement btn_signInGoogle;

}
