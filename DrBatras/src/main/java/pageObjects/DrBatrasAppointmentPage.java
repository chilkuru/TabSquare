package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import resources.base;

public class DrBatrasAppointmentPage extends base {

	public WebDriver driver;

	String iFrameXpath = "//iframe[@id=\"kenytChatWindow\"]";
	By treatments = By.xpath("//a[@id=\"navbarDropdown0\" and text() = \"TREATMENTS\"]");
	By childhealth = By.xpath("//a[@class=\"nav-link\" and text() = \"Child Health\"]");
    By immunity = By.xpath("//div[@class=\"dropdown-menu treat-drop\"]//a[@title=\"Immunity\" and text()=\"Immunity\"]");	
	By chatNow = By.xpath("//div[@class=\"img-container\"]//img");
	By closChatButton = By.xpath("//span[text()=\"close\"]");
	By ConsultNow =  By.xpath("//a[text()=\"CONSULT NOW\"]");
	By Name = By.id("request_name");
	By mobileNo = By.id("request_contact_no");
	By email = By.id("request_email");
	By  checkBoxTandC = By.id("terms_and_conditions_chk");
	By nextButton = By.xpath("//button[@id=\"request_a_call_btn\" and text()=\"NEXT\"]");
	By confirmAppointmentButton  = By.xpath("//button[@id=\"book-an-appointment-sectwo\" and text()=\"CONFIRM YOUR APPOINTMENT\"]");
	
	
	//public By immunity = By.xpath("//div[@id='menutab-5']//a[@title='Immunity']");

	public DrBatrasAppointmentPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}
	
	
	public WebElement getTreatments() {
		return driver.findElement(treatments);
	}


	public WebElement getChildhealth() {
		return driver.findElement(childhealth);
	}


	public WebElement getImmunity() {
		return driver.findElement(immunity);
	}


	public WebElement getChatNow() {
		return driver.findElement(chatNow);
	}


	public WebElement getClosChatButton() {
		return driver.findElement(closChatButton);
	}


	public WebElement getConsultNow() {
		return driver.findElement(ConsultNow);
	}


	public WebElement getName() {
		return driver.findElement(Name);
	}


	public WebElement getMobileNo() {
		return driver.findElement(mobileNo);
	}


	public WebElement getEmail() {
		return driver.findElement(email);
	}


	public WebElement getCheckBoxTandC() {
		return driver.findElement(checkBoxTandC);
	}


	public WebElement getNextButton() {
		return driver.findElement(nextButton);
	}


	public WebElement getConfirmAppointmentButton() {
		return driver.findElement(confirmAppointmentButton);
	}
	
	public String getiFrameXpath() {
		return iFrameXpath;
	}
	
	public By getChatNowBy() {
		return chatNow;
	}
	
	public By getConfirmAppointmentButtonBy() {
		return confirmAppointmentButton;
	}

	



}
