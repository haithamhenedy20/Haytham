package differentTestings;

import java.net.HttpURLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selenium.framework.libraries.seleniumBase;

public class BrokenLinks extends seleniumBase {
	

	//broken links response=404 // non broken links response = 201 or 202
	//Step 1 - IS to get all urls tied up to the links using Selenium
    // Java methods will call URL's and gets  the status code
    //if status code >400 then that url is not working-> link which tied to url is broken

	//	public static void main(String[] args) 
	@Test
	public void check()
		{
			//WebDriver driver=new FirefoxDriver();
			
			//driver.manage().window().maximize();
			
			//driver.get("http://www.google.co.in/");
			
			List<WebElement> links=driver.findElements(By.tagName("a"));
			
			System.out.println("Total links are "+links.size());
			
			for(int i=0;i<links.size();i++)
			{
				
				WebElement ele= links.get(i);
				
				//String url=ele.getAttribute("href");
				
				//verifyLinkActive(url);
				
			}
			
		}
		
		/*public static void verifyLinkActive(String linkUrl)
		{
	        try 
	        {
	        
	        //this is url class from java.net.url & pass ur link URL here - ((create object from URL class))
	           URL url = new URL(linkUrl);
	           
	        //then u have to open a connection using the httpurlconnection class - ((use object 2 open connection))
	           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	           
	        //ten set time out java.net.ur;cpnnectionsetconnectTimeOut, i prefer 2 do that ((set timeout))
	         //casue sometimes it take time to send request & receive response
	           httpURLConnect.setConnectTimeout(3000);
	           
	          //then will try to connect( connect TO the url )
	           httpURLConnect.connect();
	           
	           //then will get response code 200 is okay but 400 is not ok(get response 200/400)
	           if(httpURLConnect.getResponseCode()==200)
	           {
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	            }
	          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
	           {
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	            }
	        } catch (Exception e) {
	           
	        }
	    } */
		
		
		 
	 
	}