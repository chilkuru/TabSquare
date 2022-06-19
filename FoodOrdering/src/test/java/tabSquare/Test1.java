package tabSquare;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.OrderingPage;
import resources.base;
/*
Scenario to cover:
Open Restaurant url - https://smartweb-ecms.tabsquare.com/scan/ac74085b-8afd-4475-91f1-f4e8ba642dce
Select any country
Enter any valid mobile number and login
Select any food item
Make the quantity as 3
Click Add to Cart > Verify it is added to cart
Click Proceed to Check out
Select payment method as Cash > Verify the order id is generated and order is successfully placed
*/

public class Test1 extends base {
	public WebDriver driver;

	@BeforeTest	
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(getURL());

	}

	@Test

	public void validateOrderIsCreatedSuccesfullyForThreeItems() throws IOException, InterruptedException {

		// Initiating the Page Factory pages
		LoginPage lp = new LoginPage(driver);
		OrderingPage orderItems = new OrderingPage(driver);
		log.info("Intiating Login");
		lp.performLogin(prop.getProperty("countryCode"), prop.getProperty("mobileNumber"));
		log.info("Placing an Order for 3 Rice Plates");
		orderItems.placeOrderRicePlateQuantityThree();

		// Get the order ID and Order Number and assert the placement of order
		log.info("Verifying the order is placed successfully");
		Assert.assertEquals(orderItems.getOrderNo().getText(), "T-" + orderItems.getOrderIDValue().getText());

	}
	
	@AfterTest
	public void teardown() {

		driver.quit();

	}
}
