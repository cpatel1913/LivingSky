package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import resources.PageBase;

public class SignUP extends PageBase{
	
	public SignUP(WebDriver driver) {
		
		super(driver);
		this.setUrl("signup");
	} 
	
	
@FindBy(name= "email")
@CacheLookup
public WebElement txt_userName;

@FindBy(name= "password")
@CacheLookup
public WebElement txt_password;

@FindBy(name= "confirmPassword")
@CacheLookup
public WebElement txt_confirmPassword;


@FindBy(xpath= "//div[@class='form-groups']//div[2]//div[1]//label[1]//span[1]")
@CacheLookup
public WebElement radio_termsandCond;	

@FindBy(css = ".check:nth-child(3)")
@CacheLookup
public WebElement radio_updates;

@FindBy(css = ".btn-text")
@CacheLookup
public WebElement btn_signUp;

@FindBy(name = "answer")
@CacheLookup
public WebElement txt_capcha;

@FindBy(xpath = "//*[@name='arrowCircleRight']")
//(css = ".continue > svg")
@CacheLookup
public WebElement btn_capcha;

}
