package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertyReader;
import utils.commonMethods;

public class LoginPage {
	
	protected WebDriver driver;
	String login_url = PropertyReader.propertyReader("login");

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		driver.navigate().to(login_url);
	}
	
	private By email = By.id("Email");
	private By password = By.id("Password");
	private By login = By.cssSelector(".login-button");
	private By logoutHyperLink = By.linkText("Log out");
	
	public void enterEmail(String Email) {
		commonMethods.enterKeys(driver.findElement(email), Email);
	}
	
	public void enterPassword( String Password) {
		commonMethods.enterKeys(driver.findElement(password), Password);
	}
	
	public void loginButton() {
		commonMethods.clickAction(driver, driver.findElement(login));
	}
	
	public boolean loginStatus(String email) 
	{
		return !driver.findElements(logoutHyperLink).isEmpty();
	}

}
