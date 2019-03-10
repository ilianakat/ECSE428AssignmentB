#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Send an email with an attachment

		#NORMAL FLOW
	@tag1
	Scenario Outline: Sending an email with an attachment
	Given I am logged into a Gmail account as a user
	And I am writing a new message
	And the message is to "<emailAddress>"
	When I press on the button Attach File
	And I select a file "<file>" from my file explorer
	Then the email can be sent

    Examples: 
      | 	emailAddress 			| 		file			|
      | john.doe@gmail.com	|smallImage.jpg	|
#      | john.doe2@gmail.com	|smallImage.jpg	|
#      | john.doe@gm					|largeImage.jpg	|
#      | john.doe@gmail.com	|largeImage.jpg	|
#      | john.doe@gm					|other.peg			|
