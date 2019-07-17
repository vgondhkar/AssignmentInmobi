package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libs.BaseClass;

public class AmazonCartPage {
	public AmazonCartPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	@FindBy(xpath = "//input[@name='name']")
	public WebElement CampName;

	
	
}
