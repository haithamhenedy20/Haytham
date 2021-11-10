package com.selenium.framework.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.selenium.framework.libraries.seleniumBase;
import com.seleniun.framework.pages.SignInPage;

public class SignInPageTesting extends seleniumBase {
	
	final static Logger logger = Logger.getLogger(SignInPage.class);
	SignInPage methodCaller = new SignInPage();
	int Counter = 1;
	
	@Test (priority=1 ) //Test Case 1.2 : creatNewAccountWithSameEmail
			
		public void testCreatingAccountUsingSameEmail () {
	    logger.info("Test Number : "+ Counter );
		methodCaller.ClickSignInAtHomePage().
		creatNewAccountWithSameEmail("NJUSA@gmail.com"); //screenshot show action not done
		Counter ++;
	}

	@Test (priority=3 )//Test Case 1.3 : sign in using right credentials
	public void testSignInRightCredentials () {
	    logger.info("Test Number : "+ Counter );
		methodCaller.ClickSignInAtHomePage().
		SignInUsingRightemail("NJUSA@gmail.com").
		SignInUsingRightPassword("NJUSA@@@@");//screenshot success
		Counter ++;
	}
	
	
	@Test (priority=6 )//Test Case 1.4 : sign in using rght email & wrong password
	public void testSignInWrongCredentials () {
		logger.info("Test Number : "+ Counter );
		methodCaller.ClickSignInAtHomePage().
		SignInUsingRightemail2("NJUSA@gmail.com").
		SignInUsingWrongPassword("NJUSA34678");//screenshot show action not done
		Counter ++;
	}
	
	@Test (priority=10 )//Test Case 1.5 : using Email with no domain 
	public void testSignInWrongCredentialsWithNoDomain () {
		logger.info("Test Number : "+ Counter );
		methodCaller.ClickSignInAtHomePage().
		SignInUsingRighMailNoDomain("NJUSA").
		SignInUsingRighMailpassword("NJUSA@@@@");//screenshot show action not done
		Counter ++;
	}
	
	
}

