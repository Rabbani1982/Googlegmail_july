package Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HrmLoginproperties {

	public static void main(String[] args) throws IOException, InterruptedException 
	{

        Properties pobj=new Properties();
        
     FileInputStream  file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\Login.properties"); 
     pobj.load(file);
     
         String   url  =pobj.getProperty("appurl");
         String   username  =pobj.getProperty("username");
         String   password  =pobj.getProperty("password");
         
         
           WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
           
           driver.get(url);
           Thread.sleep(5000);
           driver.findElement(By.name("username")).sendKeys(username);
           driver.findElement(By.name("password")).sendKeys(password);
           driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium "
           		+ "oxd-button--main orangehrm-login-button']")).click();
           
           
         
     
     
    
    

	}

}
