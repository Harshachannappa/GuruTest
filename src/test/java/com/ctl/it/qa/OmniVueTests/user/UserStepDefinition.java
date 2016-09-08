package com.ctl.it.qa.OmniVueTests.user;


import net.thucydides.core.annotations.Steps;

import com.ctl.it.qa.omnivue.tools.pages.common.OVActivationPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVAssociatedServicesPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVDeviceLookupPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVHomepage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVLoginPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVSearchDevicePage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVServiceDetailsPage;
import com.ctl.it.qa.omnivue.tools.steps.user.UserSteps;
import com.ctl.it.qa.staf.Page;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;

 /*public class UserStepDefinition {
	
	@Steps
	UserSteps endUser;
	OVLoginPage loginPage;

	// ********************** GIVEN METHODS **************************

	@Given("^I am logged in as a \"([^\"]*)\" user in \"([^\"]*)\"$")
	public void i_am_logged_in_as_a_user_in_SFA(String userType,String portal) {
		System.out.println("1");
		String url = Page.envData.getFieldValue(portal.toLowerCase()+"-url");
		Serenity.setSessionVariable("url").to(url);
		Serenity.setSessionVariable("user_type").to(userType);
		Serenity.setSessionVariable("portal_name").to(portal);
		endUser.is_in_sfa_login_page(url);
		if(portal.equalsIgnoreCase("SFA")){
			endUser.logs_in_as(userType);
		}else if(portal.equalsIgnoreCase("Partner")){
			endUser.logs_in_partner_portal_as(userType);
		}
	
	 }  
      
}*/

 public class UserStepDefinition {
	
	@Steps
	UserSteps enduser;
	OVLoginPage loginpage;
	OVHomepage homepage;
	OVActivationPage actvtnpage;
	OVAssociatedServicesPage assocservicespage;
	OVDeviceLookupPage devicelookuppage;
	OVSearchDevicePage searchdevicepage;
	OVServiceDetailsPage servicedetailspage;
	
	
	// ******************** Methods *****************************
	
	@Given("^I am in omnivue url$")
	
	public void I_am_in_omnivue_url() {
		
		String url = Page.envData.getFieldValue("omnivue-url");
		System.out.println("url value is" + url);
		enduser.is_in_omnivue_login_page(url);
		loginpage.shouldExist(loginpage);		
	}
		
	@And("^I log in as a \"([^\"]*)\" user$")
	
	public void I_log_in_as_a_user(String userType) {
		
		enduser.logs_in_as_a(userType);
	}
	
	//Moved to OSIPScreen
	/*
	
	@And("^I goto Activation Page$")
	
	public void I_goto_Activation_Page() throws Exception {
		
		enduser.click_activationtab();
		
	}
	
	*/
	
	/*
	@And("^I goto Services Page$")
	
	public void I_goto_Services_Page() throws Exception {
		
		//Shifted 3 lines from I_goto_Activation_Page() down here
		enduser.click_searchtab();
		enduser.select_fields();
		enduser.click_searchbtn();
		enduser.verify_servicetab();
		enduser.click_servicestab();		
	}
	*/
	
	/*
	 Moved to OVUsability
	 
	@And("^I modify the service name from 77/L1XX/785391//CTQF to 77/L1XX/785391//CTFQ")
	
	public void I_modify_the_service_name() throws Exception {
		
		enduser.update_servicename();
		enduser.backto_servicestab();
		
	}
	
	@When("^I do Refresh$")
	
	public void I_do_Refresh() throws Exception {
		
		enduser.click_onRefresh();
	}
	
	@Then("^I should see the updated Associated service name$")
	
	public void I_should_see_the_updated_Associated_service_name() throws Exception {		
		
		enduser.is_having_updatedassociatedservicename();
		enduser.logoutfrom_application();
		
	}
	*/
	@Then("^Log out from OMNIVue$")
	public void logout() throws Exception{
		enduser.logoutfrom_application();
	}
	
	/*@And("Click on Activation tab")
	
	public void Click_on_Activation_tab() throws Exception {
		enduser.click_activationtab();
	}
	
	@And("Click on search tab")
	
	public void Click_on_search_tab() {
		enduser.click_searchtab();
	}
	
	@And("Enter details into fields") 
	
	public void Enter_details_into_fields() {
		enduser.select_fields();
	}
	
    @And("Click on search button")
    
    public void Click_on_search_button() {
    	enduser.click_searchbtn();
    }*/
    
   /* @And("Validate the services tab")
    
    public void Validate_the_services_tab() {
    	enduser.verify_servicetab();
    }
	
    @And("Click on services tab")
    
    public void Click_on_services_tab() throws Exception {
    	enduser.click_servicestab();
    }*/
    
 /*   @And("Update service name")
    
    public void Update_service_name() throws Exception{
    	enduser.update_servicename();
    }
    
    @And("Navigate back to services tab")
    
    public void Navigate_back_to_services_tab() {
    	enduser.backto_servicestab();
    }
    */
   /* @When("I click on Refresh link")
    
    public void I_click_on_Refresh_link() throws Exception {
    	enduser.click_onRefresh();
    }*/
	
	

//	@Then("I should be on loginpage")
//	
//	public void I_should_be_on_loginpage() {
//		
//		enduser.should_be_on_loginpage();
//	}	
	
	
} 


