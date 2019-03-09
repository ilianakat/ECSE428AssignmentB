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
	private WebDriverWait wait;

	private final String GMAIL_URL = "https://mail.google.com/mail/u/0/#inbox";
	private final String NEW_MESSAGE_URL = "";
	//https://mail.google.com/mail/u/0/#inbox?compose=new

	private final String NEW_MESSAGE_BTN = "new-message-button";
	private final String ADD_FILE_BTN = "add-file-button";
	private final String SEND_BTN = "send-button";

	private final String PATH_TO_CHROME_DRIVER = System.getProperty("user.dir") + "/chromedriver.exe";

	private final String EMAIL = "kathuyilimar@gmail.com";
	private final String PASSWORD = "ECSE428!";

	private final String CLASS_EMAIL_PASSWORD = "whsOnd";
	private final String CLASS_NEXT = "qhFLie";


	@Given("I am logged into a Gmail account as a user")
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
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//enter password
		driver.findElement(By.className(CLASS_EMAIL_PASSWORD)).sendKeys(PASSWORD);
		nextBTN = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(By.className(CLASS_NEXT)));

		nextBTN.click();

	}

	/*
	 * VAlid email
	 */
	@Given("the message is to john.doe@gmail.com")
	public void the_message_is_to_john_doe_gmail_com() {
		driver = new ChromeDriver();
		wait = (new WebDriverWait(driver, 5));
		goTo(GMAIL_URL);
		WebElement btn = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.id(NEW_MESSAGE_BTN)));
		btn.click();
		goTo(NEW_MESSAGE_URL);
	}

	/*
	 * Invalid email
	 */
	@Given("the message is to john.doe@gm")
	public void the_message_is_to_john_doe_gm() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("I press on the button Attach File")
	public void i_press_on_the_button_Attach_File() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	/**
	 * valid extension and size attachment
	 */
	@When("I select a file smallImage.png from my file explorer")
	public void i_select_a_file_smallImage_png_from_my_file_explorer() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	/**
	 * invalid extension and size attachment
	 */
	@When("I select a file largeImage.png from my file explorer")
	public void i_select_a_file_largeImage_png_from_my_file_explorer() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	/*
	 * Case when it is larger than 25MB
	 */
	@Then("the file will should be included as a Google Drive file")
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
