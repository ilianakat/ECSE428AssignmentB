Feature: Send an email with an attachment

	Scenario: Sending an email with an attachment
	Given I am writing a new message
	When I press “Attach File”
	And I select a file from my file explorer
	Then the file is included in the email
	And the email can be sent