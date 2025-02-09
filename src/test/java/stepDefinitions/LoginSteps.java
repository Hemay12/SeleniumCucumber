package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.commonMethods;

public class LoginSteps {
	
	WebDriver driver = Hooks.driver;
	LoginPage login;
	
	@Given("the user is on login page")
	public void the_user_is_on_login_page() 
	{
	    login = new LoginPage(driver);
	    System.out.println("User is on Login Page");
	}

	@When("the user enters {string} and {string}")
	public void the_user_enters_credentials(String userName, String password) 
	{
	    login.enterEmail(userName);
	    login.enterPassword(password);
		login.loginButton();
	}
	
   
	@Then("the user should be passORfail {string}")
	public void the_user_should_be_pass_o_rfail(String username) 
	{
	    if (login.loginStatus(username)) {
	        System.out.println("Login Success");
	        Assert.assertTrue("Login passed as expected.", true);
	    } else {
	    	commonMethods.captureScreenshot(driver);
	        System.out.println("Login Failed");
	        Assert.fail("Login failed for user: " + username);
	    }
	}

}
