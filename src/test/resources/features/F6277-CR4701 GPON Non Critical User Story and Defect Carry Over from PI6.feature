Feature: F6277-US62403-New OV Order Search is not returning search results for GPON orders

@US62403-TC54941-TC54947-TC54962-TC55177
Scenario Outline: Validate OV order search return results for GPON using CSOF Order Id
Given I am in omnivue url
And I log in as a "Admin" user
And I clicked on "Search" tab
And I searched for <Orders>
And I clicked on search button for "Orders"
And I clicked on view icon of search result page
Then Validate attributes in order details page
And Log out from OMNIVue
			Examples:
    	| Orders 						|
    	| CSOF Order ID 		|
    	#| Ensemble Order ID |
    	#| TN 								|
   	 	#| Customer Name 		|
    	#| GPON Order 				|



@US62403-TC55494
Scenario: Validate OV order search return results for GPON using DTN in Advanced search
Given I am in omnivue url
And I log in as a "Admin" user
And I clicked on "Search" tab
And I searched for "GPON Order"
And I clicked on Advance Search for "Orders"
And I Search order with DTN
And I clicked on search button for "Orders"
And Log out from OMNIVue