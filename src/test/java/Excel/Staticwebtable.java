package Excel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Staticwebtable {

	public static void main(String[] args) 
	{
		WebDriver  driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		
		//find the total number of rows in a table
List<WebElement> rows=driver.findElements(By.xpath("//table[@name='courses']//tbody//tr"));                 
				System.out.println(rows.size());
				
				//find the total number of columns in a table
				
				List<WebElement> cols=driver.findElements(By.xpath("//table[@name='courses']//tbody//th"));                 
				System.out.println(cols.size());
				
				//read the data from specific row and column
				
				   // String value  =driver.findElement(By.xpath("//table[@name='courses']//tr[2]//td[3]")).getText();
				    //System.out.println(value);
				
				    //read the data from all the rows and columns
				    
				    for(int r=2; r<=rows.size();r++)   //rows
				    {
				    	for(int c=1; c<=cols.size();c++)  //columns
				    	{
	String data =driver.findElement(By.xpath("//table[@name='courses']//tr["+r+"]//td["+c+"]")).getText();
				    	 System.out.print(data+"\t");
				    	}
				    	 System.out.println();
				    }
				
	}

}
