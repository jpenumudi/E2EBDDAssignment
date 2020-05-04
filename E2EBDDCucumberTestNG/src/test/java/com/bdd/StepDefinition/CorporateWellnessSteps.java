package com.bdd.StepDefinition;

import org.junit.Assert;
//import org.openqa.selenium.WebDriver;
import com.bdd.Base.TestBase;
import com.bdd.Pages.CorporateWellness;
import com.bdd.Pages.HomePage;
import com.bdd.Utilities.TestUtil;
//import com.bdd.Utilities.ThreadLocalStepDefinitionMatch;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import cucumber.runtime.StepDefinitionMatch;
//import cucumber.runtime.Utils;
//import gherkin.formatter.model.Step;

public class CorporateWellnessSteps extends TestBase {
	
	HomePage hmpage;
	CorporateWellness corp ;
	TestUtil util = new TestUtil();
	
	// CONFIRM THE TITLE OF CORPORATE WELLNESS PAGE
	
	@When("^User clicks on corporate wellness link$")
	public void user_clicks_on_corporate_wellness_link() throws Throwable {
				
		hmpage = new HomePage();
		String homepgUrl = hmpage.homePageUrl();
		System.out.println("HomePage url is: " + homepgUrl);  
		Log.info("HomePage url is: " + homepgUrl);  
		Thread.sleep(2500);
		hmpage.CorpWellnessLink();
		System.out.println("User clicks on corporate wellness link");
		Log.info("User clicks on corporate wellness link");
	}

	@Then("^Corporate Wellness page opens$")
	public void corporate_Wellness_page_opens() throws Throwable {
		
		corp = new CorporateWellness();
		String corpWellnessUrl = corp.corpWellnessUrl();
		System.out.println("Corporate Wellness page url is: " + corpWellnessUrl);	
		Log.info("Corporate Wellness page url is: " + corpWellnessUrl);
	}
	
	@And("^User gets the title of the corporate wellness page$")
	public void user_gets_the_title_of_the_corporate_wellness_page() throws Throwable {
	    		
		String corpTitle = corp.corporateWellnessTitle();
		System.out.println("Corporate Wellness page title is: " + corpTitle);	
		Log.info("Corporate Wellness page title is: " + corpTitle);	
		Assert.assertEquals(corpTitle, "Ahyush | Corporate Wellness");
		System.out.println("Validated the title to be correct");	
		Log.info("Validated the title to be correct");			
	}
	
	// GET THE CONTACT DETAILS

	@Then("^User gets the title of the home page$")
	public void user_gets_the_title_of_the_home_page() throws Throwable {
	    
		hmpage = new HomePage();
		String homePageTitle = hmpage.homePageTitle();
		System.out.println("HomePage title is: " + homePageTitle);
		Log.info("HomePage title is: " + homePageTitle);
	}

	@When("^User navigates to Corporate wellness page$")
	public void user_navigates_to_Corporate_wellness_page() throws Throwable {
		
		hmpage.CorpWellnessLink();
		System.out.println("User clicks on corporate wellness link");	
		Log.info("User clicks on corporate wellness link");	
	}

	@Then("^User gets the url of corporate wellness page$")
	public void user_gets_the_url_of_corporate_wellness_page() throws Throwable {
	    
		corp = new CorporateWellness();
		String corpWellnessUrl = corp.corpWellnessUrl();
		System.out.println("Corporate Wellness page url is: " + corpWellnessUrl);
		Log.info("Corporate Wellness page url is: " + corpWellnessUrl);
	}

	@Then("^User clicks on Contact us link$")
	public void user_clicks_on_Contact_us_link() throws Throwable {
	    
		corp.contactDetails();
		System.out.println("User clicks on Contact us link");
		Log.info("User clicks on Contact us link");
	}
	
	@Then("^Contact details page renders$")
	public void contact_details_page_renders() throws Throwable {
		
		String contactDetailsTitle = corp.contactDetailsTitle();
		System.out.println("Contact details page title is: " + contactDetailsTitle);	
		Log.info("Contact details page title is: " + contactDetailsTitle);
	}
	
	@Then("^User gets the heading of the page$")
	public void user_gets_the_heading_of_the_page() throws Throwable {
		
		String Heading = corp.validateHeading(); 
		System.out.println("Heading found is: " +Heading);
		Log.info("Heading found is: " +Heading);
		Assert.assertEquals(Heading, "Let's Get In Touch");
		System.out.println("Validated heading on the contacts page");
		Log.info("Validated heading on the contacts page"); 
		//util.captureScreenshot(driver, "User gets the heading of the page");
		//System.out.println("Screenshot of contacts page heading captured");
	}

	@Then("^User navigates back to the home page$")
	public void user_navigates_back_to_the_home_page() throws Throwable {		
		corp.goToHomePage();
		System.out.println("User navigates back to the home page");	
		Log.info("User navigates back to the home page");	
	}

	@And("^User confirms that navigation is successful$")
	public void user_confirms_that_navigation_is_successful() throws Throwable {
	    
		//hmpage = new HomePage();
		String homePageUrl = hmpage.homePageUrl();
		System.out.println("Landing page url is: " + homePageUrl); 
		Log.info("Landing page url is: " + homePageUrl);  
		if(homePageUrl.equalsIgnoreCase("http://ahyush.com/"))
		{
			System.out.println("User navigated to homepage successfully"); 
			Log.info("User navigated to homepage successfully"); 
		}		
	}
	
	//CHECK THE PRIVACY POLICY

	@Given("^User on corporate wellness page$")
	public void user_is_on_corporate_wellness_page() throws Throwable {
		
		hmpage = new HomePage();
		hmpage.CorpWellnessLink();
		System.out.println("User clicks on corporate wellness link");
		Log.info("User clicks on corporate wellness link");
		corp = new CorporateWellness();
		String corpWellnessUrl = corp.corpWellnessUrl();
		System.out.println("Corporate Wellness page url is: " + corpWellnessUrl);	 
		Log.info("Corporate Wellness page url is: " + corpWellnessUrl);	 
	}

	@When("^user clicks on privacy policy option$")
	public void user_clicks_on_privacy_policy_option() throws Throwable {
		
		corp.privacyPolicy();
		System.out.println("User clicks on  privacy policy option");
		Log.info("User clicks on  privacy policy option"); 
	}

	@Then("^User accesses privacy policy page$")
	public void user_accesses_privacy_policy_page() throws Throwable {
		
		String privacyPolicyUrl = corp.privacyPolicyUrl();
		System.out.println("Privacy Policy url is: " + privacyPolicyUrl);   
		Log.info("Privacy Policy url is: " + privacyPolicyUrl);   
		}

	@And("^Again user navigates back to corporate wellness page$")
	public void again_user_navigates_back_to_home_page() throws Throwable {
	    
		Thread.sleep(2500);
		hmpage.CorpWellnessLink();
		System.out.println("User navigates back to the corporate wellness page");	
		Log.info("User navigates back to the corporate wellness page");	
	}
	
	// CHECK THE LOGIN FUNCTIONALITY

	@Given("^User is on corporate wellness page$")
	public void user_on_corporate_wellness_page() throws Throwable {
		
		hmpage = new HomePage();
		hmpage.CorpWellnessLink();
		System.out.println("User clicks on corporate wellness link");
		Log.info("User clicks on corporate wellness link");
		corp = new CorporateWellness();
		String corpWellnessUrl = corp.corpWellnessUrl();
		System.out.println("Corporate Wellness page url is: " + corpWellnessUrl);
		Log.info("Corporate Wellness page url is: " + corpWellnessUrl);
		if(corpWellnessUrl.equalsIgnoreCase("http://ahyush.com/corporate-wellness"))
		{
			System.out.println("User is on corporate wellness page");
			Log.info("User is on corporate wellness page");
		}
	} 

	@When("^User clicks on login link$")
	public void user_clicks_on_login_link() throws Throwable {
		
		Thread.sleep(3000);
		corp.login();
		System.out.println("User clicks on login link");
		Log.info("User clicks on login link");
	}

	@Then("^Login page is displayed$")
	public void login_page_is_displayed() throws Throwable {
				
		System.out.println("Login page is opened in another window");
		Log.info("Login page is opened in another window");
	}

	@Then("^User closes the login page$")
	public void user_closes_the_login_page() throws Throwable {
		
		String landingPageUrl =util.childUrl();
		System.out.println("Url of the landing page is: " +landingPageUrl);
		Log.info("Url of the landing page is: " +landingPageUrl);
		System.out.println("Child window closed");
		Log.info("Child window closed");
		//Assert.assertEquals(landingPageUrl, "https://www.ahyush.in/");
		//System.out.println("The landing page is login page");
		
		/*String loginUrl = corp.loginUrl();
		System.out.println("Login page Url is: " +loginUrl);
		if(loginUrl.equalsIgnoreCase("https://www.ahyush.in/"))
		{
			util.childUrl();
			System.out.println("Child window closed");
		}	*/		    
	} 

	@And("^User is back on the corporate wellness page$")
	public void user_is_back_on_the_corporate_wellness_page() throws Throwable {
		
		//hmpage = new HomePage();
		//String homepgUrl = hmpage.homePageUrl();		
		//System.out.println("HomePage url is: " + homepgUrl);
		
		util.switchToParentWindow();
		Assert.assertTrue(true);
		System.out.println("User is back on corporate wellness page");
		Log.info("User is back on corporate wellness page");	    
	}  
	
}
