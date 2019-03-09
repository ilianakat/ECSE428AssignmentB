Feature: Send an email with an attachment

	Scenario: Sending an email with an attachment
	Given I am logged into a Gmail account
	When I press “New Message”
	And I specify a recipient 
	And I select a file to attach
	And I press “send”
	Then the email should be sent.
	