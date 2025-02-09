package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonMethods {
	
	public static WebElement waitElement(WebDriver driver, WebElement element) 
	{
		try 
		{
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        return wait.until(ExpectedConditions.visibilityOf(element)); 
	    } 
		catch (Exception e) {
	        e.printStackTrace();
	        return null; // add screenshot
	    }
	}
	
	public static void clickAction(WebDriver driver, WebElement element) 
	{		
		waitElement(driver,element);
		element.click();
	}
	
	public static void enterKeys(WebElement element, String value) 
	{
		element.sendKeys(value);
	}
	
	public static String getTExt(WebDriver driver,WebElement element)
	{
		waitElement(driver, element);
		return element.getText();
	}
	
	public static void captureScreenshot(WebDriver driver) 
	{
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    File ss = new File("/BDD_start/src/test/resources/Screenshot/"  + "fail.png");

	    try {
	        FileUtils.copyFile(src, ss);
	        System.out.println("Screenshot captured: " + ss.getAbsolutePath());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	}
}
