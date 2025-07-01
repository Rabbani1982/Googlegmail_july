package Excel;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Oneway {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        
            driver.get("https://www.goibibo.com/");
            
            driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();

            // Select one-way trip
          //  wait.until(ExpectedConditions.elementToBeClickable(By.id("oneWay"))).click();
            
            driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
            
            //from
            
            
     WebElement  from=driver.findElement(By.xpath("//p[text()='Enter city or airport']"));
     from.click();
     //from.sendKeys("Hyderabad");
     driver.findElement(By.id("autoSuggest-list")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
     //from.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            
            

	}

}
