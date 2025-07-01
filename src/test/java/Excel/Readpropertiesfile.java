package Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Readpropertiesfile {

	public static void main(String[] args) throws IOException 
	{
		//create a properties class object 		
		Properties propertiesobj=new Properties();
		//open the config.properties file  to read the data -fileinputstream
		
FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");	

  //Load the properties file
  propertiesobj.load(file);
  
  //Read data from properties file
  
        String url =propertiesobj.getProperty("appurl");
        String email =propertiesobj.getProperty("email");
        String password =propertiesobj.getProperty("password");
        
        System.out.println(url);   
        
       System.out.println(password);        
        

	}

}
