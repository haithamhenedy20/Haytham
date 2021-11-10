package differentTestings;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.selenium.framework.libraries.seleniumBase;
import com.seleniun.framework.pages.ContactCCare;

public class DDTdataProviderAnnotation extends seleniumBase {
	final static Logger logger = Logger.getLogger(DDTdataProviderAnnotation.class);
	ContactCCare methodCaller = new ContactCCare();
	
	
	@org.testng.annotations.DataProvider (name = "testData")
	public static Object [][] userData() {
		
		
		return new Object [][] {
			{"Customer service","NJUSA@gmail.com", "246789"},
		    { "Customer service","IT@gmail.com", "HHX6789"} , 
			{ "Customer service","xxx@gmail.com", "xxxHHX6789"}  
			
		};           
	}
	
	@Test (dataProvider = "testData")
	public void contactCustomerCareTesting (String organization, String emailAddress, String RefNumber) {
	
	methodCaller.clickContactUsInHomePage().
	chooseSubjectfromDrpList(organization).
	enteringEmail(emailAddress).
	enteringReferenceNum  (RefNumber).
    uploadingFile ("C:/Users/haith/Downloads/IN126670.pdf").//ScreenShot taken here to show download successful
    typingEmailBody().
    clickSendBtn ().
    verifySiteMessageAfterMailSent();           //ScreenShot taken here to get TXT of message notifcation mail sent
	
	
 	}

}
