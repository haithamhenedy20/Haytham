package differentTestings;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.selenium.framework.libraries.seleniumLibrary;

public class calendarJavaScript {
	
	  final static Logger logger = Logger.getLogger(calendarJavaScript.class);
		public static WebDriver driver;
		private int defaultWaitTimeInSecs= 30;
		private String url = "https://beta.spicejet.com/";
		public WebElement element=driver.findElement(By.cssSelector("#main-container > div > div.css-1dbjc4n.r-14lw9ot > div.css-1dbjc4n.r-14lw9ot.r-z2wwpe.r-vgw6uq.r-156q2ks.r-urutk0.r-8uuktl.r-136ojw6 > div.css-1dbjc4n.r-1pcd2l5.r-1uwte3a.r-m611by.r-bnwqim > div.css-1dbjc4n.r-19h5ruw.r-136ojw6 > div > div > div.css-1dbjc4n.r-14lw9ot.r-11u4nky.r-z2wwpe.r-1phboty.r-rs99b7.r-1loqt21.r-13awgt0.r-ymttw5.r-5njf8e.r-1otgn73 > div.css-1dbjc4n.r-1awozwy.r-18u37iz.r-1wtj0ep"));
	    public String dateValue = "Fri, 22 Oct 2021";
	    
		
	  
		@Test
		public void startChromeBrowser() {
			try {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				logger.info("Pre-test Preparation :: starting 'Chrome' browser.");
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				
				logger.info(" Pre-test Preparation :: Setting Implicitwait for selenium to wait driver opening then browser opening ");
				driver.manage().timeouts().implicitlyWait(defaultWaitTimeInSecs, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(defaultWaitTimeInSecs, TimeUnit.SECONDS);
				driver.manage().window().maximize();
                driver.get(url);
                Thread.sleep(defaultWaitTimeInSecs);
                
                
                
			} catch (Exception e) {//catch error
				logger.error("Error: ", e);//Ensure save log for whatever in LOG File!
				assertTrue(false);//Stop Whole test to see where is issue if any ! 
			}
			
		}
		public void calendarUsingJS (WebDriver driver, WebElement element , String dateValue) {
			
		try {
			
                JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('value', '"+dateValue+"');",element);
				Thread.sleep(defaultWaitTimeInSecs);
                
                driver.close();
                driver.quit();
		} catch (Exception e) {//catch error
			logger.error("Error: ", e);//Ensure save log for whatever in LOG File!
			assertTrue(false);//Stop Whole test to see where is issue if any ! 
		}
		
	}
                    
			

}
