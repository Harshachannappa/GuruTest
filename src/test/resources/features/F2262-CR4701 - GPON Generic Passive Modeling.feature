Feature: F2262-CR4701-US40860-CR4701-Enhance ICL Device_Compatbility table to accept Passive technology

  @US43123-TC24409 
  Scenario: OV- Validating atributes of Create Device Screen on Passive Devices.
    Given I am in omnivue url
    And I log in as a "Admin" user
    #When I goto Activation Page
    And I clicked on "Create" tab
    And I go to "Inventory" create type and select "Device" type
    And I Select "Technology" as Filter By value
    Then I validated "PASSIVE" technology and device type
    Then Select the technology as "PASSIVE" with Device Type as "Fiber Distribution Hub" with Sub-Type as "Generic FDH 144"
    #And Search for the  location "Without" Building CLLI
    And I fill the mandatory fields with "US43123-TC24409" data
    And Log out from OMNIVue
      
  @US43123-TC24975
  Scenario Outline: OV-Validating Search Device Screen based on Passive technology type
    Given I am in omnivue url
    And I log in as a "Admin" user
    #When I goto Activation Page
    And I clicked on "Search" tab
    And I searched for <Container> device
    And I clicked on search button for "Inventory"
    And I clicked on view icon of search result page
    Then Validate attributes in "PASSIVE" device details page
    Then Validate the device name in search page
    Examples: 
    |Container|
    |MST|
    |FDP|
    |Splitter|
    
     @US43123-TC25113 
  Scenario: OV- Validating atributes of Create Device Screen on Passive Devices.
    Given I am in omnivue url
    And I log in as a "Admin" user
    #When I goto Activation Page
    And I clicked on "Create" tab
    And I go to "Inventory" create type and select "Device" type
    And I Select "Technology" as Filter By value
    Then I validated "PASSIVE" technology and device type
    And Select the technology as "PASSIVE" with Device Type as "Fiber Distribution Hub" with Sub-Type as "Generic FDH 144"
    Then I validated "PASSIVE" radio button and "All" radio button
    Then Validate attributes in "PASSIVE" device details page
    
    
 ##################################################################################################################
    
    #US40867-CR4701-Enhance Splitter Naming Convention
    
    #US51414-CR4701 GPON Location CLLI is optional for device technology=GPON or Passive
    
   @US51414-TC37684
  	Scenario: OV-Validate Location CLLI is optional on Inventory Device Create for Passive Technology
    Given I am in omnivue url
    And I log in as a "Admin" user
    #When I goto Activation Page
    And I clicked on "Create" tab
    And I go to "Inventory" create type and select "Device" type
    And I Select "Technology" as Filter By value
    Then I validated "PASSIVE" technology and device type
    Then Select the technology as "PASSIVE" with Device Type as "Fiber Distribution Hub" with Sub-Type as "Generic FDH 144"
    Then Validate "PASSIVE" radio button in device create page 
    #Then Validate Location CLLI is optional or not
    And Validate Location CLLI for "PASSIVE"
    And I fill the mandatory fields with "US51414-TC37684" data
    
   @US51414-TC37479
   Scenario: OV-Validate Location CLLI is optional on Inventory Device Create for GPON Technology
    Given I am in omnivue url
    And I log in as a "Admin" user
    #When I goto Activation Page
    And I clicked on "Create" tab
    And I go to "Inventory" create type and select "Device" type
    And I Select "Technology" as Filter By value
    Then I validated "GPON" technology and device type
    Then Select the technology as "GPON" with Device Type as "ADTRAN Total Access 5000" with Sub-Type as "ADTRAN Total Access 5000 19 Inch Chassis"
    Then Validate "GPON" radio button in device create page 
    #Then Validate Location CLLI is optional or not
    And Validate Location CLLI for "GPON"
    
    @US51414-TC37705
    Scenario: OV-Validate Location CLLI attribute is mandatory on Inventory Device Create for Ethernet Technology
    Given I am in omnivue url
    And I log in as a "Admin" user
    #When I goto Activation Page
    And I clicked on "Create" tab
    And I go to "Inventory" create type and select "Device" type
    And I Select "Technology" as Filter By value
    Then I validated "ETHERNET" technology and device type
    Then Select the technology as "ETHERNET" with Device Type as "Calix C Series" with Sub-Type as "Calix C7"
    Then Validate "GPON" radio button in device create page 
    #Then Validate Location CLLI is optional or not
    And Validate Location CLLI for "ETHERNET"
    