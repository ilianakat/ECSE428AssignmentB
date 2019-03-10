package com.cucumber;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class StepDefinitions {

	private WebDriver driver;
	
	private final String PATH_TO_CHROME_DRIVER = System.getProperty("user.dir") + "/chromedriver.exe";
	
	private final String GMAIL_URL = "https://mail.google.com/mail/u/0/#inbox";

	private final String IMAGE = System.getProperty("user.dir") + "/attachments/";

	private final String EMAIL = "kathuyilimar@gmail.com";
	private final String PASSWORD = "ECSE428!";

	private final String CLASS_EMAIL_PASSWORD = "whsOnd";
	private final String CLASS_NEXT = "qhFLie";
	private final String CLASS_NEW_MESSAGE = "z0";
	private final String CLASS_MESSAGE_TO = "vO";
	private final String CLASS_SUBJECT = "aoT";
	private final String CLASS_ATTACHMENT = "a1";
	private final String XPATH_ATTACHMENT = "//input[@type='file']";
	private final String CLASS_SEND = "gU";

	@Given("^I am logged into a Gmail account as a user$")
	public void i_am_logged_into_a_Gmail_account_as_a_user() {
		try {
			setupSeleniumWebDrivers();
		} catch (MalformedURLException e) {
			System.out.println("Exception catched");
		}
		goTo(GMAIL_URL);

		//enter email
		driver.findElement(By.className(CLASS_EMAIL_PASSWORD)).sendKeys(EMAIL);
		WebElement nextBTN = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(By.className(CLASS_NEXT)));
		nextBTN.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//enter password
		driver.findElement(By.className(CLASS_EMAIL_PASSWORD)).sendKeys(PASSWORD);
		nextBTN = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(By.className(CLASS_NEXT)));
		nextBTN.click();
	}
	
	@Given("^I am writing a new message$")
	public void i_am_writing_a_new_message() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement btn = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.className(CLASS_NEW_MESSAGE)));
		btn.click();
	}

	/*
	 * VAlid email
	 */
	@Given("^the message is to \"([^\"]*)\"$")
	public void the_message_is_to_john_doe_gmail_com(String emailAddress) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.className(CLASS_MESSAGE_TO)).sendKeys(emailAddress);
		driver.findElement(By.className(CLASS_SUBJECT)).sendKeys("Send with attachment");
	}

	/* TODO maybe not even necessary as it used the same as above...
	 * Invalid email
	 */
	@Given("the message is to john.doe@gm")
	public void the_message_is_to_john_doe_gm() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("^I press on the button Attach File$")
	public void i_press_on_the_button_Attach_File() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//file browser window but cannot close it after...
		
//		WebElement btn = (new WebDriverWait(driver, 10))
//				.until(ExpectedConditions.elementToBeClickable(By.className(CLASS_ATTACHMENT)));
//		btn.click();
	}

	@When("^I select a file \"([^\"]*)\" from my file explorer$")
	public void i_select_a_file_from_my_file_explorer(String file) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//TODO click on open first, issue with the file browser
		//line after, going directly in the project's folder
        driver.findElement(By.xpath(XPATH_ATTACHMENT)).sendKeys(IMAGE+file);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	/**
//	 * valid extension and size attachment
//	 */
//	@When("I select a file smallImage.png from my file explorer")
//	public void i_select_a_file_smallImage_png_from_my_file_explorer() {
//		driver.findElement(By.id("attachment")).sendKeys("C:\\Users\\Marine\\AI\\ECSE428AssignmentB\\attachments\\smallImage.jpg");
//		//driver.findElement(By.className("//input[@type='file']")).sendKeys(IMAGE1);
//	}
//	
//	/**
//	 * invalid extension and size attachment
//	 */
//	@When("I select a file largeImage.png from my file explorer")
//	public void i_select_a_file_largeImage_png_from_my_file_explorer() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new cucumber.api.PendingException();
//	}
	
//	@Then("the file is included in the email")
//	public void the_file_is_included_in_the_email() {
//		//just make sure it has enough time to upload...
//        try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  // Wait for upload
////		WebElement attachment = (new WebDriverWait(driver, 10))
////                .until(ExpectedConditions.presenceOfElementLocated(By.className(ATTACHMENT_TEXT_FIELD_CHECK)));
//	}
	
	/*
	 * Send the email 
	 */
	@Then("^the email can be sent$")
	public void the_email_can_be_sent() {
		WebElement btn = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.className(CLASS_SEND)));
		btn.click();
	}

	/*
	 * Case when it is larger than 25MB
	 */
	@Then("^the file will should be included as a Google Drive file$")
	public void the_file_will_should_be_included_as_a_Google_Drive_file() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}


	//helper methods
	private void setupSeleniumWebDrivers() throws MalformedURLException {
		if (driver == null) {
			System.out.println("Setting up ChromeDriver... ");
			System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
			driver = new ChromeDriver();
			System.out.print("Completed\n");
		}
	}

	private void goTo(String url) {
		if (driver != null) {
			System.out.println("Going to " + url);
			driver.get(url);
		}
	}
}
