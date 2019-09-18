package resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonTask {
	
	
	public List<WebElement> getLiElementInUl(WebElement path) {
		
		WebElement ul_element = path;
        List<WebElement> li_All = ul_element.findElements(By.tagName("li"));
        System.out.println(li_All.size());
       /* for(int i = 0; i < li_All.size(); i++){
            System.out.println(li_All.get(i).getText());
        }*/
        //OR
        for(WebElement element : li_All){
            System.out.println(element.getText());
        }
		return li_All;
	} 

} 
