Feature: US39146-Create ONT

  @US40972-TC23914
  Scenario: OV- Validate changed mandatory attributes of ONT device from Inventory
    Given I am in omnivue url
    And I log in as a "Admin" user
    #When I goto Activation Page
    And I clicked on "Create" tab
    And I go to "Inventory" create type and select "Device" type
    And I Select "Role" as Filter By value
    And Select the Role as "ONT" with Device Type as "Calix 700GE ONTs" with Sub-Type as "Calix 720GE"
    Then Validate attributes in "ONT" device details page
    And I fill the mandatory fields with "US40972-TC23914" data
    And Log out from OMNIVue

  @US40972-TC23918
  Scenario: OV- Validate changed mandatory attributes of ONT device from Network Build
    Given I am in omnivue url
    And I log in as a "Admin" user
    #When I goto Activation Page
    And I clicked on "Create" tab
    And I go to "Network Build" create type and select "GPON Device Build" type
    And I Entered Serving Wire Center CLLI as By value "LVRNALXB" and Engineering Order Id as By value "34567"
    And I fill the mandatory fields with US40972-TC239148 data from NetworkBuild

  @US47958-TC32254
  Scenario: Verify Edit functionality and hyperlink of IPTV UNICAST Service in IPTV MULTICAST Service form
    Given I am in omnivue url
    And I log in as a "Admin" user
    #And I goto Activation Page
    And I clicked on "Search" tab
    And I searched for "IPTV Data"
    And I clicked on search button for "Inventory"
    And I clicked on view icon of search result page
    And Validate IPTV UNICAST Service Attribute in IPTV service details page
    And Log out from OMNIVue
