package com.selenium.framework.libraries;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Base {

	
	public WebDriver driver;
	public String url = "https://jqueryui.com/";
	
	@Test
	public void doublecheck () {

	try {
	
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
	
	System.out.println("Step 4 : Getting website title & comparing to the expected one using assert equal");
	String TitleExpected= driver.getTitle();
	String TitleActual="jQuery UI" ;
	System.out.println("[Website title Actual] = "+ TitleExpected + " // [Website title Expected] = " + TitleActual);
	assertEquals(TitleActual, TitleExpected);
	
	System.out.println("Step 4' : Locating sideBar");
	WebElement sideBar = driver.findElement(By.className("widget"));
     sideBar.findElement(By.linkText("Droppable")).click();
   
    
    System.out.println(" close the browser ! ");
	driver.close();
	driver.quit();
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	

	
}

}
