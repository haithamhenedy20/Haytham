package com.seleniun.framework.pages;

import static org.testng.Assert.assertNotNull;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.selenium.framework.libraries.seleniumBase;
import com.selenium.framework.libraries.seleniumLibrary;


public class CreateNewAccount extends seleniumBase {
	
	final static Logger logger = Logger.getLogger(CreateNewAccount.class);
	seleniumLibrary library = new seleniumLibrary();
	

	public CreateNewAccount ClickSignIn () {
		logger.info(" Test Case # 1.1 # Started :  [Verify if user can creat account with no issues]   ");
		logger.info(" Test Case # 1.1 # : Step 1 : Clicking Signin link in Home Page ");
		library.clickLinkOrButton(By.partialLinkText("Sign"));
		library.scrollUpDown(300);
		library.customWait(1.0);
		
		logger.info("Test Case # 1.1 # : Step 2 : waiting for Web Page 2 loading by setting explicit wait visibility of entering email address field" );
		WebElement enterEmailAddressField = library.dynamicWaitForVisibilityOfElement(By.cssSelector("#email_create"));
	    assertNotNull(enterEmailAddressField," 'Email Address Field' is not visible-Navigating to next poage [creat account page] is penidng");
		return this;
	    }
	
	  public CreateNewAccount enteringUniqueEmailAddressWithTimeStamp (String inputTXT) {
	   logger.info("Test Case # 1.1 # : Step 3 : Entering user Email address || Clicking creat account link " );
	   library.entertext(By.cssSelector("#email_create"), inputTXT );
	   return this;
	   
	   }
	  public CreateNewAccount ClickSubmitButton() {
	   library.clickLinkOrButton(By.cssSelector("#SubmitCreate"));
	   library.customWait(2.0);
	   logger.info("Test Case # 1.1 # : Step 4 : Set Dynamic Wait for Visibilty of personal info page " );		
	   WebElement firstNameWebElement = library.dynamicWaitForVisibilityOfElement(By.cssSelector("#customer_firstname"));
	   assertNotNull(firstNameWebElement,"First Name Field is not visible-creat account action is penidng");
	   return this;
	   
	    }
		
		public CreateNewAccount specifygender () {
		logger.info("Test Case # 1.1 # : Step 5 : Specifying Gender.. " );		
		library.clickLinkOrButton(By.cssSelector("#id_gender1"));
		return this;
	    }
		
		public CreateNewAccount enteringFirstname ( String FirstName) {
		logger.info("Test Case # 1.1 # : Step 6 : Entering Email Address Then Password " );
		library.entertext(By.cssSelector("#customer_firstname"), "FirstName");
		return this;
		}
		
		public CreateNewAccount enteringLasttname (String LastName) {
		library.entertext(By.cssSelector("#customer_lastname"), "LastName");
		return this;
		}
		
		public CreateNewAccount enteringPassword (String Password) {
		library.entertext(By.cssSelector("#passwd"), "Password");//NJUSA@@@@
		library.customWait(2.0);
		return this;
		}	
	    
	    public CreateNewAccount dropDownStaticenteringBirthDay (int Day) {
		logger.info("Test Case # 1.1 # : Step 7 : Entering Date Of Birth from static drop down lists");
	    library.selectDropDown(By.cssSelector("#days")).selectByIndex(Day);
	    library.scrollUpDown(300);
	     return this;
		}
	    
	    public CreateNewAccount dropDownStaticenteringBirthMonth (int month) {
	    library.selectDropDown(By.cssSelector("#months")).selectByIndex(month);
	    return this;
	    }
	    
	    public CreateNewAccount dropDownStaticenteringBirthYear (int Year) {
	    library.selectDropDown(By.cssSelector("#years")).selectByIndex(Year);
	    library.customWait(3.0);
	    return this;
	    }

		public CreateNewAccount enteringFirstNameForAddressDetails(String FirstName) {
		logger.info("Test Case # 1.1 # : step 8: Entering Address Details");
		library.scrollUpDown(300);
		library.entertext(By.id("firstname"), "FirstName");
		return this;
		}
		
		public CreateNewAccount enteringLastNameForAddressDetails(String LastName) {
		library.entertext(By.cssSelector("#lastname"), "LastName");//Loui
		return this;
        }
		
		public CreateNewAccount enteringCompanyNameForAddressDetails(String CompanyName) {
		library.entertext(By.cssSelector("#company"), "CompanyName");
		return this;
	    }
		public CreateNewAccount enteringFullAddressDetails(String Address) {
		library.entertext(By.cssSelector("#address1"), "Address");
		return this;
	    }
		public CreateNewAccount enteringCityName(String City) {
		library.entertext(By.cssSelector("#city"), "City");
		return this;
	    }
		public CreateNewAccount enteringZipCode(String ZipCode) {
		library.entertext(By.cssSelector("#postcode"), "08852");
		library.customWait(0.9);
		return this;
	    }
	
	public CreateNewAccount dropDownStaticListState (String State) {

		logger.info("Test Case # 1.1 # : Step 9 : Entering state & country from static drop list");	
		library.scrollUpDown(300);
		library.selectDropDown(By.cssSelector("#id_state")).selectByVisibleText(State);//"Arizona"
		return this;
     	}
	public CreateNewAccount dropDownStaticListCountry (String Country) {
		library.selectDropDown(By.cssSelector("#id_country")).selectByVisibleText(Country);//"United States"
		library.customWait(2.0);
		return this;
		}
	
    public CreateNewAccount phoneContact (String PhoneNum) {

	    logger.info("Test Case # 1.1 # : step 10 : Filling Phone & backupaddress ");
	    library.scrollUpDown(300);
	    library.entertext(By.cssSelector("#phone_mobile"), PhoneNum);//"8476679514"
	    return this;
	 	}
    
    public CreateNewAccount AliasAddressAndClickSubmit (String aliasAddr) {
		library.entertext(By.cssSelector("#alias"), aliasAddr );//"Georgia"
		library.clickLinkOrButton(By.xpath("//button[@id='submitAccount']"));
		library.customWait(2.0);
		logger.info("Test Case # 1.1 # : step 11 : Setting dynamic wait for next page of account creation completion is loaded ");
		String orderHistoryXpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]";
		WebElement orderHistorylink = library.dynamicWaitForElementToBeClickable(By.xpath(orderHistoryXpath));
		assertNotNull(orderHistorylink,"order History &details link Field is not Clickable- Loading [MY ACCOUNT] page is penidng");
	    logger.info("Test Case # 1.1 # : step 12 : Congratulations Your New Account Is Created !! ");
	    logger.info(" Test Case # 1.1 ### Ended ### "); 
		return this;
   }
}
