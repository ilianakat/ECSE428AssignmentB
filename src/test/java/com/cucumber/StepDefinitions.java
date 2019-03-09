package com.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class StepDefinitions {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private String GMAIL_URL = "https://mail.google.com/mail/u/0/#inbox";
	private String NEW_MESSAGE_URL = "https://mail.google.com/mail/u/0/#inbox?compose=new";


	@Given("I am logged into a Gmail account as a user")
	public void i_am_logged_into_a_Gmail_account_as_a_user() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	/*
	 * VAlid email
	 */
	@Given("the message is to john.doe@gmail.com")
	public void the_message_is_to_john_doe_gmail_com() {
		
		
		driver = new ChromeDriver();
		wait = (new WebDriverWait(driver, 5));
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
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

	/*
	 * type of file is png
	 */
	@When("I select a file png from my file explorer")
	public void i_select_a_file_png_from_my_file_explorer() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	/*
	 * type of file is jpg
	 */
	@When("I select a file jpg  from my file explorer")
	public void i_select_a_file_jpg_from_my_file_explorer() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	/*
	 * size of the file. Is it more than 25 MB and it needs to be send through drive.
	 */
	@When("the file is {int}")
	public void the_file_is(Integer int1) {
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
}
