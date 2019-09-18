 package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.browsermob.proxy;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
//import net.lightbody.bmp.core.*;
public class Browser {
 
	 private static WebDriver driver;
	
	 public static WebDriver getInstance() {
	        if (driver == null) {
	        	System.out.println("Driver === "+driver);
	            driver = getDefaultBrowser();
	        }
	        return driver;
	    }
	 public static void initBrowser()  {
		 cleanCookieCache();
		 setSize();
	        
	    }
	 
	 
	 public static void setSize() {
		 
		 driver.manage().window().maximize();
	 } 
	 private static WebDriver getDefaultBrowser() {
	        return getABrowser(System.getProperty("Browser"));
	    }

	    private static WebDriver getABrowser(final String browserName) {
	        if ("chrome".equals(browserName)) {
	            return initChrome();
	        } else if ("firefox".equals(browserName)) {
	            return initFirefox();
	        } else if ("ie".equals(browserName)) {
	            return initIE();
	        } else {
	            throw new RuntimeException("No Valid Browser Found");
	        }
	    }
	    
	    private static WebDriver initIE() {
	        WebDriverManager.iedriver().arch32().setup();

	        driver = new InternetExplorerDriver();
	        initBrowser();
	        return driver;
	    }

	    private static WebDriver initFirefox() {
	        WebDriverManager.firefoxdriver().setup();
	        disableDetailLoggingFirefox();
	        driver = new FirefoxDriver();
	        initBrowser();

	        FirefoxOptions options = new FirefoxOptions();
	        ProfilesIni allProfiles = new ProfilesIni();
	        FirefoxProfile selenium_profile = allProfiles.getProfile("selenium_profile");
	        options.setProfile(selenium_profile);
	        driver = new FirefoxDriver(options);
	        options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	        System.setProperty("webdriver.gecko.driver", "C:\\Users\\pburgr\\Desktop\\geckodriver-v0.20.0-win64\\geckodriver.exe");
	        driver = new FirefoxDriver(options);

	        return driver;
	    }

	    private static void disableDetailLoggingFirefox() {
	        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");//disable debug logging
	    } 

	    private static WebDriver initChrome() {
	        WebDriverManager.chromedriver().setup();
	      
	       // driver = new ChromeDriver();
	        
	     // start the proxy
	        BrowserMobProxy proxy = new BrowserMobProxyServer();
	        proxy.start(0);

	        // get the Selenium proxy object
	        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
	        
	        proxy.addRequestFilter((request, contents, messageInfo)->{
	            request.headers().add("x-qa-super-user-token", "NWQwNGE5OWUtY2Y3OC0xMWU5LWJkY2ItMmEyYWUyZGJjY2U0");
	            System.out.println(request.headers().entries().toString());
	            return null;
	        });
	        
	        String proxyOption = "--proxy-server=" + seleniumProxy.getHttpProxy();
	       
	        //-----------------------//
	        ChromeOptions option = new ChromeOptions();
	        option.addArguments(proxyOption);
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(ChromeOptions.CAPABILITY, option);
	        driver = new ChromeDriver(option);
	        initBrowser();
	        return driver;
	    }
	    
	    public void ClearChromeHistory() throws InterruptedException

	    {
	        //Navigate to History
	        driver.navigate().to("chrome://settings/clearBrowserData");//clearBrowsingDataDialog

	        WebElement ClearData = driver.findElement(By.id("clearBrowsingDataConfirm"));
	        ClearData.click();
	        Thread.sleep(5000);
	       /* List<WebElement> els = driver.findElements(By.id("checkbox"));
	        System.out.println(Integer.toString(els.size()));
	        for ( WebElement el : els ) {

	            Thread.sleep(2000);

	            el.click();
	            
	        }*/
	       
	    }

public void ClearBrowserCookies() throws InterruptedException
{
driver.manage().deleteAllCookies();//delete all cookies
Thread.sleep(5000); //wait 5 seconds to clear cookies.
}
public void clearChromeBrowserData() throws InterruptedException {
    driver.get("chrome://settings/clearBrowserData");
  //  driver.wait(2);
    Thread.sleep(2000);
    
     driver.findElement(By.id("clearBrowsingDataConfirm")).click();
}
private static void cleanCookieCache() {
    driver.manage().getCookies().clear();
    driver.manage().deleteAllCookies();

}


public static void close() {
	
    //driver.close();
    driver.quit();
    driver = null;// to avoid closing time of browser by JVM
}

}
