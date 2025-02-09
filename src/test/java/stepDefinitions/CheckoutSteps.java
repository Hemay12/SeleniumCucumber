package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckoutSteps {
	
	WebDriver driver = Hooks.driver;
	LoginPage login;
	HomePage home;
	CartPage cart;
	CheckOutPage checkout;
	
	@Given("the user is logged in")
	public void the_user_is_logged_in() 
	{
		login = new LoginPage(driver);
	    login.enterEmail("dummy1233user@gmail.com");
	    login.enterPassword("Dummy@123");
	    login.loginButton();
	    Assert.assertTrue(login.loginStatus("dummy1233user@gmail.com"));
	}

	@When("User searches for product and adds it into the cart")
	public void user_searches_for_product_and_adds_it_into_the_cart() 
	{
		home = new HomePage(driver);
		home.search("Book");
	    home.selectProductAndAddToCart("Health Book");
	}

	@When("User navigates to cart page and proceeds to checkout")
	public void user_navigates_to_cart_page_and_proceeds_to_checkout() 
	{
	   cart = new CartPage(driver);
	   cart.selectCountry("India");
	   cart.enableTerm();
	   cart.checkOut();
	}

	@When("User enters payment details and confirms the order")
	public void user_enters_payment_details_and_confirms_the_order() 
	{
		checkout = new CheckOutPage(driver);
		checkout.clickContinue(0);
		checkout.clickContinue(1);
		checkout.clickContinue(2);
		
		checkout.creditCard();
		checkout.clickContinue(3);
		
		checkout.enterCardHolderName("user");
		checkout.enterCardNumber("4111111111111111");
		checkout.enterCardCode("121");
		checkout.clickContinue(4);
		checkout.confirm();
		
	   System.out.println("Order placed");
	}

	@Then("Order should be placed successfully")
	public void order_should_be_placed_successfully() 
	{
		String msg = checkout.confirmMessage();
		Assert.assertEquals("Your order has been successfully processed!",msg);
	}
}
