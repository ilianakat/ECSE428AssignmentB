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

  @tag1
  Scenario: Sending an email with an attachment to an invalid recipient
		Given I am writing a new message
		And the message is to an invalid email
		When I press “AttachFile”
		And I select a file from my file explorer
		Then the file is included in the email
		And the message cannot be sent due to invalid email address

