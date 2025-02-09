package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.PropertyReader;
import utils.commonMethods;

public class CheckOutPage {

	protected WebDriver driver;
	String checkout_url = PropertyReader.propertyReader("checkOut");
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to(checkout_url);
	}
	
	private By Continue = By.xpath("//input[@value='Continue']");
	private By selectCreditCard = By.xpath("//label[contains(text(),'Credit Card')]/preceding-sibling::input");
	private By cardHolder = By.id("CardholderName");
	private By cardNumber = By.id("CardNumber");
	private By cardCode = By.id("CardCode");
	private By confirmButton = By.cssSelector(".confirm-order-next-step-button");
	private By confirmMessage = By.xpath("//div[@class='title']");
	
	private List<WebElement> Continue_buttons(){
		return driver.findElements(Continue);
	}
	
	public void clickContinue(int continueNumber) {
		List<WebElement> buttons =Continue_buttons();
		commonMethods.clickAction(driver, buttons.get(continueNumber));
	}
	
	public void creditCard() 
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.presenceOfElementLocated(selectCreditCard));
		commonMethods.clickAction(driver, driver.findElement(selectCreditCard));
	}
	
	public void enterCardHolderName(String name) 
	{	
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.presenceOfElementLocated(cardHolder));
		commonMethods.enterKeys(driver.findElement(cardHolder), name);
	}
	
	public void enterCardNumber(String number) {
		commonMethods.enterKeys(driver.findElement(cardNumber), number);
	}
	
	public void enterCardCode(String number) {
		commonMethods.enterKeys(driver.findElement(cardCode), number);
	}
	
	public void confirm() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.presenceOfElementLocated(confirmButton));
		commonMethods.clickAction(driver,driver.findElement(confirmButton));
	}
	
	public String confirmMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.presenceOfElementLocated(confirmMessage));
		return commonMethods.getTExt(driver, driver.findElement(confirmMessage));
	}
	
}
