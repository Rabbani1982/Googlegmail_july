package Excel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggest {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		  driver.findElement(By.name("q")).sendKeys("selenium");
		  Thread.sleep(5000);
		  
List<WebElement> list = driver.findElements(By.xpath("//ul//li//div[@role='option']"));
           
                 System.out.println(list.size()); //10
		
                 
               for(WebElement op:list)
               {
            	   op.getText().equals("selenium testing");
            	   op.click();
            	   break;
               }
		

	}

}
