package Excel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Swebtable 
{

	public static void main(String[] args) 
	{
		WebDriver  driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		
		//find total number of rows in a table
		
 List<WebElement>  rows =driver.findElements(By.xpath("//table[@name='courses']//tr"));
            System.out.println("tot rows"+ rows.size()); 
     //find total number of columns in a table 
   List<WebElement>  col =driver.findElements(By.xpath("//table[@name='courses']//th"));
            System.out.println("tot colms"+ col.size()); 
            
      //read the data from specific row and column 4th row and 3rd column
   String  price =driver.findElement(By.xpath("//table[@name='courses']//tr[4]//td[3]")).getText();
   System.out.println(price);
   
   System.out.println("\t"+"Author"+"\t"+"Course"+"\t"+"Price");
   
   //read data from all the rows and columns
     for(int r=2;r<=rows.size();r++)
     {
    	 for(int c=1;c<=col.size(); c++)
    	 {
    	String	 values=driver.findElement(By.xpath("//table[@name='courses']//tr["+r+"]//td["+c+"]")).getText();
    	System.out.print(values+"\t");
    	 }
    	 
    	 System.out.println();
     }      
            
            
         

	}

}
