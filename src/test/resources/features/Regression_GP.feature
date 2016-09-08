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

Feature: Title of your feature
	I want to use this template for my feature file

@TC39259
Scenario: Verify whether it is displaying the details from Manager Hierarchy to VP Level
 Given I am in omnivue url
 And I log in as a "Admin" user
 When I click on the gear icon and mouseover to Adminstration and "users"
 And I searched the "TC39259" Data
 And I clicked on the view icon from the user search results
 And I clicked on the manager Hierarchy
 Then I Verify the Tree Struture
 
@TC39266
Scenario: Verify Create Role functionality
 Given I am in omnivue url
 And I log in as a "Admin" user
 When I click on the gear icon and mouseover to Adminstration and "workgroups"
 And I selected the workgroup "TC39266workgroup" and clicked on Edit button
 And I clicked on Add Role button
 When I enter the role name "TC39266role" and click on create role button
 Then the role should be created and displayed under workgroup roles
 When I select the role and click on Delete role button 
 Then Role should be deleted successfully
 
 @TC39267
Scenario: Verify Create Role functionality
 Given I am in omnivue url
 And I log in as a "Admin" user
 When I click on the gear icon and mouseover to Adminstration and "workgroups"
 And I selected the workgroup "TC39267workgroup" and clicked on Edit button
 When I select the "TC39267role" from workgroup roles and click on Delete role button 
 Then Role should not be deleted and User should get an error message
 
#	And yet another action
#Then I validate the outcomes
#	And check more outcomes

#@tag2
#Scenario Outline: Title of your scenario outline
#Given I want to write a step with <name>
#When I check for the <value> in step
#Then I verify the <status> in step

#Examples:
#    | name  |value | status |
#    | name1 |  5   | success|
#    | name2 |  7   | Fail   |




