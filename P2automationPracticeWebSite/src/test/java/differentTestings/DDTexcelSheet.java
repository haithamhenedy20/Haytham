package differentTestings;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.framework.libraries.ExcelReader;
import com.selenium.framework.libraries.seleniumBase;
import com.seleniun.framework.pages.ContactCCare;

public class DDTexcelSheet extends seleniumBase {
	
	
	final static Logger logger = Logger.getLogger(DDTexcelSheet.class);
	ContactCCare methodCaller = new ContactCCare();
	
	
	
	
	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}
	
	@Test (dataProvider = "ExcelData")
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
