package com.ctl.it.qa.OmniVueTests.user;

import com.ctl.it.qa.omnivue.tools.pages.common.OVAssociatedServicesPage;
import com.ctl.it.qa.omnivue.tools.steps.user.UserSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OVUsabilityStepDefinition {

	@Steps
	UserSteps enduser;
	OVAssociatedServicesPage OVS;
	
	/*@And("^Validate Service capability type fields as \"([^\"]*)\" Service$")
	public void Servicetypevalidation(String service) throws InterruptedException{
		
		enduser.Usability_validation("MEF EVC",service);
	}*/
	
	@And("^validate the service type as \"([^\"]*)\" when service capability type as \"([^\"]*)\"$")
	public void validate_the_service_type_as_when_service_capability_type_as(String serviceType, String serviceCapabilityType) throws Throwable {
	    
		enduser.Usability_validation(serviceType,serviceCapabilityType);
		
	}
	
	@And("^validate the service type as \"([^\"]*)\" when service capability types as \"([^\"]*)\" & \"([^\"]*)\"$")
	public void validate_the_service_type_as_when_service_capability_types_as(String serviceType, String serviceCapabilityType1, String serviceCapabilityType2) throws Throwable {
	     enduser.Usability_validation(serviceType, serviceCapabilityType1, serviceCapabilityType2);
	}

	
	@And("^I modify the service name from 77/L1XX/785391//ABCD to 77/L1XX/785391//CTQF")
	
	public void I_modify_the_service_name() throws Exception {
		
		enduser.update_serviceName();
		enduser.back_to_servicesTab();
		
	}
	
	@When("^I do Refresh$")
	
	public void I_do_Refresh() throws Exception {
		
		enduser.click_onRefresh();
	}
	
	@Then("^I should see the updated Associated service name$")
	
	public void I_should_see_the_updated_Associated_service_name() throws Exception {		
		
		enduser.is_having_updatedassociatedservicename();
		enduser.Revertback_name();
		//enduser.logoutfrom_application();
		
	}
	
	@Then("^Add the CTag range \"([^\"]*)\"$")
	
	public void CTag_range(String ctag_range) throws Exception {
		//enduser.get_data_for_page(page)
		//System.out.println(x);
		Thread.sleep(10000);
		//OVS.btn_ctagadd.click();
		//Thread.sleep(20000);
		//get_container_from_xml("OVActivationPage","US31642-TC20884",ctag_range);
		//enduser.fill_fields_from("OVActivationPage","US31642-TC20884",ctag_range);
		//enduser.get_container_from_xml("OVActivationPage","US31642-TC20884",ctag_range);
		
		enduser.ctag_update(ctag_range);
	}
	
}
