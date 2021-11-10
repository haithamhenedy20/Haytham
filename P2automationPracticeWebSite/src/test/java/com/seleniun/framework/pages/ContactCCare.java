package com.seleniun.framework.pages;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.selenium.framework.libraries.seleniumBase;
import com.selenium.framework.libraries.seleniumLibrary;

public class ContactCCare extends seleniumBase {
	
	final static Logger logger = Logger.getLogger(ContactCCare.class);
    seleniumLibrary library = new seleniumLibrary();

    
    public ContactCCare clickContactUsInHomePage  () {
    	logger.info(" Test Case ## 5 ## Started [Contact With Customer Care] ");
    	logger.info(" Test Case # 5 || Step 1 :  Locating/Clicking Webelement ' contact us ' on the Main Hme page");
    	WebElement ContactUs = driver.findElement(By.cssSelector("#contact-link"));
    	ContactUs.click();
    	library.customWait(1.0);
    	
    	return this;
	  }

    	
    public ContactCCare chooseSubjectfromDrpList  (String VisibleTxt) {
    	logger.info(" Test Case # 5 || Step 2 :Locating & choose from static drp dwn list 'subject heading' ");
    	library.selectDropDown(By.cssSelector("#id_contact")).selectByVisibleText(VisibleTxt);//"Customer service"
    	return this;
      }
    
    
    public ContactCCare enteringEmail  (String email) {
    	logger.info(" Test Case # 5 || Step 3 :Locating email input field & enter right email address then order refrence ");
    	library.entertext(By.cssSelector("#email"), email);//"NJUSA@gmail.com"
    	logger.info("entering order Ref.' ");
    	return this;
      }
    
    public ContactCCare enteringReferenceNum  (String RefrenceNum) {
    	logger.info(" Test Case # 5 || Step 4 :Locating & entering order ref. ");
    	library.entertext(By.cssSelector("#id_order"), RefrenceNum);//"246789"
    	
    	return this;
    }
    

    public ContactCCare uploadingFile (String File) {
     	logger.info(" Test Case # 5 || Step 5 :uploading PDF invoice file & getting snapshot that file uplaoded");
    	WebElement chooseFileUploadingBtn = driver.findElement(By.cssSelector("#fileUpload"));
    	chooseFileUploadingBtn.sendKeys(File);//"C:/Users/haith/Downloads/IN126670.pdf"
    	library.customWait(2.0);
    	//library.captureScreenshot();
    	
    	return this;
}
    public ContactCCare typingEmailBody () {
     	logger.info(" Test Case # 5 || Step 6 : Typing Email Body  ");
    	library.entertext(By.cssSelector("#message"), "Hello,\r\n"
    			+ "\r\n"
    			+ "Please find attached and update the missing items not delivered to my address in the last received shipment !\r\n"
    			+ "");
    	library.customWait(2.0);
    	
    	return this;
	   }
    	
    public ContactCCare clickSendBtn () {
     	logger.info(" Test Case # 5 || Step 7 : clicking send button");
    	WebElement SendLink = driver.findElement(By.cssSelector("#submitMessage"));//#submitMessage
    	SendLink.click();
    	library.customWait(3.0);
    	//library.captureScreenshot();
    	
    	return this;
}
    public ContactCCare verifySiteMessageAfterMailSent () {
    	logger.info(" Test Case # 5 || Step 8 : getting website txt notifcation after email is already sent to make sure action completed ");
    	String CSS ="#center_column > p";
        WebElement notificationsentmail = driver.findElement(By.cssSelector(CSS));
        String txt= notificationsentmail.getText();
     	logger.info(" Confirmation message = "+txt);
    	logger.info(" Test Case ## 5 ## Ended [Contact With Customer Care] ");
    	Reporter.log("Yayyy my test is passed!!", true); //69- How to generate log in TestNG? 


    		return this;
    	   }
    	}
