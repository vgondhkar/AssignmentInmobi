package com.libs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericClass extends BaseClass {
	static String Sdirpath = System.getProperty("user.dir");
	String ConfigProperties = Sdirpath + "\\Config.properties";

	// Selenium Actions to perform on UI

	public static String getproperties(String skey) {

		String svalue = null;
		Properties properties = new Properties();
		try {

			FileInputStream file = new FileInputStream("./Config.properties");
			properties.load(file);
			svalue = properties.getProperty(skey);
		} catch (Exception e) {

		}
		return svalue;
	}

	// handle the select class with index

	public static void selecybyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public static void waitPageToLoad(int sec, WebDriver driver, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, sec);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		String word = element.getText();

		if (element.isDisplayed()) {
			System.out.println(word);
		} else {
			System.out.println("element is not displayed ");
		}
	}
	
	public static void waitforEleToClick(int sec,WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, sec);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
		String word = element.getText();

		if (element.isDisplayed()) {
			System.out.println(word);
		} else {
			System.out.println("element is not displayed ");
		}
	}
	
}