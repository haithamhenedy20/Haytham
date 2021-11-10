package com.selenium.framework.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.selenium.framework.libraries.seleniumBase;
import com.seleniun.framework.pages.ContactCCare;

public class ContactCCareTesting extends seleniumBase {
	
	final static Logger logger = Logger.getLogger(ContactCCareTesting.class);
	ContactCCare methodCaller = new ContactCCare();
	
	@Test
	public void contactCustomerCareTesting () {
	
	methodCaller.clickContactUsInHomePage().
	chooseSubjectfromDrpList("Customer service").
	enteringEmail("NJUSA@gmail.com").
	enteringReferenceNum  ("246789").
    uploadingFile ("C:/Users/haith/Downloads/IN126670.pdf").//ScreenShot taken here to show download successful
    typingEmailBody().
    clickSendBtn ().
    verifySiteMessageAfterMailSent();           //ScreenShot taken here to get TXT of message notifcation mail sent
	
	
 	}
}
