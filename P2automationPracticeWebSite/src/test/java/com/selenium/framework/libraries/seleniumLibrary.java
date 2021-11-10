package com.selenium.framework.libraries;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class seleniumLibrary {
	
    final static Logger logger = Logger.getLogger(seleniumLibrary.class);
	public static WebDriver driver;
	private int defaultWaitTimeInSecs= 50;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver _driver) {
		if (_driver != null) {
		this.driver = _driver;
	     }
	}
	
	//[ GM : This method to get 1 webelement text 'like purchasing cart txt' and compare it with given actual string text ]
	public void comparingtxtActualVsObserved (By by , String expectedTXT ) {
	WebElement element = driver.findElement(by);
	String TXT = element.getText();
	System.out.println(TXT);
	if (TXT.contains(expectedTXT)) {
		logger.info("This message to inform that Websitesearch engine couldnot find matching results to user input ");
	}
	else 
	  {System.out.println("Items found in websitedatabase");}
	
	
	
	}
	
//[ This Method to create a list of Webelements by the common xpath/css... between all the webelements of the list then to for loop the list and get each TXT and compare if each TXT doesnot have specific word or two ] 
public void listTXTComparison ( By by , String txtSaver, String checkThisWordInUrTxt) {
	List<WebElement> listName = driver.findElements(by);
	
	int counter=0; ///LIST
	for (int i = 0 ; i<listName.size(); i++ ) {
	 txtSaver = listName.get(i).getText();
	 
	 if (! txtSaver.contains(checkThisWordInUrTxt)) {
		
		 logger.info(" Mismatched item "+ "["+counter+"]"+ txtSaver);
		 counter ++; 
		 logger.info("Total # of elements have mismatch = " + counter);
	 }
	}	
 }
	
//[ This Method to create a list of Webelements by the common xpath/css... between all the webelements of the list then to for loop the list and get each TXT and compare if each TXT doesnot have specific word or two ] 
public void listTXTComparison2 ( By by , String txtSaver, String checkThisWordInUrTxt) {
	List<WebElement> listName = driver.findElements(by);
	
	int counter=0; ///LIST
	for (int i = 0 ; i<listName.size(); i++ ) {
	txtSaver = listName.get(i).getText();
	 
	 if ( txtSaver.contains(checkThisWordInUrTxt)) {
		 logger.info("Button text "+ "["+counter+"] : "+ txtSaver);
		 counter ++; 
		 
	     }
	 } 
}	
	
// [ GM  : ENUM :: Choose any browser ]
	public enum Browser {
		FIREFOX, CHROME, SAFARI, EDGE_CHROMIUM
	}
	
	public WebDriver startBrowser (Browser browser) {
		try {
		
		switch (browser) {
		
		case FIREFOX :
			driver = startFirefoxBrowser();
			break;
			
		case CHROME :
			driver= startChromeBrowser ();
			break;
		case SAFARI:
			driver = startSafariBrowser();
			break;
			
		case EDGE_CHROMIUM:
			driver = startEdgeChromiumBrowser();
			break;
		
		    default:
			logger.error("Currently we are not supporting this type of browser !");
			logger.error("Default browser set to Chrome");
			driver = startChromeBrowser();
			break;
		}
	} catch (Exception e) {
		logger.error("Error: ", e);
		assertTrue(false);
	}
		return driver;
	}
	
	private WebDriver startEdgeChromiumBrowser() {
		try {
			// logger.info("This method is not implemented yet! Start EdgeChromium");
			System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");

			logger.info("starting 'EdgeChromium' browser.");
			driver = new EdgeDriver();

			driver.manage().deleteAllCookies();
			setDriverWait();
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
		return driver;
	}

	private WebDriver startFirefoxBrowser() {
		try {
			// logger.info("This method is not implemented yet! Start Firefox");
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			logger.info("starting 'Firefox' browser.");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			setDriverWait();
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
		return driver;
	}

	private WebDriver startSafariBrowser() {
		try {
			logger.info("This method is not implemented yet! Start Safari");

		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
		return driver;
	}
	
// [ GM 1 : setting chrome browser - delete cookies - maximize window ]	 
  private WebDriver startChromeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			logger.info("Pre-test Preparation :: starting 'Chrome' browser.");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			setDriverWait();

		} catch (Exception e) {//catch error
			logger.error("Error: ", e);//Ensure save log for whatever in LOG File!
			assertTrue(false);//Stop Whole test to see where is issue if any ! 
		}
		return driver;
	}
  
//[ GM (private): driver + browser implicit wait  ]	
 private void setDriverWait () {
	
	 try {
	logger.info(" Pre-test Preparation :: Setting Implicitwait for selenium to wait driver opening then browser opening ");
	driver.manage().timeouts().implicitlyWait(defaultWaitTimeInSecs, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(defaultWaitTimeInSecs, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	}catch (Exception e) {
		logger.error("Error: ", e );
	    assertTrue(false); 
	}
  }
 
//[ GM 3 : Clicking any link  ]
 public void clickLinkOrButton (By by) {
	 try {
	 WebElement element =  driver.findElement(by);
	 element.click();
	 } catch (Exception e) {                //catch error
			logger.error("Error: ", e);     //Throw error message
			assertTrue(false);              //Stop The test
	}
 }
//[ GM 4 : setting dynamic wait - Till element of next page become visible  ]
 public WebElement dynamicWaitForVisibilityOfElement(By by) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, defaultWaitTimeInSecs);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
		return element;
	}
//[ GM 5 : setting dynamic wait - Till element of next page become Clickable  ]
 public WebElement dynamicWaitForElementToBeClickable(By by) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, defaultWaitTimeInSecs);
			element = wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
		return element;
	}
//[ GM6 : Locate element - clear element - send TXT  ]

 public void entertext (By by, String inputTxt) {
	 
	 try {
	 WebElement element = driver.findElement(by);
	 element.clear();
	 element.sendKeys(inputTxt);
	 }catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
 }
 
//[ GM 8 : Select From Static drop down list with Method Overloading||static=select ]
	public void selectDropDown(By by, String visibleTextOption) {
		try {
			Select tempSelect = selectDropDown(by);
			tempSelect.selectByVisibleText(visibleTextOption);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}

	public Select selectDropDown(By by) {
		Select selectDropdown = null;
		try {
			WebElement element = driver.findElement(by);
			selectDropdown = new Select(element);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
		return selectDropdown;
	}
	
//[ GM9 : This method moves ur mouse(Hover) to the element like Quicktools in usps site its not clicking its just moving .build.perform its NOT .click ]

	public void moveToElement(By by) {
		try {
			WebElement element = driver.findElement(by);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			customWait(0.5);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	
	//[ GM9 : same method above but using webelement]
	public void moveToElement(WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			customWait(0.5);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	//[ GM9 : This method highlight webelement which u send it as input 3 times & off - ONLY 4 HIGHLIGHT DONOT CONFUSE URSELF]
	public void highlightElement(WebElement element) {
		try {
			for (int i = 1; i < 4; i++) {
				//selenium got java script executer which help u send which help u send java script to browser since all browsers understand java script
				//We wrap the driver with Java script and make changes in the HTML file slight modifications for the colors and borders ON THE FLY but its not permanent modifications for sure!
				JavascriptExecutor js = (JavascriptExecutor) driver;

				//This will turn on the element - argument line: border - color line: font color-element is the quicktool btn for example u can get it by findelement by
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"color: red; border: 2px solid yellow");
				customWait(0.5);
				//This will turn off the element - argument line: border - color line: font color-element is the quicktool btn for example u can get it by findelement by
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
				customWait(0.5);
			}
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	
	//[ GM9 : This is very imp. method it moves mouse to quicktools [dynamic drpdwn list=element 1' but its not click on it just mousehover, once drop list happens automatically from element 1 then it will click any option u choose 'zip code=element 2 ' ]
	// in the midde of the method u already called the highlight method above so b4 each element 1 or 2 it will be turned on/off 3 times
	
	public void moveToElement(WebElement fromElem, WebElement toElem) {
		try {
			Actions action = new Actions(driver);
			highlightElement(fromElem);
			Actions action1 = action.moveToElement(fromElem);
			customWait(1);
			highlightElement(toElem);
			action1.moveToElement(toElem).click().perform();
			customWait(1);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	//[ GM10 : custom Wait ]
	public void customWait(double inSeconds) {
		try {
			Thread.sleep((long) (inSeconds * 1000));
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);			
		}
	}
	
	//[ GM11 : Scroll Left/right/up/down ]
	public void scrollLeftRight(int pixels) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(" + pixels + ",0)");
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
		}
	public void scrollUpDown(int pixels) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0," + pixels + ")");
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	
	public void clickHiddenElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	  }

	
	public boolean validateCartTxt (WebElement element, String expectedtxt) {
		try {
	    String observedText=element.getText();
	    logger.info("Cart Current Actual Observed Text value = " + observedText);
		if (observedText.equals(expectedtxt)) {
			
		}
			
	} catch (Exception e) {
		logger.error("Error: ", e);
		assertTrue(false);
	}
		return false;
   }
	
	public boolean validateCartTxtGetAttribute (WebElement element, String expectedtxt) {
		try {
	    String observedText=element.getAttribute("value");
	    logger.info("Cart Observed text value = " + observedText);
		if (observedText.equals(expectedtxt)) {
			return true;
		}
			
	} catch (Exception e) {
		logger.error("Error: ", e);
		assertTrue(false);
	}
		return false;
   }



//[GM : This method press click & hold on element then it can move it 0n X-Y offsets as per your input integers values ]
public void slideAnElement (WebElement button , int xHorizontalMoveOffset, int yVerticalMoveOffset) {
	Actions action=new Actions(driver);
	action.dragAndDropBy(button, xHorizontalMoveOffset , yVerticalMoveOffset).build().perform();
     }


//[GM : Take screen shot when needed and each time snap shot donot replace old one since unique time stamp is there in snaps name ]

public String captureScreenshot() {
	String screenshotFilePath = null;

	try {
		screenshotFilePath = "C:/SeleniumScreenShots/screenshot" + getCurrentTime() + ".png";
        //Locating screen shot file in temp location in Computer RAM
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//Transfer screen shot from Computer RAM to Permanent location file on pc
		Files.copy(scrFile, new File(screenshotFilePath));

	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("Screenshot File: " + screenshotFilePath);
	return screenshotFilePath;
}

public String getCurrentTime() {
	String finalTime = null;
	try {
		Date date = new Date();
		logger.debug("time1: " + date.toString());
		String tempTime = new Timestamp(date.getTime()).toString();
		logger.debug("time2: " + tempTime);
		finalTime = tempTime.replace("-", "").replace(" ", "").replace(":", "").replace(".", "");
		logger.debug("time3: " + finalTime);
	} catch (Exception e) {
		logger.error("Error: ", e);
		assertTrue(false);
	}
	return finalTime;
   }  

}
	
	
