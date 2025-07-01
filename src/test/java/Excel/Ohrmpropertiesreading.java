package Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ohrmpropertiesreading {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//create a properties class object 		
				Properties propertiesobj=new Properties();
				//open the config.properties file  to read the data -fileinputstream
				
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\HRMLOGIN.properties");	

		  //Load the properties file
		  propertiesobj.load(file);
		  
		  //Read data from properties file
		  
		        String url =propertiesobj.getProperty("appurl");
		        String username =propertiesobj.getProperty("username");
		        String password =propertiesobj.getProperty("password");
		        
		        WebDriver driver = new ChromeDriver();
		        
		        driver.get(url);
		        Thread.sleep(5000);
		        driver.findElement(By.name("username")).sendKeys(username);
		        driver.findElement(By.name("password")).sendKeys(password);
		        

	}

}
