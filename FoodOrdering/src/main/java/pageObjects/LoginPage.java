package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class LoginPage extends base {

	public WebDriver driver;
	By selectCountry = By.name("country_code");
	By mobileNumberIdentifier = By.name("mobile_no");
	By letsGo = By.xpath("//bdo[contains(text(),\"Let's Go\")]");
	By kallang = By.xpath("//span[contains(text(),'kallang')]");
	By dineIn = By.xpath("//dbo[contains(text(),' Dine In ')]");

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}
	
	public void performLogin(String CountryCode, String MobileNumber) throws InterruptedException {

		
		//Wait until the header kallang is visible before proceeding to login
		WebDriverWait wait = new WebDriverWait(driver, 60); // 60 seconds max wait time
		wait.until(ExpectedConditions.visibilityOfElementLocated(kallang));
		
		
		Select se = new Select(driver.findElement(selectCountry));
		se.selectByValue(CountryCode);
		driver.findElement(mobileNumberIdentifier).sendKeys(MobileNumber);
		driver.findElement(letsGo).click();
		driver.findElement(dineIn).click();

	}
	



}
