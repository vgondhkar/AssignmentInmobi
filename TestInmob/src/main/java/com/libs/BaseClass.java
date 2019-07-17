package com.libs;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;



public class BaseClass {
	public static WebDriver driver;

	@BeforeMethod
	public void setup() {

		if (GenericClass.getproperties("BROWSERNAME")
				.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"./BrowserDriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(GenericClass.getproperties("URL"));
		
			driver.manage().window().maximize();
			Reporter.log("Maximized window");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		} else {
System.out.println("No browser matching");
		}
}
	
	public static void screenCapture() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File SrcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("D:\\Report\\screenShot"+System.currentTimeMillis()+".png");
		Files.copy(SrcFile, destFile);
	
		Reporter.log("<br><img src='"+destFile+"' height='400' width='400'/><br>");
	}
	
	

	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}