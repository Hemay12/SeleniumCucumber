package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertyReader;
import utils.commonMethods;

public class registerPage {
	
	protected WebDriver driver;
	String registerUrl = PropertyReader.propertyReader("register");
	
	
	public registerPage(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to(registerUrl);
	}

	private By radioGenderButton = By.id("gender-male");
	private By firstName = By.id("FirstName");
	private By lastName = By.id("LastName");
	private By email = By.id("Email");
	private By password = By.id("Password");
	private By confirmPassword = By.id("ConfirmPassword");
	private By registerButton = By.id("register-button");
	private By successMessage = By.xpath("//div[@class='result']");
	
	
	public void clickGenderRadioButton() {
		commonMethods.clickAction(driver, driver.findElement(radioGenderButton));
	}
	
	public void enterFirstName(String fname) {
		commonMethods.enterKeys(driver.findElement(firstName), fname);
	}
	
	public void enterLastName(String lname) {
		commonMethods.enterKeys(driver.findElement(lastName), lname);
	}
	
	public void enterEmail(String Email) {
		commonMethods.enterKeys(driver.findElement(email), Email);
	}
	
	public void enterPassword(String Password) {
		commonMethods.enterKeys(driver.findElement(password), Password);
	}
	
	public void enterConfirmPassword(String Password) {
		commonMethods.enterKeys(driver.findElement(confirmPassword), Password);
	}
	
	public void clickRegisterButton() {
		commonMethods.clickAction(driver ,driver.findElement(registerButton));
	}
	
	public String userRegisterConfirmMessage() {
		return commonMethods.getTExt(driver, driver.findElement(successMessage));
	}

	
	
}
