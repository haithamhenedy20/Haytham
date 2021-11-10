package com.selenium.framework.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Random {
		
		public WebDriver driver;
		public String url = "http://automationpractice.com/index.php";
		
		@Test
		public void initiation() {
			
			try {
			
			//Base till word --END--
			System.out.println("Step 1 : setting property for the system using chrome webdriver");
		    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		    
		    
			System.out.println("Step 2 : initiating the chrome webdriver & setting implicit wait to find webdriver then for selenium to wait browser openning");
			ChromeDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			
			System.out.println("Step 3 : Maximizing the window /getting URL ");
			driver.manage().window().maximize();
			driver.get(url);
			Thread.sleep(2 * 1000);
			
			
			System.out.println("Step 4 : Getting website title & comparing to the expected one using assert equal function");
			String TitleExpected= driver.getTitle();
			String TitleActual="jQuery UI" ;
			System.out.println("[Website title Actual] = "+TitleExpected+ " // [Website title Expected] = " + TitleActual);
		
			//--END-- (this should be end of the base class in future projects coding)--
	
		    System.out.println(" close the browser ! ");
			driver.close();
			driver.quit();
			
			}catch (Exception e) {
				e.printStackTrace();
			}		
	}
		
}
