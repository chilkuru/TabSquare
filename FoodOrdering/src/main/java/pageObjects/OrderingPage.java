package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class OrderingPage extends base {

	public WebDriver driver;
	By addRicePlate = By.xpath(
			"//span[@class=\"name\" and contains(text(),\"Rice Plate\")]/ancestor::li//a[contains(text(),\"Add\")]");
	By addRicePateDetailPop = By.xpath(
			"//div[@class=\"detail-text\" and contains(text(),\"Rice Plate\")]/ancestor::div[@class=\"slide-pop detail-pop\"]//a[contains(text(),\"Add\")]");
	By addRiceMoreThanOne = By.xpath(
			"//span[@class=\"name\" and contains(text(),\"Rice Plate\")]/ancestor::li//a[@class=\"to-plus btn-primary test\"]");
	By checkout = By.id("checkoutButton");
	By payByCashButton = By.xpath("//a[contains(text(),\"Pay By Cash\")]");
	By OrderIDValue = By.xpath("//td[contains(text(),\"Order ID\")]//span");
	By OrderNo = By.xpath("//span[@id=\"orderNo\"]");
	By OrderSuccessfulMessage = By.id("message");
	By OrderQuanityThreeRicePlate = By.xpath(
			"//span[@class=\"name\" and contains(text(),\"Rice Plate\")]/ancestor::li//div[@class=\"add-val\" and text()=\"3\"]");

	public OrderingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	//Place the order for Rice Plate in quantity 3
	public void placeOrderRicePlateQuantityThree() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);// 30 Seconds
		driver.findElement(addRicePlate).click();
		driver.findElement(addRicePateDetailPop).click();
		// Adding for 3 items of rice plate
		driver.findElement(addRiceMoreThanOne).click();
		driver.findElement(addRiceMoreThanOne).click();
		//Verifying if the order quantity 3 is updated
		wait.until(ExpectedConditions.visibilityOfElementLocated(OrderQuanityThreeRicePlate));
		driver.findElement(checkout).click();
		driver.findElement(payByCashButton).click();

		// Wait for Order successful message
		wait.until(ExpectedConditions.visibilityOfElementLocated(OrderSuccessfulMessage));

	}

	// Initiate WebElements functions
	public WebElement getOrderIDValue() {
		return driver.findElement(OrderIDValue);
	}

	public WebElement getOrderNo() {
		return driver.findElement(OrderNo);
	}

}
