package Excel;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Fixedcalc {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");		
		driver.manage().window().maximize();
		
		//interact with FD Calc form  elements
		//Comple path of the excel file stored in a filepath variable
		//D:\AUTOMATION\com.google.gmail\testdata1\Maturityamount.xlsx
	String filepath=System.getProperty("user.dir")+"\\testdata1\\Maturityamount.xlsx";
	
	//count rows from excel_sheet
	  int rows =Excelutils.getRowCount(filepath,"Sheet1");
	  
	  for(int i=1;i<=rows;i++)  //i represent row number  //i=1  1<=5 t
	  {
		  
		  // read data from excel		   
		String pric  =Excelutils.getCellData(filepath,"Sheet1",i,0); //i=1 0
		
		String roi =Excelutils.getCellData(filepath, "Sheet1",i,1); //i=1 1
		
		String per1  =Excelutils.getCellData(filepath, "Sheet1",i,2); //i=1 2
		
		String per2  =Excelutils.getCellData(filepath, "Sheet1",i,3); //1 3
		
		String fre =Excelutils.getCellData(filepath, "Sheet1",i,4); //1  4
		
		String exp_mvalue =Excelutils.getCellData(filepath, "Sheet1",i,5); //1  5
		
		//pass the above values into the application 
		
		driver.findElement(By.id("principal")).sendKeys(pric);
		Thread.sleep(5000);
		driver.findElement(By.id("interest")).sendKeys(roi);
		Thread.sleep(5000);
		driver.findElement(By.id("tenure")).sendKeys(per1);
		Thread.sleep(5000);
		
		Select period=new Select(driver.findElement(By.id("tenurePeriod")));
		       period.selectByVisibleText(per2);
		       Thread.sleep(5000);
		       
		  Select frequency2=new Select(driver.findElement(By.id("frequency")));
		  frequency2.selectByVisibleText(fre);
		  Thread.sleep(5000);
		  
    WebElement calbtn=driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
    Thread.sleep(5000);
		  
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click()",calbtn);
		 
		 //validation
 String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
		  
 			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue)) //convert String into Double
		  {
			  System.out.println("Test pass");
			  Excelutils.setCellData(filepath,"sheet1",i, 7,"passed");
			  Excelutils.fillGreenColour(filepath,"sheet1",i, 7);
		  }
 			else
 			{ System.out.println("Test failed");
			  Excelutils.setCellData(filepath,"sheet1",i, 7,"Failed");
			  Excelutils.fillRedColour(filepath,"sheet1",i, 7);
 				
 			}
 			////div[@class='CTR PT15']//a[2]     // //img[@class='PL5']
 		WebElement	clrbtn=driver.findElement(By.xpath("//img[@class='PL5']")); //InvalidElementStateException
 			
 			 //JavascriptExecutor js=(JavascriptExecutor)driver;
 			  js.executeScript("arguments[0].click()",clrbtn);
		 
	  }  
	  driver.quit();


	}

}
