Feature: GPON Contracted Property Type Indicators

  @US48525-TC53733
  Scenario: OV - Verify creating the individual address with multiple values of Century link contracted property attribute
    Given I am in omnivue url
    And I log in as a "Admin" user
    And I clicked on "Create" tab
    And I go to "Inventory" create type and select "Location" type
    And I select "Individual Location" location type
    And I fill the mandatory fields with location data
    
