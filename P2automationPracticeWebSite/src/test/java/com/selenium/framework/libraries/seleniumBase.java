package com.selenium.framework.libraries;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.selenium.framework.libraries.seleniumLibrary.Browser;

import org.testng.ITestResult;

public class seleniumBase {
	
  final static Logger logger = Logger.getLogger(seleniumBase.class);
   public static  seleniumLibrary library;
   public static WebDriver driver;
   private String browserType;
   String url = "http://automationpractice.com/index.php";
   

	
//This method run before the first test method in the invoked class.
@BeforeClass 
public void beforAllTheTestMethods () {
       logger.info("Automation Test Started on this line ...");
       
       
     //1-so by this 2 lines i gave order that b4 each &every class, do the next Line:
     //2-GO read the [key named:browser type] from the properties file which is located in the path(passed below)
     //3-& store ur reading in instance variable of the type : string under name 'browser type'
     //4-reason behind making instance variable :browser type is that i want to pass this value to @b4 method so we
     //5-can start load browser from properties file not from [driver=library.startBrowser(Browser.CHROME);] any more
     		JavaPropertiesManager propReader = new JavaPropertiesManager("src/test/resources/config.properties");
     		browserType = propReader.readProperty("browserType");
}


@BeforeMethod //this will be executed before EACH/Every test method!
public void setUp (ITestResult result) {
	
	try {

	library = new seleniumLibrary();
	//here i just added if statement that if the string box have chrome THEN apply the normal method-->selLib.startBrowser(Browser.CHROME);
	//then for complete coding format, we download all drivers and we put if statement to load correct driver as per the shown statement

	if(browserType.toLowerCase().contains("chrome")) {
		driver = library.startBrowser(Browser.CHROME);
		
	}else if(browserType.toLowerCase().contains("edgechromium")) {
		driver = library.startBrowser(Browser.EDGE_CHROMIUM);
		
	}else if(browserType.toLowerCase().contains("firefox")) {
		driver = library.startBrowser(Browser.FIREFOX);
		
	}else if(browserType.toLowerCase().contains("safari")) {
		driver = library.startBrowser(Browser.SAFARI);
		
	}else {//in this case 
		logger.info("Starting default browser type: Chrome");
		driver = library.startBrowser(Browser.CHROME);
	}
	//driver=library.startBrowser(com.selenium.framework.libraries.seleniumLibrary.Browser.CHROME);
	driver.get(url);
	library.customWait(2);
	String actualUrl = driver.getTitle();
	String expectedUrl = "My Store";
	assertEquals(actualUrl,expectedUrl);
	}catch (Exception e) {
		logger.error("Error: ", e );
	    assertTrue(false); 
    }
}

@AfterMethod //This will be executed after EACH&Every test method!
public void tearDown (ITestResult result) {
	
	if(ITestResult.FAILURE == result.getStatus()) {
		library.captureScreenshot();
	}

	if ( driver != null) {
		driver.close();
	}

}

@AfterClass //This will be executed after ALL test methods are done!
public void cleanUpAfterAllTestMethods() {		
	logger.info("After whole Class tests are completed || driver to quit...");
	
	
	
	if (driver != null) {
		driver.quit();
	}
   }
}
