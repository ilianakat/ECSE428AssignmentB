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

		#ALTERNATIVE FLOW
  @tag1
  Scenario Outline: Sending an email with an attachment through Drive
	Given I am logged into a Gmail account as a user
	And I am writing a new message
	And the message is to <emailAddress>
	When I press on the button Attach File
	And I select a file <typeOfFile> from my file explorer
	And the file is <sizeOfFile>
	Then the file will should be included as a Google Drive file

    Examples: 
      | emailAddress  			| typeOfFile | sizeOfFile |
      | john.doe@gmail.com	|     png 	 |		12			|
      | john.doe@gmail.com	|     png    |		35			|
      | john.doe@gmail.com	|     jpg    |		15			|
      | john.doe@gmail.com	|     jpg    |		29			|
      | john.doe@gm					|     png    |		5				|


