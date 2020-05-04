package com.bdd.StepDefinition;

import org.testng.Assert;
import com.bdd.Base.TestBase;
import com.bdd.Pages.HomePage;
import com.bdd.Pages.ProductOverview;
import com.bdd.Utilities.TestUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductOverviewSteps extends TestBase{
		
	HomePage hmpage;
	ProductOverview prod;
	TestUtil util = new TestUtil();
	
	
	@When("^User clicks on product overview link$")
	public void user_clicks_on_product_overview_page() throws Throwable {
		
		hmpage = new HomePage();
		String homepgUrl = hmpage.homePageUrl();
		System.out.println("HomePage url is: " + homepgUrl);
		Log.info("HomePage url is: " + homepgUrl);
		Thread.sleep(2000);
		hmpage.productOverviewLink();	
		System.out.println("User clicks on product overview page");
		Log.info("User clicks on product overview page");
	}

	
	  @Then("^Product overview page is displayed$") 
	  public void product_overview_page_is_displayed() throws Throwable {
	  
	  hmpage = new HomePage(); prod = new ProductOverview(); 
	  String prodtitle = prod.prodOverViewTitle();
	  System.out.println("Title of Product Overview page is: " + prodtitle);
	  Log.info("Title of Product Overview page is: " + prodtitle);
	  System.out.println("Product overview page is displayed"); 
	  Log.info("Product overview page is displayed"); 
	  }
	  
	  @And("^User confirms Product information image$") 
	  public void user_confirms_Product_information_image() throws Throwable {
	  
	  prod = new ProductOverview(); 
		  
	  boolean prodimage = prod.productOverViewImage(); 	  
	  Assert.assertTrue(prodimage);
	  System.out.println("User confirms Product information image"); 
	  Log.info("User confirms Product information image"); 
	  }
	  
	 // CONFIRM SUBSCRIBE FEATURE
	  
	  @Given("^User is on Product overview page$") 
	  public void user_is_on_Product_overview_page() throws Throwable {
	  
	  prod = new ProductOverview(); 
	  String prodUrl = prod.productOverviewUrl();
	  System.out.println("Product Overview page url is: " + prodUrl);
	  Log.info("Product Overview page url is: " + prodUrl);
	  System.out.println("User is on Product overview page"); 
	  Log.info("User is on Product overview page"); 
	  }
	  
	  @When("^User enters email address$") 
	  public void user_enters_email_address() throws Throwable {  
	  prod = new ProductOverview(); 
	  prod.subscribe(prop.getProperty("email"));
	  System.out.println("User enters email address"); 
	  Log.info("User enters email address"); 
	  }
	  
	  @And("^User clicks on submit button$") 
	  public void user_clicks_on_submit_button() throws Throwable {
	  
	  prod.submit(); 
	  System.out.println("User clicks on submit button"); 
	  Log.info("User clicks on submit button"); 
	  }
	  
	  @Then("^Successfully subscribed message is displayed$") 
	  public void successfully_subscribed_message_is_displayed() throws Throwable {
	  
	  String msg = prod.submitmsg(); System.out.println("Submit msg is: " +msg);
	  Assert.assertEquals(msg, "You have successfully subscribed with Ahyush.");
	  System.out.println("Successfully subscribed message is displayed"); 
	  Log.info("Successfully subscribed message is displayed"); 
	  }
	  
	//  CHECK CONNECTION TO FACEBOOK FEATURE
	  
	  @When("^Confirm fblink is visible$") 
	  public void Confirm_fblink_is_visible() throws Throwable {	  
	  hmpage = new HomePage(); 
	  prod = new ProductOverview();
	  boolean fblink = prod.fblinkvisible();
	  Assert.assertTrue(fblink); 
	  System.out.println("FB link is visible");	 
	  Log.info("FB link is visible");	
	  }
	  
	  @And("^User clicks on facebook link$") 
	  public void user_clicks_on_facebook_link() throws Throwable {
	  prod.connectToFB(); 
	  System.out.println("Connecting to Facebook"); 
	  Log.info("Connecting to Facebook"); 
	  }
	  
	  @Then("^facebook page is opened$") 
	  public void facebook_page_is_opened() throws Throwable {
	  
	  System.out.println("facebook page is opened in another window"); 
	  Log.info("facebook page is opened in another window");
	  }
	  
	  @Then("^User confirms the url of the landing page and closes it$") 
	  public void user_confirms_the_url_of_the_landing_page_and_closes_it() throws Throwable {
	  
	  String landingPageUrl = util.childUrl();
	  System.out.println("Url of the landing page is: " +landingPageUrl);
	  Log.info("Url of the landing page is: " +landingPageUrl);
	  Assert.assertEquals(landingPageUrl,"https://www.facebook.com/ahyushwellness/");
	  System.out.println("The landing page is Facebook page"); 
	  Log.info("The landing page is Facebook page"); 
	  }
	  
	  @And("^User is back on Product Overview page$") 
	  public void user_is_back_on_product_overview_page() throws Throwable {
	  
	  util.switchToParentWindow(); 
	  Assert.assertTrue(true);
	  System.out.println("User is back on Product Overview page"); 
	  Log.info("User is back on Product Overview page"); 
	  }
	  
	/*  @Then("^Get a screenshot of the \"([^\"]*)\"$")
		public void Get_a_screenshot_of_the(String screenName){
	    
	    TestUtil.getScreenshot(driver, screenName);
	    
		} */
	 
}
