package Excel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DP2 
{
	
	  static void selectmonthandyear(WebDriver driver,String month,String year)
	  {
		  while(true)
		  {
			 String  act_month  =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			 String  act_year  =driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			 
			     if(act_month.equals(month) &&  act_year.equals(year))   
			     {
			    	 break;
			     }
			     
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		  }
	  }
	  
	  
	   static void selectdate(WebDriver driver,String date)
	   {
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
		
		DP2.selectmonthandyear(driver, "March","2029");
		DP2.selectdate(driver, "19");
		
		

	}	
	

}
