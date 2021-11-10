package com.selenium.framework.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.selenium.framework.libraries.seleniumBase;
import com.selenium.framework.libraries.seleniumLibrary;
import com.seleniun.framework.pages.CreateNewAccount;

public class CreatNewAccTesting extends seleniumBase {

	final static Logger logger = Logger.getLogger(CreatNewAccTesting.class);
	CreateNewAccount methodCaller=new CreateNewAccount();
	seleniumLibrary library=new seleniumLibrary();
	String UniqueTime= library.getCurrentTime();
	String UniqueMail = "NJUSA"+UniqueTime+"@gmail.com";
	

	@Test()
	public void test () {
    methodCaller.ClickSignIn().enteringUniqueEmailAddressWithTimeStamp(UniqueMail).
    ClickSubmitButton().specifygender().enteringFirstname("EME").
    enteringLasttname("lOUI").enteringPassword(UniqueMail).
    dropDownStaticenteringBirthDay(4).
    dropDownStaticenteringBirthMonth(3).
    dropDownStaticenteringBirthYear(4).
    enteringFirstNameForAddressDetails("EME").
    enteringLastNameForAddressDetails("LOUI").
    enteringCompanyNameForAddressDetails("LOUI-Company").
    enteringFullAddressDetails("4089, Shadow Oaks , Monmouth JCT").
    enteringCityName("Monmouth-Jct").
    enteringZipCode("08856").
    dropDownStaticListState("Arizona").
    dropDownStaticListCountry("United States").
    phoneContact("8486789465"). 
    AliasAddressAndClickSubmit("Georgia");
    
		
	}
	
	
	
}
