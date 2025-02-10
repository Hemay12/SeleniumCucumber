package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.registerPage;
import utils.PropertyReader;

public class RegistrationSteps {

	WebDriver driver = Hooks.driver;
	registerPage registerUser;
	
	@Given("the user is on the registration page")
	public void userOnRegistrationPage() 
	{
		registerUser = new registerPage(driver);
		System.out.println("User is on registration page");
	}
	
	@When("the user enters all required details")
	public void enterAllDetails() 
	{
		System.out.println("Entering all details");
		
		registerUser.clickGenderRadioButton();
		registerUser.enterFirstName("Dummy");
		registerUser.enterLastName("User");
		registerUser.enterEmail("dummy12337user@gmail.com");
		registerUser.enterPassword("Dummy@123");
		registerUser.enterConfirmPassword("Dummy@123");
		
	}
	
	@And("clicks on the register button")
	public void clickOnRegisterButton() 
	{
		System.out.println("Clicking on button");
		registerUser.clickRegisterButton();
		
	}
	
	@Then("the user should be successfully registered with confirmation message")
	public void successUser() 
	{
		Assert.assertEquals("Your registration completed", registerUser.userRegisterConfirmMessage());
		System.out.println("User is registered");
	}
	
	
}
