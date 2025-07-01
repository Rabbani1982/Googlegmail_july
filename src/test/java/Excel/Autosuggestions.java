package Excel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestions {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Hyderabad");
		Thread.sleep(5000);
		//ul[@role='listbox']//li//div[@role='option']   //ul//li//div[@role='option']
		List<WebElement>  list = driver.findElements(By.xpath("//ul//li//div[@role='option']"));
		
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
			Thread.sleep(5000);
			
			for(WebElement ele:list)
			{
				
				ele.getText().equals("Hyderabad");
				ele.click();
			}
			
			/*if(list.get(i).getText().equals("selenium"))
			{
				list.get(i).click();
				break;
			}*/
		}

	}

}
