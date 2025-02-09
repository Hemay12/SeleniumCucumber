package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertyReader;
import utils.commonMethods;

public class HomePage {

	protected WebDriver driver;
	String home_url = PropertyReader.propertyReader("home");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to(home_url);
	}
	
	private By searchBox = By.id("small-searchterms");
	private By items = By.className("item-box");
	
	private List<WebElement> getProductList() 
	{
        return driver.findElements(items);
    }
	
	public void selectProductAndAddToCart(String productTitle) 
	{
        for (WebElement product : getProductList()) {
            WebElement title = product.findElement(By.cssSelector("h2.product-title a"));

            if (title.getText().equalsIgnoreCase(productTitle)) {
            	 WebElement addToCartBtn = product.findElement(By.cssSelector("input[value='Add to cart']"));
                 addToCartBtn.click();
                 break; 
            }
        }
    }
	
	public void search(String Search) 
	{
		commonMethods.enterKeys(driver.findElement(searchBox), Search);
		driver.findElement(searchBox).sendKeys(Keys.ENTER);
	}
	

}
