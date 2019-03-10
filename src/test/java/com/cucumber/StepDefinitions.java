package com.cucumber;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;

import org.junit.Assert;
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

	private final String IMAGEPATH = System.getProperty("user.dir") + "/attachments/";

	private final String EMAIL = "kathuyilimar@gmail.com";
	private final String PASSWORD = "ECSE428!";

	private final String CLASS_EMAIL_PASSWORD = "whsOnd";
	private final String CLASS_NEXT = "qhFLie";
	private final String CLASS_NEW_MESSAGE = "z0";
	private final String CLASS_MESSAGE_TO = "vO";
	private final String CLASS_CC = "aB gQ pE";
	private final String ID_CC = ":l7";
	private final String CLASS_SUBJECT = "aoT";
	private final String CLASS_ATTACHMENT = "a1";
	private final String XPATH_ATTACHMENT = "//input[@type='file']";
	private final String CLASS_DRIVE = "Kj-JD-K7-K0";
	private final String CLASS_SEND_THROUGH_DRIVE = "span";
	

	private final String test = "quantumWizButtonEl.quantumWizButtonPaperbuttonEl"
			+ ".quantumWizButtonPaperbuttonFlat.quantumWizButtonPaperbuttonFlatColored"
			+ ".quantumWizButtonPaperbutton2El2.quantumWizDialogPaperdialogDialogButton"
			+ ".exportDefaultDialogButton.appsShareTeamdriveAclfixerButton.exportFocusable"
			+ ".primaryButton";
	
	

	private final String CLASS_SEND = "gU";
	private final String CONFIRM = "aT";

	@Given("^I am logged into a Gmail account as a user$")
	public void i_am_logged_into_a_Gmail_account_as_a_user() {
		try {
			setupSeleniumWebDrivers();
		} catch (MalformedURLException e) {
			System.out.println("Exception catched");
		}
		goTo(GMAIL_URL);
		
		driver.findElement(By.className(CLASS_EMAIL_PASSWORD)).sendKeys(EMAIL);
		WebElement nextBTN = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.elementToBeClickable(By.className(CLASS_NEXT)));
		nextBTN.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

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
		//assertion called needs to be called before the new 
		Assert.assertEquals(driver.getCurrentUrl().toString(), GMAIL_URL);
		WebElement btn = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.className(CLASS_NEW_MESSAGE)));
		btn.click();
		

	}

	@Given("^the message is to \"([^\"]*)\"$")
	public void the_message_is_to(String emailAddress) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.className(CLASS_MESSAGE_TO)).sendKeys(emailAddress);
	}
	
	@Given("^the message is in CC to \"([^\"]*)\"$")
	public void the_message_is_in_CC_to(String ccEmailAddress) {
		System.out.println("CC");
		WebElement btn = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.id(ID_CC)));
		btn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.className(CLASS_MESSAGE_TO)).sendKeys(ccEmailAddress);
		
	}
	@Given("the subject is \"([^\"]*)\"$")
	public void the_subject_is(String subject) {
		driver.findElement(By.className(CLASS_SUBJECT)).sendKeys(subject);
	}

	/*
	 * Not actually browsing through the file directory. Takes a files from the project itself
	 * sleep to let it complete the task
	 * TODO click on open first, issue with the file browser
	 */
	@When("^I press on the button Attach File$")
	public void i_press_on_the_button_Attach_File() {

		try {
			Thread.sleep(2000);
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
		//		try {
		//			Thread.sleep(3000);
		//		} catch (InterruptedException e) {
		//			e.printStackTrace();
		//		}

		//line after, going directly in the project's folder
		driver.findElement(By.xpath(XPATH_ATTACHMENT)).sendKeys(IMAGEPATH+file);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("file has been uploaded");
	}

	/*
	 * Send the email 
	 */
	@Then("^the email can be sent$")
	public void the_email_can_be_sent() {
		WebElement btn = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.className(CLASS_SEND)));
		btn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement sent = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.className(CONFIRM)));

		boolean ans = sent.getText().contains("Message sent.");
		Assert.assertTrue(ans);
		Assert.assertEquals(driver.getCurrentUrl().toString(), GMAIL_URL);
	}

	/*
	 * does not send the email
	 */
	@Then("the message cannot be sent due to invalid email address")
	public void the_message_cannot_be_sent_due_to_invalid_email_address() {
		try {
			WebElement btn = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(By.className(CLASS_SEND)));

			
			driver.quit();
		}catch (Exception e) {
			Assert.fail("invalid email as recipient");
		}
	}

	/*
	 * Case when it is larger than 25MB
	 */
	@Then("^the file will be included as a Google Drive file$")
	public void the_file_will_be_included_as_a_Google_Drive_file() throws AWTException {
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement btn = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.className(CLASS_SEND)));
		btn.click();

		try {
			Thread.sleep(3000);
			System.out.println("debug: sleep 3000");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
			WebElement sent = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(By.className(CONFIRM)));

			boolean ans = sent.getText().contains("Message sent.");
			Assert.assertTrue(ans);
			Assert.assertEquals(driver.getCurrentUrl().toString(), GMAIL_URL);
	}

	/**
	 * Method to use Selenium and start an instance of ChromeDriver for each test
	 * @throws MalformedURLException
	 */
	private void setupSeleniumWebDrivers() throws MalformedURLException {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
			driver = new ChromeDriver();
		}
	}

	/**
	 * Start at the url for gmail
	 * @param url
	 */
	private void goTo(String url) {
		if (driver != null) {
			System.out.println("Going to " + url);
			driver.get(url);
		}
	}
}
