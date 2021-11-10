package com.selenium.framework.tests;

import static org.testng.Assert.assertEquals;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JqueryTestingWidgets {
	
	public WebDriver driver;
	public String url = "https://jqueryui.com/";
	
	@Test
	public void initiation() {
		
		try {
		
		//Base should be created from here till the word --END--
		System.out.println("Step 1 : setting property for the system using chrome webdriver");
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	    
	    
		System.out.println("Step 2 : initiating the chrome webdriver & setting implicit wait to find webdriver then for selenium to wait browser openning");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		System.out.println("Step 3 : Maximizing the window /getting URL /scrooling down to catch widgets");
		driver.manage().window().maximize();
		driver.get(url);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 200)"); // scrolling down
		Thread.sleep(2 * 1000);
		
		
		System.out.println("Step 4 : Getting website title & comparing to the expected one using assert equal");
		String TitleExpected= driver.getTitle();
		String TitleActual="jQuery UI" ;
		System.out.println("[Website title Actual] = "+ TitleExpected + " // [Website title Expected] = " + TitleActual);
		assertEquals(TitleActual, TitleExpected);
		//--END--(base should end here)
		
		
		System.out.println("Step 5 : Locating sideBar / switching to I.Frame /explicitwait setting /locating&clicking section 2 ");
		WebElement sideBar2 = driver.findElementByCssSelector("#sidebar > aside:nth-child(2)");
		sideBar2.findElement(By.linkText("Accordion")).click();
		WebElement Iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(Iframe);
		WebElement accordionGrid = driver.findElement(By.id("accordion"));
		System.out.println(accordionGrid);
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-3 > span")));
		WebElement Section2Button= accordionGrid.findElement(By.cssSelector("#ui-id-3 > span"));
		Section2Button.click();
		Thread.sleep(3*1000);

		System.out.println("Step 6 : navigate to default/choosing next section by sideBar");
		driver.switchTo().defaultContent();
		sideBar2 = driver.findElementByCssSelector("#sidebar > aside:nth-child(2)");
		WebElement autoCompleteSection = sideBar2.findElement(By.linkText("Autocomplete"));
		autoCompleteSection.click();
		
		System.out.println("Step 7 : navigate to IFRAME/ Choosing tagsearchfield Box and send keys 'Java' ");
		Iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(Iframe);
		WebElement tagSearchField= driver.findElement(By.id("tags"));
		tagSearchField.clear();
		tagSearchField.sendKeys("ja");
		Thread.sleep(3*1000);
		
		
		System.out.println("Step 8 : navigate to default/choosing next section by sideBar");
		driver.switchTo().defaultContent();
		sideBar2 = driver.findElementByCssSelector("#sidebar > aside:nth-child(2)");
		WebElement buttonSideLink = sideBar2.findElement(By.linkText("Button"));
		buttonSideLink.click();
		
		System.out.println("Step 9 : navigate in IFRAME choosing buttonlink locating grid and pressing buttons 1 by 1");
		Iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(Iframe);
		WebElement widgetButtonsGrid = driver.findElement(By.cssSelector("body > div"));
		WebElement   firstButton  = widgetButtonsGrid.findElement(By.cssSelector("body > div > button"));
		firstButton.click();
		Thread.sleep(2*1000);
		
		System.out.println("Step 10 : navigate to default/choosing next section by sideBar");
		driver.switchTo().defaultContent();
		sideBar2 = driver.findElementByCssSelector("#sidebar > aside:nth-child(2)");
		WebElement CheckboxradioSideLink = sideBar2.findElement(By.linkText("Checkboxradio"));
		CheckboxradioSideLink.click();
		
		System.out.println("Step 11 : navigate in IFRAME choosing RADIOCHECKBOXES locating grid and pressing buttons 1 by 1");
		Iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(Iframe);
		widgetButtonsGrid = driver.findElement(By.cssSelector("body > div"));
		WebElement firstRadioButton = widgetButtonsGrid.findElement(By.cssSelector("body > div > fieldset:nth-child(3) > label:nth-child(2) > span.ui-checkboxradio-icon.ui-corner-all.ui-icon.ui-icon-background.ui-icon-blank"));
		firstRadioButton.click();
		Thread.sleep(1*1000);
		
		System.out.println("Step 12 : navigate to default/choosing next section by sideBar");
		driver.switchTo().defaultContent();
		sideBar2 = driver.findElementByCssSelector("#sidebar > aside:nth-child(2)");
		WebElement ControlgroupSideLink = sideBar2.findElement(By.linkText("Controlgroup"));
		ControlgroupSideLink.click();
		Thread.sleep(2*1000);
		
		
		System.out.println("Step 13 : Control group section: choosing buttons & drop down lists needed to buy a car");
		Iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(Iframe);
		WebElement drpDwn = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/fieldset[1]/div[1]/span[1]"));
		drpDwn.click();
		WebElement childMidSize= driver.findElement(By.cssSelector("#ui-id-3"));
		childMidSize.click();
		//Locating radio button
        WebElement qty= driver.findElement(By.cssSelector("div.widget:nth-child(1) fieldset:nth-child(2) div.controlgroup.ui-controlgroup.ui-controlgroup-horizontal.ui-helper-clearfix:nth-child(2) span.ui-widget.ui-widget-content.ui-spinner.ui-controlgroup-item:nth-child(10) a.ui-button.ui-widget.ui-spinner-button.ui-button-icon-only.ui-spinner-up:nth-child(2) > span.ui-button-icon.ui-icon.ui-icon-triangle-1-n"));
        qty.click();
   
    	System.out.println("Step 14 : navigate to default/choosing next section(datepicker) by sideBar");
		driver.switchTo().defaultContent();
		sideBar2 = driver.findElementByCssSelector("#sidebar > aside:nth-child(2)");
		WebElement datePickerSideLink = sideBar2.findElement(By.linkText("Datepicker"));
		datePickerSideLink.click();
		
		
		System.out.println("Step 15 : Calendar automation-choosing anydate within THE PRESENT month 'JUNE'");
		
		Iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(Iframe);
		WebElement calendarBox = driver.findElement(By.cssSelector("#datepicker"));
		calendarBox.click();
		//this is a for loop to choose any date within the shown month ...
		//Creating webelement lists contains all days of JUNE-2021
		java.util.List<WebElement> June  = driver.findElements(By.cssSelector("td[data-month='6']"));
		//For loop to go through the list element by element then compare it to required day--> 16-June
		for (int i =0; i<June.size() ; i++ ) {
			String Value = June.get(i).getText();
			if (Value.equalsIgnoreCase("16")) {
				 June.get(i).click();
				Thread.sleep(2*1000);
				 break;}}
		
		
		System.out.println("Step 16 : navigate to default/choosing next section(selectMenu) by sideBar");
		driver.switchTo().defaultContent();
		sideBar2 = driver.findElementByCssSelector("#sidebar > aside:nth-child(2)");
		WebElement SelectmenuSideLink = sideBar2.findElement(By.linkText("Selectmenu"));
		SelectmenuSideLink.click();
			
		
		
		System.out.println("Step 17 : 'select menu' fields section 2 fields choosen here speed & number fields");
		Iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(Iframe);
		//select speed button drop down
		WebElement speedButtonDrpDwn = driver.findElement(By.cssSelector("#speed-button"));
		speedButtonDrpDwn.click();
		WebElement fastChoice = driver.findElement(By.cssSelector("#ui-id-4"));
		fastChoice.click();
		js.executeScript("scroll(0, 400)"); // scrolling down
		//select number drop down
		WebElement selectNumberDrpDwn= driver.findElement(By.cssSelector("#number-button"));
		selectNumberDrpDwn.click();
		WebElement sixChoice= driver.findElement(By.cssSelector("#ui-id-9"));
		 sixChoice.click();
		Thread.sleep(4*1000);

		System.out.println("Step 16 : navigate to default/choosing next section(selectMenu) by sideBar");
		driver.switchTo().defaultContent();
		sideBar2 = driver.findElementByCssSelector("#sidebar > aside:nth-child(2)");
		WebElement sliderSideLink = sideBar2.findElement(By.linkText("Slider"));
		sliderSideLink.click();
		
		System.out.println("Step 17 : navigate in IFRAME, choosing slider element & do sliding for it ");
		Iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(Iframe);
		WebElement sliderButton = driver.findElement(By.id("slider"));
		Actions action=new Actions(driver);
		action.dragAndDropBy(sliderButton, 300, 150).build().perform();
       
        System.out.println("Step 18 : navigate to default/choosing next section(selectMenu) by sideBar");
		driver.switchTo().defaultContent();
		sideBar2 = driver.findElementByCssSelector("#sidebar > aside:nth-child(2)");
		WebElement TabsSideLink = sideBar2.findElement(By.linkText("Tabs"));
		TabsSideLink.click();
		
		System.out.println("Step 19 : navigate in IFRAME, locating TAB GRID, then chossing element one by one throw this main grid");
		Iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(Iframe);
		WebElement tabGrid = driver.findElement(By.xpath("//body/div[@id='tabs']/ul[1]"));
		WebElement proinDolarTab= tabGrid.findElement(By.cssSelector("#ui-id-2"));
		proinDolarTab.click();
        Thread.sleep(4 * 1000);
		
		System.out.println("Step 20 : navigate to default/choosing next section(Tooltip) by sideBar");
		driver.switchTo().defaultContent();
		sideBar2 = driver.findElementByCssSelector("#sidebar > aside:nth-child(2)");
		WebElement TooltipSideLink = sideBar2.findElement(By.linkText("Tooltip"));
		TooltipSideLink.click();
		
		System.out.println("Step 21 : navigate in IFRAME, locating source/destination then drag/drop link ");
		Iframe = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(Iframe);
		WebElement sourcepoint = driver.findElement(By.xpath("//a[contains(text(),'Tooltips')]"));
		WebElement destinationPoint= driver.findElement(By.cssSelector("#age"));
		action.dragAndDrop(sourcepoint, destinationPoint);
		Thread.sleep(6 * 1000);
	    	
	
	    System.out.println(" close the browser ! ");
		driver.close();
		driver.quit();
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
