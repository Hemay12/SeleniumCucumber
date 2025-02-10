package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.PropertyReader;
import utils.commonMethods;

public class CartPage {

	protected WebDriver driver;
	String cart_url = PropertyReader.propertyReader("cart");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to(cart_url);
	}
	
	private By countryDropDown = By.id("CountryId");
	private By termsRadioCheckBox = By.id("termsofservice");
	private By checkOutButton = By.id("checkout");
	
	public void selectCountry(String Country) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(countryDropDown));
		Select country = new Select(driver.findElement(countryDropDown));
		country.selectByContainsVisibleText(Country);
	}
	
	public void enableTerm() {
		commonMethods.clickAction(driver, driver.findElement(termsRadioCheckBox));
	}
	
	public void checkOut() {
		commonMethods.clickAction(driver, driver.findElement(checkOutButton));
	}
	
}
