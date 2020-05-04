package com.bdd.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.bdd.Base.TestBase;

public class HomePage extends TestBase{
	
	// create page factory for the objects on homenliving page
	
	@FindBy(xpath = "//nav[2]//img[1]")
	//@FindBy(xpath = "//nav[1]//img[1]")  // to fail the test
	WebElement logo;
	
	@FindBy(xpath = "//div[5]//div[1]//div[2]//div[1]//div[1]//p[1]//a[1]")
	public WebElement videoButton;
	
	@FindBy(tagName = "iframe")
	WebElement frames;
	
	@FindBy(xpath = "//button[@class='ytp-large-play-button ytp-button']")
	public WebElement playVideoButton;
	
	@FindBy(xpath = "//button[@class='ytp-mute-button ytp-button']")
	public WebElement muteVideoButton;
	
	@FindBy(xpath = "//button[@class='ytp-mute-button ytp-button']")
	public WebElement unmuteVideoButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[1]/video")
	public WebElement stopVideoButton;
	
	@FindBy(xpath = "//button[@class='close']")
	public WebElement exitVideoButton;
	
	@FindBy(xpath = "/html[1]/body[1]/nav[2]/div[1]/div[1]/ul[1]/li[6]/div[1]/button[1]")
	WebElement countryDropDown;
	
	@FindBy(xpath = "//span[contains(text(),'USA')]")
	WebElement selectCountry;
	
	@FindBy(xpath = "//div[contains(text(),'USA')]")
	WebElement selectedCountry;
	
	@FindBy(linkText = "ABOUT US")
	public WebElement aboutUs;
	
	@FindBy(linkText = "PRODUCT OVERVIEW")
	WebElement productOverviewLink;
	
	@FindBy(linkText = "CORPORATE WELLNESS")
	WebElement corporateWellnessLink;
	
	//@FindBy(how = How.XPATH, using = "VideoButton") 
	//public static WebElement VideoButton;
	
	// INITIALIZING THE PAGE OBJECTS
	
		public HomePage() // CONSTRUCTOR CLASS	
		{
			PageFactory.initElements(driver, this); 
		}
	
	// ACTIONS PERFORMED ON THE WEB ELEMENTS (OBJECTS) DEFINED ABOVE --> CREATING METHODS
		
	//  Confirm the presence of website logo on the homepage
	
	public boolean validateLogoOnHomePage()
		{		
			return logo.isDisplayed();		
		}
	
	// HomePage Title
	
	public String homePageTitle()
		{
			return driver.getTitle();
		}
	
	// CHECK THE VIDEO FUNCTONALITY --> click on video button --> should navigate to video section. 
	// Different actions done on the video 
	
	// Created a common method for all the click actions on different elements in this page using if else condition. 
	
	public void clickAction(String elementName){
		
		if(elementName.equals("videoButton")) {
			videoButton.click();
		}else if(elementName.equals("playVideoButton")) {
			playVideoButton.click();
		}else if(elementName.equals("muteVideoButton")) {
			muteVideoButton.click();
		}else if(elementName.equals("unmuteVideoButton")) {
			unmuteVideoButton.click();
		}else if(elementName.equals("stopVideoButton")) {
			stopVideoButton.click();	
		}else if(elementName.equals("exitVideoButton")) {
			exitVideoButton.click();
		}else if(elementName.equals("countryDropDown")) {
			countryDropDown.click();
		}else if(elementName.equals("aboutUs")) {
			aboutUs.click();
		}
	}  
		
		// click on watch video button
		
		/*public void watchVideo()
			{
				videoButton.click();
			}*/
		
	// Play the video
	
	/*public void playVideo()
		{
			playVideoButton.click();
		}*/
	
	// Mute the video
	
	/*public void muteVideo()
		{
			muteVideoButton.click();
		}  */
	
	// Unmute the video
	
	/*public void unmuteVideo()
		{
			unmuteVideoButton.click();
		}*/
	
	// Stop the video
	
	/*public void stopVideo()
		{
			stopVideoButton.click();
		}*/
	
	// Close the video window
	
	/*public void closeVideo()
		{
			exitVideoButton.click();
		}*/
	
		
	// Select USA from country drop down list
	
	public void clickOnCountryDropDown()
		{
			countryDropDown.click();				
		}  
	
	// Select a country
	
	public void selectCountry()
		{
			Actions action = new Actions(driver);
			action.moveToElement(selectCountry).click().build().perform();
		}
	
	// Get the text of selected country
	
	public String selectedCountry()
	{
		return selectedCountry.getText();
	}
	
	// CHECK ABOUT US FEATURE
	
	// Click on About Us link
	
/*	public void aboutUs()
		{
			aboutUs.click();	
		}  */
		
	// clicking on product overview link
	
	public void productOverviewLink()
		{
			productOverviewLink.click();		
		}
	
	// Getting the HomePage Url
	
	public String homePageUrl()
		{			
			return driver.getCurrentUrl();
		}
	
	// clicking on CorporateWellnessLink
	
	public void CorpWellnessLink()
		{			
			corporateWellnessLink.click();	
			return; 
			
		}	
	
}
