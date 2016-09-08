package com.ctl.it.qa.OmniVueTests.user;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ctl.it.qa.omnivue.tools.pages.common.OVActivationPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVAssociatedModServicesPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVAssociatedServicesPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVCreateDevicePage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVCreateLocationPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVDeviceLookupPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVHomepage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVLoginPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVModDeviceLookupPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVModServiceDetailsPage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVSearchDevicePage;
import com.ctl.it.qa.omnivue.tools.pages.common.OVServiceDetailsPage;
import com.ctl.it.qa.omnivue.tools.steps.user.UserSteps;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Steps;

public class OVCreateStepDefinition {
	OVLoginPage loginPage;
	OVHomepage ovhomepage;
	OVActivationPage actvtnpage;
	OVAssociatedServicesPage assocservicespage;
	OVDeviceLookupPage devicelookuppage;
	OVSearchDevicePage searchdevicepage;
	OVServiceDetailsPage servicedetailspage;
	OVModServiceDetailsPage modservicedetailspage;
	OVModDeviceLookupPage moddevicelookuppage;
	OVAssociatedModServicesPage modassocservicespage;
	OVCreateDevicePage devcreatepage;
	OVCreateLocationPage locpage;
	

	@Steps
	UserSteps enduser;
	@And("^I go to \"([^\"]*)\" create type and select \"([^\"]*)\" type$")
		public void selectFormType(String type,String subtype) {
		//fillMandatoryFields(actvtnpage,get_data_for_page(actvtnpage),type);
		//enduser.selectType(type,subtype);
		
		try {
			System.out.println(type);
			System.out.println(subtype);
			//System.out.println(tech);
			actvtnpage.ddl_createType.selectByVisibleText(type);
			Thread.sleep(1000);
			Thread.sleep(1000);
			switch(type){
					case "Inventory"	: 	actvtnpage.ddl_CreateinvntryType.selectByVisibleText(subtype);
											break;
					case "Network Build": 	actvtnpage.ddl_CreateNetworkType.selectByVisibleText(subtype);
											break;
				}	
			Thread.sleep(1000);
			//actvtnpage.ddl_CreateinvntryType.click();
			//Thread.sleep(5000);
			//selectByVisibleText(subtype).click();
			//actvtnpage.ddl_createinventType(subtype);
			//Thread.sleep(1000);
			//actvtnpage.click_Technologytype(tech);
			//Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@And("^I Select \"([^\"]*)\" as Filter By value$")
	public void selectFilterby(String tech){
		try {
			actvtnpage.click_Technologytype(tech);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		
	
	@Then("Select the technology as \"([^\"]*)\" with Device Type as \"([^\"]*)\" with Sub-Type as \"([^\"]*)\"$")
	public void createFormpage(String techtype,String devtype,String devsubtype){
		try {
			System.out.println(techtype);
			System.out.println(devtype);
			System.out.println(devsubtype);
		actvtnpage.ddl_techType.selectByVisibleText(techtype);
		Thread.sleep(1000);
		actvtnpage.ddl_devType.selectByVisibleText(devtype);
		Thread.sleep(1000);
		actvtnpage.ddl_devsubType.selectByVisibleText(devsubtype);
		Thread.sleep(1000);
		actvtnpage.btn_create.click();
		Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@And("Search for the  location \"([^\"]*)\" Building CLLI$")
	public void locationclli(String cllitype) throws InterruptedException{
		Thread.sleep(5000);
		devcreatepage.btn_locationLookup.click();
		System.out.println(cllitype);
		Thread.sleep(5000);
		//loginPage.waitForChildWindowToAppear(1);
		//System.out.println(loginPage.getAlert());
		//loginPage.switchToFrame("omnivue", 5);
		//loginPage.switchToFrame(frameName, waitTime);
		//enduser.fill_fields(cllitype);
		//Thread.sleep(5000);
		devcreatepage.btn_lookUp.click();
		Thread.sleep(5000);
	}
	
	@And("^I fill the mandatory fields with \"([^\"]*)\" data$")
	public void fillmandatoryfield(String testdata){
		enduser.fillmandatoryfield(testdata);		
	}
	
	@Then("^I validated \"([^\"]*)\" technology and device type$")
	public void i_validated_technology_and_device_type(String techType) throws Throwable 
	{
		System.out.println(techType);
		actvtnpage.ddl_techType.selectByVisibleText(techType);
		String[] actualDeviceType = {"","Fiber Distribution Hub","Fiber Distribution Panel","Fiber Multiport Service Terminal","Fiber Splitter"};
		 WebElement dropdown = enduser.getDriver().findElement(By.xpath("//label[text()='Device Type']/following-sibling::select"));
		 ArrayList<String> ExpDeviceType = null;
		 Select select = new Select(dropdown);  

		 List<WebElement> options = select.getOptions();  
		 System.out.println(options.size());
		 
		 for(int j=0;j<=options.size()-1;j++)  
		 {  
			 //System.out.println("..............."+options.get(j).getText());
		  boolean match = false;
		  for (int i=0; i<actualDeviceType.length; i++){
			 
		      if (options.get(j).getText().equals(actualDeviceType[i]))
		    		  {
		        match = true;
		        System.out.println(options.get(j).getText()+"==="+actualDeviceType[i]);
		    	  
		      }
		    }
		   
		 // Assert.assertTrue(match);
		 }
		 System.out.println("successfully validated");
	}
	
	@Then("Select the Role as \"([^\"]*)\" with Device Type as \"([^\"]*)\" with Sub-Type as \"([^\"]*)\"$")
	public void createroleform(String role,String devtype,String devsubtype){
		try {
		actvtnpage.ddl_role.selectByVisibleText(role);
		Thread.sleep(1000);
		actvtnpage.ddl_devType.selectByVisibleText(devtype);
		Thread.sleep(1000);
		actvtnpage.ddl_devsubType.selectByVisibleText(devsubtype);
		Thread.sleep(1000);
		actvtnpage.btn_create.click();
		Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^I validated \"([^\"]*)\" radio button and \"([^\"]*)\" radio button$")
	public void i_validated_radio_button_and_radio_button(String radioBtn1, String radioBtn2) throws Throwable {
		/*if( enduser.getDriver().findElement(By.xpath(".//*[@id='0']/ng-include/div/div[11]/div/div[2]/div/div[3]/input[3]")).isDisplayed() && enduser.getDriver().findElement(By.xpath("//*[@id='0']/ng-include/div/div[11]/div/div[2]/div/div[3]/input[4]")).isDisplayed()){
		System.out.println("Element is Visible");
		}else{
		System.out.println("Element is InVisible");
		}*/
		devcreatepage.IsRadioButtonPresent();
	}
	
	@Then("^Validate attributes in \"([^\"]*)\" device details page$")
	public void validate_atributes_of_device_details_page(String devtype)throws Throwable {
		Thread.sleep(5000);
		System.out.println(devcreatepage.validatingAtributesOfPassiveCreatePage(devtype));	
		 }
	
	@Then("^Validate attributes in order details page$")
	public void validate_order_attributes() {
		enduser.order_attribute();
	}

	@Then("^Validate the device name in search page$")
	public void validate_the_device_name_in_search_page() throws Throwable {
	    enduser.searched_device_is(searchdevicepage.tbx_deviceName.getText());
	}
	
	@Then("^Validate \"([^\"]*)\" radio button in device create page$")
	public void validate_radio_button_in_device_create_page(String radioButton) throws Throwable {
		  
		if (devcreatepage.isRadioButtonSelected(radioButton)) 
		     {
				System.out.println("pass");
			}
		     else throw new Error("not seclected");
		}
	
	@And("^Validate Location CLLI for \"([^\"]*)\"$")
	public void validate_Location_CLLI_is_optional_for(String arg1) throws Throwable {
		if (!(devcreatepage.isLocationCLLIMandatory())) {
			System.out.println("location clli.........."+devcreatepage.isLocationCLLIMandatory());
		}
		 else throw new Error("it a mandatory filed for Ethernet");
	}
	
	// Network Build Device Creation--Sairam
	@And("^I Entered Serving Wire Center CLLI as By value \"([^\"]*)\" and Engineering Order Id as By value \"([^\"]*)\"$")
	public void Enter_WirecenterCLLI_and_EngOrdId(String Value, String id) throws Throwable{
			devcreatepage.tbx_SWCCLLI.sendKeys(Value);
	             devcreatepage.tbx_EngOrdId.sendKeys(id);
			Thread.sleep(5000);
			actvtnpage.btn_NB_create.click();
		}
	@And("^I select \"([^\"]*)\" location type$")
	public void select_locationtype(String locationtype) throws Throwable{
		locpage.ddl_Locationtype.selectByVisibleText(locationtype);
		Thread.sleep(1000);
		locpage.btn_Location_create.click();
	}
	@And("^I fill the mandatory fields with location data$")
	public void filling_the_mandatoryfields_with_location_data() throws Throwable{
		Thread.sleep(1000);
		locpage.rdbtn_addRange.click();
		Thread.sleep(1000);
		for(int i=1;i<=3;i++){
			locpage.ddl_locationRole.selectByIndex(i);
		}
		Thread.sleep(1000);
		locpage.tbx_addressNumber.sendKeys("515");
		Thread.sleep(1000);
		locpage.tbx_street.sendKeys("TEST STREET3");
		Thread.sleep(1000);
		locpage.ddl_state.selectByVisibleText("TX-Texas");
		Thread.sleep(1000);
		//locpage.ddl_city.selectByVisibleText("");
		Thread.sleep(1000);
		locpage.tbx_zip.sendKeys("734953");
		Thread.sleep(1000);
		locpage.ddl_NewConstructionIndicator.selectByVisibleText("Yes");
		Thread.sleep(1000);
		locpage.tbx_sWCCLLI.sendKeys("23478372");
		Thread.sleep(1000);
		locpage.btn_FindAddressRange.click();
		Thread.sleep(1000);
		locpage.ddl_addrangeVal.click();
		
		
		
		
		
	
	}
}
