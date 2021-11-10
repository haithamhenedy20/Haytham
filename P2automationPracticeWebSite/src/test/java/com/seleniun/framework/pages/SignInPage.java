package com.seleniun.framework.pages;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;


import com.selenium.framework.libraries.seleniumBase;
import com.selenium.framework.libraries.seleniumLibrary;

public class SignInPage extends seleniumBase {
	
	    final static Logger logger = Logger.getLogger(SignInPage.class);
	    seleniumLibrary library = new seleniumLibrary();
	    
		public SignInPage ClickSignInAtHomePage () {
			
			logger.info("Action ## Clicking Signin link in the website Homepage  ");
			library.clickLinkOrButton(By.partialLinkText("Sign"));
			library.scrollUpDown(300);
			library.customWait(2.0);
		return this;
	 }
		
		
			//Test Case 1.2
			public SignInPage creatNewAccountWithSameEmail (String emailaddress ) {
			logger.info("Test Case # 1.2 # Started : [Creating Account Using Duplicate Email Address]  ");
			logger.info("Test Case # 1.2 || Step 1 : Locating The Email Address Field ");
			library.dynamicWaitForElementToBeClickable(By.cssSelector("#email_create"));
			logger.info("Test Case # 1.2 || Step 2 : Entering Email Address which already have a Valid account on the website ");
			library.entertext(By.cssSelector("#email_create"), emailaddress);//NJUSA@gmail.com
			library.customWait(3.0);
			library.captureScreenshot();
			logger.info("Test Case # 1.2 || Step 3 : Click the 'Creat An Account Button' ");
			library.clickLinkOrButton(By.cssSelector("#SubmitCreate"));
			library.scrollUpDown(400);
			library.customWait(2.0);
			logger.info("Test Case # 1.2 #   Ended : [Creating Account Using Duplicate Email Address]  ");
	return this;
 }
			
			
			//Test Case 1.3 sign in using right credentials
			public SignInPage SignInUsingRightemail (String emailaddress ) {
			logger.info("Test Case # 1.3 # Started : [doing 'SIGN IN' Using Righ credentials]  ");
			logger.info("Test Case # 1.3 || Step 1 : Locating The Email Address Field & sending correct Email ");
			library.entertext(By.cssSelector("#email"), emailaddress);//NJUSA@gmail.com
			return this;
			 }
			public SignInPage SignInUsingRightPassword (String Password ) {
			logger.info("Test Case # 1.3 || Step 2 : Locating The Password Field & sending correct Password ");
			library.entertext(By.cssSelector("#passwd"), Password);//NJUSA@@@@
			library.customWait(2.0);
			logger.info("Test Case # 1.3 || Step 3 : Clicking 'Submmit'Button ");
			library.clickLinkOrButton(By.cssSelector("#SubmitLogin"));
			library.captureScreenshot();
			library.customWait(4.0);
			logger.info("Test Case # 1.3 #   Ended :   [doing 'SIGN IN' Using Righ credentials]   ");
		return this;
	 }
		
			
			
		//Test Case 1.4 sign in right email & wrong pass
			public SignInPage SignInUsingRightemail2 (String emailaddress2 ) {
	
			logger.info("Test Case # 1.4 # Started :   [doing 'SIGN IN' Using Wrong credentials]   ");
			logger.info("Test Case # 1.4 || Step 1 : Locating The Email Address Field & sending correct Email ");
			library.entertext(By.cssSelector("#email"), emailaddress2);
			return this;
			}
			
			public SignInPage SignInUsingWrongPassword (String wrongpassw ) {
			logger.info("Test Case # 1.4 || Step 2 : Locating The Password Field & sending Wrong Password ");
			library.entertext(By.cssSelector("#passwd"), wrongpassw);
			library.customWait(0.9);
			logger.info("Test Case # 1.4 || Step 3 : Clicking 'Submmit'Button ");
			library.clickLinkOrButton(By.cssSelector("#SubmitLogin"));
			library.captureScreenshot();
			library.customWait(2.0);
			logger.info("Test Case # 1.4 #   Ended :   [doing 'SIGN IN' Using Wrong credentials]   ");
		return this;
	 }
			
			
		//Test Case 1.5 : using Email with no domain 
			public SignInPage SignInUsingRighMailNoDomain (String NoDomain ) {
			logger.info("Test Case # 1.5 # Started :   [doing 'SIGN IN' Using Right Email Without Domain]   ");
			logger.info("Test Case # 1.5 || Step 1 : Locating The Email Address Field & sending correct Email with no domain ");
			library.entertext(By.cssSelector("#email"), NoDomain);
			return this;
			 }
			public SignInPage SignInUsingRighMailpassword (String RightPassw ) {
			logger.info("Test Case # 1.5 || Step 2 : Locating The Password Field & sending Right Password ");
			library.entertext(By.cssSelector("#passwd"), RightPassw );//"NJUSA@@@@"
			library.customWait(2.0);
			logger.info("Test Case # 1.5 || Step 3 : Clicking 'Submmit'Button ");
			library.clickLinkOrButton(By.cssSelector("#SubmitLogin"));
			library.captureScreenshot();
			library.customWait(0.9);
			logger.info("Test Case # 1.5 #   Ended :   [doing 'SIGN IN' Using Right Email Without Domain]   ");
		return this;
	 }

}
