package com.bdd.StepDefinition;

import com.bdd.Base.TestBase;
import com.bdd.Pages.HomePage;
import com.bdd.Utilities.TestUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
public class CommonMethods extends TestBase{
	
	HomePage homePage = new HomePage();
	@And("^Take screenshot of the \"([^\"]*)\"$")
	public void Take_screenshot_of_the(String screenName){
    
    TestUtil.getScreenshot(driver, screenName) ;  
	}
			
	@When("^User clicks on \"([^\"]*)\"$")
	public void User_clicks_on(String elementName){
		
		// TestUtil.clickAction(elementName);
		homePage.clickAction(elementName);
	}
	
	
	
	

}
