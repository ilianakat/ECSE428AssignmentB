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
	Scenario Outline: Sending an email with an attachment
	Given I am logged into a Gmail account as a user
	And I am writing a new message
	And the message is to "<emailAddress>"
	When I press on the button Attach File
	And I select a file "<file>" from my file explorer
	Then the email can be sent

    Examples: 
      | 	emailAddress 			| 		file			|
#      | john.doe@gmail.com	|smallImage.jpg	|
#      |john.doe2@gmail.com	|IMG_3093.JPG		|
      
	#ERROR FLOW
  Scenario Outline: Sending an email with an attachment to an invalid recipient
	Given I am logged into a Gmail account as a user
	And I am writing a new message
	And the message is to "<emailAddress>"
	When I press on the button Attach File
	And I select a file "<file>" from my file explorer
	Then the message cannot be sent due to invalid email address
	
	    Examples: 
      | 	emailAddress 			| 		file			|
#      | john.doe@gma				|smallImage.jpg	|
#      |john.doe2@gmai				|IMG_3093.JPG		|
      
		#ALTERNATIVE FLOW
  Scenario Outline: Sending an email with an attachment through Drive
	Given I am logged into a Gmail account as a user
	And I am writing a new message
	And the message is to "<emailAddress>"
	When I press on the button Attach File
	And I select a file "<file>" from my file explorer
	Then the file will be included as a Google Drive file

    Examples: 
      | emailAddress  			| file 					|
      | john.doe@gmail.com	|largeImage1.NEF|
#      | john.doe2@gmail.com	|largeImage2.NEF|


