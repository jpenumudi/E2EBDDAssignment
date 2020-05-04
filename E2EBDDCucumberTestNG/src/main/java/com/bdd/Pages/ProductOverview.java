package com.bdd.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bdd.Base.TestBase;

public class ProductOverview extends TestBase {
	
	// create page factory for the objects on homenliving page
		
	@FindBy(xpath = "//img[@class='why-ahyush-img']")
	WebElement prodlogo;
	
	@FindBy(name = "subscribe_email")
	WebElement emailadd;
	
	@FindBy(xpath = "//input[@class='form-control submit px-3']")
	WebElement submit;
	
	@FindBy(xpath = "//span[contains(text(),'You have successfully subscribed with Ahyush.')]")
	WebElement submitmsg;
	
	@FindBy(xpath = "//span[@class='icon-facebook']")					 
	WebElement fblink;
	
		
	// INITIALIZING THE PAGE OBJECTS
	
			public ProductOverview() // CONSTRUCTOR CLASS	
			{
				PageFactory.initElements(driver, this); 
			}
	
	// ACTIONS PERFORMED ON THE WEB ELEMENTS (OBJECTS) DEFINED ABOVE --> CREATING METHODS
			
	// 1. click on product overview link --> product overview page --> confirm the logo
					
			public boolean productOverViewImage()
			{				
				return prodlogo.isDisplayed();
			}
	
	// 2. Subscribe --> enter email and click on submit button
			
		public String subscribe(String email)
		{			
			emailadd.sendKeys(email);
			return email;					
		}
		
		public void submit()
		{
			submit.click();
		}
		
		public String submitmsg()
		{
			return submitmsg.getText();
		}

	// 3. connect to facebook
		
		public boolean fblinkvisible() throws InterruptedException
		{	
			Actions actions = new Actions(driver); 
			actions.moveToElement(fblink).build().perform();
			Thread.sleep(3000);
			//System.out.println("Fb link is visible");
			return fblink.isDisplayed();
		}
		
		public void connectToFB() throws InterruptedException
		{			
			//TestUtil.waitForElementClick(driver, fblink, 40);
			Thread.sleep(3000);
			fblink.click();			
		}
		
		public String prodOverViewTitle()
		{
			return driver.getTitle();
		}
		
		public String productOverviewUrl()
		{
			return driver.getCurrentUrl();
		}
				
}