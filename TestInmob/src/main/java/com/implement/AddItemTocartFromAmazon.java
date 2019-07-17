package com.implement;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.libs.BaseClass;
import com.pages.AmazonSearchPage;

public class AddItemTocartFromAmazon extends BaseClass{
	
	
	public static  void AddLancerShoeToCart(String Lancer) throws IOException {
		AmazonSearchPage a = new AmazonSearchPage(driver);
		screenCapture();
		a.Searchitem(Lancer);
		String expected = "Lancer Men's Formal Shoes";
		String actual = driver.getTitle();
		if (actual.contains(expected)) {
		screenCapture();
		}
		a.clickOnItem();
		Set<String> allwindowHandles = driver.getWindowHandles();
		for (String windowHandle : allwindowHandles) {
			driver.switchTo().window(windowHandle);
			}
			a.selectSize(1);
			a.waitForQuantity(100);
			a.clickAddToCart();
			screenCapture();

			
		
		
		
		
		
	}

}
