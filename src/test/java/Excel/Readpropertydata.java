package Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readpropertydata {

	public static void main(String[] args) throws IOException 
	{
		          //create a properties class object 		
				Properties propertiesobj=new Properties();
				
//open the config.properties file  to read the data -fileinputstream	
				
FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata1\\config.properties");
     //load the property file
    propertiesobj.load(file);
    
     //Read the data from property file    
                      
               String      url  = propertiesobj.getProperty("appurl");
              String username   = propertiesobj.getProperty("username");
              String  pwd     =  propertiesobj.getProperty("password");                
               String emial   = propertiesobj.getProperty("email");
               
               
               System.out.println(url);
               System.out.println(username);
               System.out.println(pwd);
               System.out.println(emial);
               
              
                                   
        


				
		
	}

}
