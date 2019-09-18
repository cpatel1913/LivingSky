package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class PageBase {
	
	public HeaderNavigation headNav;
	
	public String name;
	public String title;
	public int timeout = 15;

	public String pageUrl;
    public String pageLoadText;
    public WebDriver driver; 
    
    public PageBase(WebDriver aDriver) {
        this.driver = aDriver;
        initElement(this);
    }
   
	public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return pageUrl;
    }

    public void setUrl(String purl) {
        this.pageUrl = purl;
    }
    
    

	public String getPageLoadText() {
		return pageLoadText;
	}

	public void setPageLoadText(String pageLoadText) {
		this.pageLoadText = pageLoadText;
	}

	
    
    
    public WebDriver getDriver() {
		return driver;
	}
    public <AnyPage extends PageBase> AnyPage initElement(AnyPage apage) {
    	PageFactory.initElements(driver, apage);
    	
    	return apage;
    }
    public void initElement() {
        initElement(this);
        
    }
    
    public void navigate(String baseUrl) {
        driver.get(baseUrl + pageUrl);
    }
    
    public PageBase verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(
                new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        return d.getPageSource().contains(pageLoadText);
                    }
                });
        return this;
    }
    
    public PageBase verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    
}
 