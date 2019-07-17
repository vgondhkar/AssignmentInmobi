package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.libs.BaseClass;
import com.libs.GenericClass;

public class AmazonSearchPage extends GenericClass{
	WebDriver driver;
	public AmazonSearchPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="twotabsearchtextbox")
	public WebElement searchTextBox;

	@FindBy(xpath="(//input[@class='nav-input'])[1]")
		public WebElement searchBtn;
	
	@FindBy(xpath="(//img[contains(@alt,'Lancer')])[1]")
	public WebElement ItemLink;
	
	@FindBy(id="native_dropdown_selected_size_name")
	public WebElement sizeDropDown;

	
	@FindBy(id ="add-to-cart-button")
	public WebElement addTocart;
	
 @FindBy(xpath="//label[text()='Quantity:']")
public WebElement quantity;	
	

	
	public void Searchitem(String brandName) {
	searchTextBox.sendKeys(brandName);
	searchBtn.click();
	
}
public void clickOnItem() {
	ItemLink.click();
}
public void selectSize(int index) {
	WebElement list = sizeDropDown;
	GenericClass.selecybyindex(list, index);
}

public void clickAddToCart() {
	GenericClass.waitforEleToClick(100, addTocart);
	addTocart.click();
}

public void  waitForQuantity(int sec) {
	GenericClass.waitforEleToClick(sec, quantity);
}


}
