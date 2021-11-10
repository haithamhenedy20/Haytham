package com.selenium.framework.tests;


import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JqueryTestingInteractions {
	
	public WebDriver driver;
	public String url = "https://jqueryui.com/";
	
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
		System.out.println("[Website title Actual] = "+ TitleExpected + " // [Website title Expected] = " + TitleActual);
		assertEquals(TitleActual, TitleExpected);
		//--END-- (this should be end of the base class in future projects coding)--
		
		
		System.out.println("Step 4' : Locating sideBar to call sidelinks one by one when needed then calling 1st side link -->Draggable ");
		WebElement sideBar = driver.findElement(By.className("widget"));
		sideBar.findElement(By.linkText("Draggable")).click();
		

		System.out.println("Step 7 : Locating/switching to I.Frame then interact with webelements inside any side link" );
		WebElement Iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(Iframe);
		
		
		 System.out.println("Step 8 : Locating the draggable square element using xpath" );
		 WebElement draggable = driver.findElement(By.xpath("//div[@id= 'draggable']"));
		 
		 System.out.println("Step 9 : activating Action class object & drop/drag the element " );
		 Actions action=new Actions(driver);
		 action.dragAndDropBy(draggable, 300, 150).build().perform();
		 
		
		 System.out.println("Step 10 : Swith mouse to default,set explicit wait & redefine sidebar element dueto common alarm appeared to me--> 'stale' element reference Issue" );
		 driver.switchTo().defaultContent();
		 WebDriverWait wait=new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Droppable")));
	     //refreshing here sideBar element location as this site HTML have issue...
	     sideBar = driver.findElement(By.className("widget"));
	     
	     
		 System.out.println("Step 11 : locating 'Droppable List'& Click it " );
	     WebElement DroppableList= sideBar.findElement(By.linkText("Droppable"));
	     DroppableList.click();
	     Thread.sleep(2 * 1000);
	     
	    
	    System.out.println("Step 12 : relocating the IFrame & draggable Square dueto stale alarm then swith to IFrame and do DRAG&DROP then switch mouse to default" );
	    Iframe = driver.findElement(By.className("demo-frame"));
	  	driver.switchTo().frame(Iframe);
	   	WebElement DropHereSquare= driver.findElement(By.id("droppable"));
	   	draggable = driver.findElement(By.xpath("//div[@id= 'draggable']"));
	   	action.dragAndDrop(draggable, DropHereSquare).perform();
	   	
	  	
	   	System.out.println("Step 13 : navigate to default/re-Locating sideBar(stalen alarm)/choosing next section by sideBar(resizable link section)");
	   	driver.switchTo().defaultContent();
		sideBar = driver.findElement(By.className("widget"));
		sideBar.findElement(By.linkText("Resizable")).click();
	
		
	    System.out.println("Step 13 : directing mouse to IFrame,locating resize box and drag&drop to do element resize ");
	    Iframe = driver.findElement(By.className("demo-frame"));
	    driver.switchTo().frame(Iframe);
	    WebElement resizeBox= driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));  
	    action.dragAndDropBy(resizeBox, 60, 20).build().perform();
		driver.switchTo().defaultContent();

	   	 System.out.println("Step 14 : re-Locating sideBar element(stalen alm), clicking 'Selectable' sidebar,switch to frame click item then go out of frame");
	   	 sideBar = driver.findElement(By.className("widget"));
		 sideBar.findElement(By.linkText("Selectable")).click();
		 Iframe = driver.findElement(By.className("demo-frame"));
		 driver.switchTo().frame(Iframe);
		 WebElement allSelectItemsSheet = driver.findElement(By.className("ui-selectable"));
		 allSelectItemsSheet.findElement(By.cssSelector("#selectable > li:nth-child(2)")).click();
		 driver.switchTo().defaultContent();
		 Thread.sleep(2*1000);
	   	
	  
	    System.out.println(" close the browser ! ");
		driver.close();
		driver.quit();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
