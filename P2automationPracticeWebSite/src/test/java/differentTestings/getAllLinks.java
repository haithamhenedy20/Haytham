package differentTestings;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.selenium.framework.libraries.seleniumBase;
import com.selenium.framework.libraries.seleniumLibrary;

public class getAllLinks extends seleniumBase {
	
	/*
	 * Homework ----> Create 4 methods which do below requirements:
	 * 
	 * 1) find total number of empty links, print it 2) find total number of links
	 * with text, print it 3) print only the links with text 4) print all available
	 * link total number
	 * 
	 */

	// empty link definition is: link with no spaces and empty
	
	seleniumLibrary selLib = new seleniumLibrary();

	@Test(enabled = false)
	public void findTotalNumberEmptyLinkPrint() {
		selLib.customWait(5);
		//driver.get("https://www.amazon.com/");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int counter = 1;

		List<String> emptyLinks = new ArrayList<String>();

		for (WebElement link : allLinks) {
			String linkTxt = link.getText();
			if (linkTxt.isEmpty()) {
				emptyLinks.add(linkTxt);
				System.out.println(counter + ") link text: [" + linkTxt + "]");
			}
			counter++;
		}

		int totalNumEmptyLinks = emptyLinks.size();
		System.out.println("total empty links: " + totalNumEmptyLinks);

	}

	@Test(enabled = false)
	public void findTotalNumberNotEmptyLinkPrint() {
		selLib.customWait(5);
		//driver.get("https://www.amazon.com/");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int counter = 1;

		List<String> notEmptyLinks = new ArrayList<String>();

		for (WebElement link : allLinks) {
			String linkTxt = link.getText();
			if (!linkTxt.isEmpty()) {
				notEmptyLinks.add(linkTxt);
				System.out.println(counter + ") link text: [" + linkTxt + "]");
			}
			counter++;
		}

		int totalNumEmptyLinks = notEmptyLinks.size();
		System.out.println("total not empty links: " + totalNumEmptyLinks);
	

	}
	
	
	
	@Test
	public void findTotalNumberAllLinkPrint() {
		selLib.customWait(5);
		driver.get("https://www.amazon.com/");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int counter = 1;

		for (WebElement link : allLinks) {
			String linkTxt = link.getText();
			System.out.println(counter + ") link text: [" + linkTxt + "]");

			counter++;
		}

		int totalLinkNum = allLinks.size();

		System.out.println("Total all links: " + totalLinkNum);

	}


}
