package Excel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DP1 {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		//expected values
		String year="2023";
		String month="December";
		String date="25";
		
		driver.findElement(By.id("datepicker")).click();
		
		//select  month and year
		
		  while(true)
		  {
			 String  act_month  =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			 String  act_year  =driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			 
			     if(act_month.equals(month) &&  act_year.equals(year))   
			     {
			    	 break;
			     }
		 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		  }
		
		  
		  // select the date
		  
		List<WebElement>  dates  =driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		
		   for(WebElement dt:dates)
		   {
			   if(dt.getText().equals(date))
			   {
				    dt.click();
				    break;
			   }
		   }
		
		

	}

}
