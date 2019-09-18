package LST.core;


import java.io.IOException;
import java.util.Properties;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import pageObjects.Browser;

//import pageObject.Browser;
public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String baseUrl;
	
	
public  void basePageNavigation() throws IOException, InterruptedException {
    
    //driver = Browser.getInstance();
  
    System.out.println(" URL is : ===="+baseUrl);
    //driver.get(baseUrl);
    Thread.sleep(2000);
}

public TestBase()
{
	try {
		PropertyLoader.loadProperties();
		baseUrl = System.getProperty("url");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@BeforeClass

public static void initForTestCase() throws IOException {
	
	  
}

}
