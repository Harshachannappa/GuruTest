package com.ctl.it.qa.OmniVueTests.user;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ctl.it.qa.omnivue.tools.pages.common.OVServiceDetailsPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OV_GearIcon;
import com.ctl.it.qa.omnivue.tools.steps.user.UserSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;

public class OSIPScreenStepDefinition {
	
	@Steps
	UserSteps enduser;
	OVServiceDetailsPage servicedetails;
	OV_GearIcon ov_gear;
	
	@And("^I goto Activation Page$")
	
	public void I_goto_Activation_Page() throws Exception {
		
		enduser.click_activationTab();
		
	}
	@And("^I clicked on \"([^\"]*)\" tab$")
	public void clickonTab(String Acttab) throws Exception {
		enduser.click_Tab(Acttab);
		System.out.println(Acttab);
	    
	}


	@And("^I searched for ([^\"]*)$")
	public void i_searched_for_device(String field) throws Exception {
		System.out.println(field);
		enduser.fill_fields(field);
		//enduser.click_searchBtn();	    
	}
	
	@And("^I searched for \"([^\"]*)\"$") //Remove later
	public void i_searched_for_Advancedorder(String field) throws Exception {
		System.out.println(field);
		enduser.fill_fields(field);
		//enduser.click_searchBtn();	    
	}
	
	@And("^I clicked on search button for \"([^\"]*)\"$")
	public void i_clicked_on_search_button(String search_button) throws Exception 
	{
		enduser.click_searchBtn(search_button);
	}


	/* Not necessary-5/27/2016
	@And("^I clicked on search button$")
	public void i_clicked_on_search_button() throws Exception 
	{
		enduser.click_searchBtn();
	}
	*/
	@And("^I clicked on view icon of search result page$")
	public void i_clicked_on_view_icon_of_search_result_page() throws Exception {
		enduser.select_viewBtn();
		Thread.sleep(10000);
	     
	}
	@And("^I verified view page and clicked on \"([^\"]*)\" tab$")
	public void i_verified_view_page_of_device_and_clicked_on_services_tab(String tab) throws Exception {
		//enduser.verify_deviceSearchPage();
		System.out.println("entered the first stage"+tab);
		enduser.click_servicesTab(tab);
		
	}

	@And("^I searched for ([^\"]*) device$")
	public void i_searched_for_a_device(String container3) throws Throwable {
		enduser.fill_fields_from("OVActivationPage","US43123-TC24975",container3);
		enduser.get_container_from_xml("OVActivationPage","US43123-TC24975",container3);
		System.out.println(enduser.get_container_from_xml("OVActivationPage","US43123-TC24975",container3));
		//enduser.click_searchBtn();
	     
	}

	/*@And("^I need to search for \"([^\"]*)\"$")
	
	public void I_goto_Services_Page(String field) throws Exception {
		
		//Shifted 3 lines from I_goto_Activation_Page() down here
		//enduser.click_searchtab();
		System.out.println(field);
		enduser.fill_fields(field);
		
		enduser.click_searchbtn();
		enduser.select_viewbtn();
		enduser.verify_servicetab();
		enduser.click_servicestab();
		
	}
	*/
	@Then("^Validate the fields present in the result page$")
	public void attribute_validation(){
		enduser.attri_field();
	}
	
	@And("^I clicked on Advance Search for \"([^\"]*)\"$")//Need to remove this-Duplicate search
	public void i_clicked_on_Adcance_Search_for(String advanced_Search) throws Throwable {
	    enduser.click_searchBtn(advanced_Search);
	}

	@And("^I Search order with DTN$")
	public void i_search_order_with_DTN() throws Exception{
		enduser.advancesearch();
	}
	
	@And("^Validate IPTV UNICAST Service Attribute in IPTV service details page$")
	public void Validate_IPTVUNICAST_Service_Attribute_in_IPTV_service_details_page()throws Throwable{
		String label,link;
		if(servicedetails.lbl_IPTV_unicast.isDisplayed()){
			label=servicedetails.lbl_IPTV_unicast.getText();
			System.out.println(label+" Attribute is present");
	    }else{
			System.out.println("Attribute is not present");
	    }
		link = servicedetails.link_IPTV_unicast.getText();
		servicedetails.link_IPTV_unicast.click();
		Thread.sleep(5000);
		if(link.equals(servicedetails.Name_IPTV_unicast.getText()))
		System.out.println("Succcessfully validated");
		else
		System.out.println("validation failed");
	}
	
	@And("^I click on the gear icon and mouseover to Adminstration and \"([^\"]*)\"$")
	public void mouseover_to_Adminstration(String manage) throws Throwable{
		servicedetails.img_settings.click();
		
	switch(manage){
	
	case "users"		: ov_gear.move_to_admin();
	                   	break;
	case "workgroups" 	: ov_gear.move_to_admin_wokgroups();
	                 	break;
		
	}
	}
		
	
	@And("^I searched the \"([^\"]*)\" Data$")
	public void Searched_the_user_with_CUID(String field) throws Throwable{
		enduser.fill_fields(field);
		
		//ov_gear.ddl_FilterBy.selectByVisibleText("OV_USER_ID");
		//ov_gear.tbx_Filtertext.sendKeys("aa98197");
		ov_gear.btn_SearchUser.click();
	}
		
	@And("^I clicked on the view icon from the user search results$")
	public void View_User_Details() throws Throwable{
		ov_gear.btn_ViewUser.click();
		Thread.sleep(4000);
	}
	@And("^I clicked on the manager Hierarchy$")
	public void View_Manager_Hierarchy() throws Throwable{
		ov_gear.tab_Manage_Hierarchy.click();
		Thread.sleep(2000);	
	}
	
	@And("^I Verify the Tree Struture$")
	public void Verify_Tree_Struture() throws Throwable{	
		Thread.sleep(4000);	
		ov_gear.Hierarchy_validation();
	}
	
	@And("^I selected the workgroup \"([^\"]*)\" and clicked on Edit button$")
	public void I_selected_the_workgroup(String field) throws Throwable{
		enduser.fill_fields(field);
		//ov_gear.ddl_select_workgroup.selectByVisibleText("AGP");
		Thread.sleep(2000);	
		ov_gear.btn_Edit_Workgroup.click();
		Thread.sleep(2000);
				
	}
	
	@And("^I clicked on Add Role button$")
	public void ADD_Role() throws Throwable{
		ov_gear.btn_Add_Role.click();
	}
	
	@And("^I enter the role name \"([^\"]*)\" and click on create role button$")
	public void Create_Role(String role) throws Throwable{
		enduser.fill_fields(role);
		//ov_gear.tbx_Role_Name.sendKeys("ROLE_AUTO");
		Thread.sleep(2000);
		ov_gear.btn_Create_Role.click();
		Thread.sleep(2000);	
		
		
	}
	
	@And("^the role should be created and displayed under workgroup roles$")
	public void validate_role() throws Throwable{
		String rolevalue = enduser.get_container_from_xml("OVActivationPage","TC39266role").getFieldValue("tbx_Role_Name").toString();
		//System.out.println(rolevalue);
		String[] rolename = rolevalue.split(":");
		
		Select role = new Select(ov_gear.ddl_userselected_role);
		List<WebElement> roles = role.getOptions();
		for(int i = 0; i<= roles.size(); i++){
			if(roles.get(i).getText().contains(rolename[1])){
				System.out.println("Rolename is present in the user role list");
				break;
			}	
		}
						
	}
	
	@And("^I select the role and click on Delete role button$")
	public void Delete_Role() throws Throwable{
		String rolevalue = enduser.get_container_from_xml("OVActivationPage","TC39266role").getFieldValue("tbx_Role_Name").toString();
		String[] rolename = rolevalue.split(":"); 
		ov_gear.ddl_userselected_role.selectByVisibleText(rolename[1]);
		Thread.sleep(2000);	
		ov_gear.btn_Delete_Role.click();	
		Thread.sleep(2000);
	}
	
	@And("^Role should be deleted successfully$")
	public void Validate_msg() throws Throwable{
		  String Msg;
		  Msg = ov_gear.Delete_succes_msg.getText();
		 { 
			if (Msg.contains("Role Deleted Successfully")){
				System.out.println("Role is Deleted Successfully");
		 }else{
				System.out.println("Role Deletion is Unsuccessful");
				ov_gear.Delete_succes_msg.shouldNotBeCurrentlyVisible();
		}}
		 
	}
			
	@And("^I select the \"([^\"]*)\" from workgroup roles and click on Delete role button$")
	public void Delete_Associated_Role(String field) throws Throwable{
		enduser.fill_fields(field);
		Thread.sleep(2000);	
		ov_gear.btn_Delete_Role.click();	
		Thread.sleep(2000);
	}
			
	@And("^Role should not be deleted and User should get an error message$")
	public void Validate_delete_msg() throws Throwable{
		  String Msg;
		  Msg = ov_gear.Delete_succes_msg.getText();
		 { 
			if (Msg.contains("User associated to this and can not delete this role")){
				System.out.println("Associated role cannot be deleted");
		 }else{
				System.out.println("Associated role is deleted");
				ov_gear.Delete_succes_msg.shouldNotBeCurrentlyVisible();
		}}	

	}
	
}



