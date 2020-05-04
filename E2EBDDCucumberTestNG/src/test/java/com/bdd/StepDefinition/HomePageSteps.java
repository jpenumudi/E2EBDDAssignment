package com.bdd.StepDefinition;

import org.testng.Assert;
import com.bdd.Base.TestBase;
import com.bdd.Pages.HomePage;
import com.bdd.Utilities.TestUtil;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps extends TestBase {
		
	HomePage hmpage;
	TestUtil util = new TestUtil();
			
	// POINTS TO FOLLOW: 
	// 1. Constructor has to be called for every scenario. 
		
	// CONFIRM THE PRESENCE OF COMPANY LOGO ON THE HOME PAGE
	
	@Then("^Confirm the logo$")
	public void confirm_the_logo() throws Throwable {
	    
		Thread.sleep(3000);
		hmpage = new HomePage();
	    boolean logopresent = hmpage.validateLogoOnHomePage();
	    Assert.assertTrue(logopresent);
	    System.out.println("Confirmed the company logo on the homepage");
	    Log.info("Confirmed the company logo on the homepage");
	       
	   	}

	// CHECK THE VIDEO FUNCTIONALITY

/*	@When("^User clicks on Watch video button$")
	public void user_clicks_on_Watch_video_button() throws Throwable {
		
		Thread.sleep(3000);
		hmpage = new HomePage();   
		hmpage.clickOnVideo();	
		System.out.println("Accessing the video");
		Log.info("Accessing the video");
		Reporter.addStepLog("Accessing the video");
	} */

	@Then("^Video opens in an iframe$")
	public void video_opens_in_an_iframe() throws Throwable {
	
		Thread.sleep(3000);
		util.frameDetails();
		System.out.println("Video opens in an iframe");
		Log.info("Video opens in an iframe");
		Reporter.addStepLog("Video opens in an iframe");
	}

	@Then("^User switches to iframe$")
	public void user_switches_to_iframe() throws Throwable {
		
		Thread.sleep(3000);
		util.switchToIframe();
		System.out.println("Control is on iframe");
		Log.info("Control is on iframe");
		Reporter.addStepLog("Control is on iframe");
	}

/*	@When("^User clicks on play button$")
	public void user_clicks_on_play_button() throws Throwable {
		
		Thread.sleep(3000);
		hmpage.playVideo();
		//hmpage.clickonVideo1(hmpage.VideoButton);
	    System.out.println("User clicked on play button");
	    Log.info("User clicked on play button");
	    Reporter.addStepLog("User clicked on play button");
	}  */

	@Then("^Video plays$")
	public void video_plays() throws Throwable {
		 System.out.println("Playing the video");
		 Log.info("Playing the video");
		 Reporter.addStepLog("Playing the video");
	}

/*	@When("^User Clicks on mute button$")
	public void user_Clicks_on_mute_button() throws Throwable {
	    
		Thread.sleep(6000);
		hmpage.muteVideo();
		System.out.println("User clicked on mute button");
		Log.info("User clicked on mute button");
		Reporter.addStepLog("User clicked on mute button");
	}  */

	@Then("^Video is muted$")
	public void video_is_muted() throws Throwable {
	    
		System.out.println("Muted the video");
		Log.info("Muted the video");
		Reporter.addStepLog("Muted the video");
	}

/*	@When("^User clicks on unmute button$")
	public void user_clicks_on_unmute_button() throws Throwable {
		
		Thread.sleep(4000);
		hmpage.unmuteVideo();
		System.out.println("User clicked on unmute button");	
		Log.info("User clicked on unmute button");	
		Reporter.addStepLog("User clicked on unmute button");
	}  */

	@Then("^Video is unmuted$")
	public void video_is_unmuted() throws Throwable {
		
		System.out.println("Unmuted the video");
		Log.info("Unmuted the video");
		Reporter.addStepLog("Unmuted the video");
	}

/*	@When("^User clicks on pause button$")
	public void user_clicks_on_pause_button() throws Throwable {
	    
		Thread.sleep(6000);
		hmpage.stopVideo();
		System.out.println("User clicked on pause button");
		Log.info("User clicked on pause button");
		Reporter.addStepLog("User clicked on pause button");
	}  */

	@Then("^Video is stopped$")
	public void video_is_stopped() throws Throwable {
		
		System.out.println("Stopped the video");	
		Log.info("Stopped the video");	
		Reporter.addStepLog("Stopped the video");	
	}

	@When("^User navigates back to main frame$")
	public void user_navigates_back_to_main_frame() throws Throwable {
	    
		Thread.sleep(2000);
		util.switchBackToParentFrame();
		System.out.println("The user is back on parent frame");		
		Log.info("The user is back on parent frame");	
		Reporter.addStepLog("The user is back on parent frame");
	}

/*	@And("^User clicks on close button$")
	public void user_clicks_on_close_button() throws Throwable {
		
		Thread.sleep(3000);
		hmpage.closeVideo();
		System.out.println("User clicks on close button");
		Log.info("User clicks on close button");
		Reporter.addStepLog("User clicks on close button");
	}  */

	@Then("^the video window is closed\\.$")
	public void the_video_window_is_closed() throws Throwable {
		
		System.out.println("Closed the video window");
		Log.info("Closed the video window");
		Reporter.addStepLog("Closed the video window");
	}
	
	// COUNTRY DROP DOWN FEATURE

	@When("^User clicks on the country drop down button$")
	public void user_clicks_on_the_country_drop_down_button() throws Throwable {
		
		Thread.sleep(3000);
		hmpage = new HomePage();
		hmpage.clickOnCountryDropDown();
		System.out.println("User clicked on country dropdown");	
		Log.info("User clicked on country dropdown");	
		Reporter.addStepLog("User clicked on country dropdown");
	}  

	@Then("^Country options are displayed$")
	public void country_options_are_displayed() throws Throwable {
	    
		System.out.println("Country options are displayed");
		Log.info("Country options are displayed");
		Reporter.addStepLog("Country options are displayed");
	}

	@And("^User selects a country$")
	public void user_selects_a_country() throws Throwable {
		
		Thread.sleep(3000);
		hmpage.selectCountry();
		System.out.println("User selects a country");
		Log.info("User selects a country");
		Reporter.addStepLog("User selects a country");
	}

	@Then("^Selected country is displayed on the homepage$")
	public void selected_country_is_displayed_on_the_homepage() throws Throwable {
	    
		String country = hmpage.selectedCountry();
		System.out.println("Country selected is: " + country);
		Log.info("Country selected is: " + country);
		Reporter.addStepLog("Country selected is: " + country);
	}

	@And("^User confirms the country$")
	public void user_confirms_the_country() throws Throwable {
		
		if((hmpage.selectedCountry()).equalsIgnoreCase("usa"))
		{
			System.out.println("Selected country name is displayed");
			Log.info("Selected country name is displayed");
			Reporter.addStepLog("Selected country name is displayed");
		}	    
	}
	
	// ABOUT US FEATURE

/*	@When("^User clicks on About Us link$")
	public void user_clicks_on_About_Us_link() throws Throwable {
		
		Thread.sleep(3000);
		hmpage = new HomePage();
		hmpage.aboutUs();
		System.out.println("User clicks on About Us link");	
		Log.info("User clicks on About Us link");
		Reporter.addStepLog("User clicks on About Us link");
	}  */

	@Then("^About us page is rendered$")
	public void about_us_page_is_rendered() throws Throwable {
		
		System.out.println("About Us Page rendered");   
		Log.info("About Us Page rendered"); 
		Reporter.addStepLog("About Us Page rendered"); 
	}

	@Then("^User navigates back to homepage$")
	public void user_navigates_back_to_homepage() throws Throwable {
		
		util.navigateBack();
		Thread.sleep(4000);
		System.out.println("Navigated back to home page");  
		Log.info("Navigated back to home page"); 
		Reporter.addStepLog("Navigated back to home page"); 
	}
	

}
