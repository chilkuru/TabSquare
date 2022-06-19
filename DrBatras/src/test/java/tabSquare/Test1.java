package tabSquare;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DrBatrasAppointmentPage;
import resources.base;
/*
Scenario to cover:
- Launch the link
- Hover on treatments
- Click Child health
- Click Immunity
- Click Chat bot on the right hand side bottom corner
- Close the chat bot
- Click Consult now
- Enter Name, Mobile number, email and check TnCs and click Next
- validate that teh next page has Confirm Your Appointment button
*/

public class Test1 extends base {
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(getURL());

	}

	@Test

	public void validateConfirmAppointmentButtonisVisible() throws IOException, InterruptedException {

		DrBatrasAppointmentPage lp = new DrBatrasAppointmentPage(driver);

		log.info("Moving to Immunity Page");
		// Creating object of an Actions class
		Actions action = new Actions(driver);
		action.moveToElement(lp.getTreatments()).perform();

		// Open the Child Health Immunity Page
		lp.getChildhealth().click();
		action.moveToElement(lp.getImmunity()).click().perform();
		//lp.c().click();

		log.info("Opening and closing the chatbot");
		// Wait until the chat bot is is visible before proceeding to opening and
		// closing it
		WebDriverWait wait = new WebDriverWait(driver, 60); // 60 seconds max wait time
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.getChatNowBy()));
		action.moveToElement(lp.getChatNow()).click().perform();

		// Switching to the iFrame of chatbot
		driver.switchTo().frame(driver.findElement(By.xpath(lp.getiFrameXpath())));
		action.moveToElement(lp.getClosChatButton()).click().perform();

		// Getting out of frame to the main page
		driver.switchTo().defaultContent();

		// Book a consultation appointment
		lp.getConsultNow().click();
		lp.getName().sendKeys(prop.getProperty("name"));
		lp.getMobileNo().sendKeys(prop.getProperty("mobileNumber"));
		lp.getEmail().sendKeys(prop.getProperty("email"));
		lp.getCheckBoxTandC().click();

		// Click at the center of Next button
		int width = lp.getNextButton().getSize().getWidth();
		action.moveToElement(lp.getNextButton()).moveByOffset((width / 2) - 2, 0).click().perform();
		lp.getNextButton().click();

		log.info("Checking the Confirmation Appointment button");
		// Verify Consult Appointment button is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(lp.getConfirmAppointmentButtonBy()));
		Assert.assertTrue(lp.getConfirmAppointmentButton().isDisplayed());

	}

	@AfterTest
	public void teardown() {

		driver.quit();

	}
}
