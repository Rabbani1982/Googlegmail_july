package Excel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cal1 {

	public static void main(String[] args) 
	{

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		//driver.findElement(By.id("datepicker")).sendKeys("06/25/2025");
		
		driver.findElement(By.id("datepicker")).click();

	}

}
