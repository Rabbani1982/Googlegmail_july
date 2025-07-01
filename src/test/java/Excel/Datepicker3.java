package Excel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepicker3 {
	
	
	static void Selectdate(WebDriver driver,String month,String date,String year)
	{
		while(true)
		{
	String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"))			
			.getText();//actutal month
	String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"))
			.getText();//actual year
					
			if(currentMonth.equals(month) && currentYear.equals(year))
				{
						break;
				}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
					
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//Previous
		}
		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']"
				+ "//tbody//tr/td//a"));
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		} 
	}

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		
		driver.switchTo().frame(0);		
		
		
		driver.findElement(By.id("datepicker")).click();
		
		Selectdate(driver, "May","19","2027");

	}

}
