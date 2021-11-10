package com.selenium.framework.libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class myLibrary {
	
	public WebDriver driver;
	
	public void locatingToIframe (By by ) {
		
		WebElement element = driver.findElement(by);
		driver.switchTo().frame(element);
	}

	public void dropAndDragByOffset (WebElement element , int x, int y) {
	
	Actions action=new Actions(driver);
	 action.dragAndDropBy(element, x, y).build().perform();
	   }
	}
	

