package com.bdd.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bdd.Base.TestBase;

public class CorporateWellness extends TestBase {
	
	// create page factory for the objects on homenliving page
		
	@FindBy(xpath = "//span[contains(text(),'Contact Us')]")
	WebElement contactDetails;
	
	@FindBy(xpath = "//h1[@class='mb-4']")
	WebElement heading;
	
	@FindBy(linkText = "Privacy Policy")
	WebElement privacyPolicy;
	
	@FindBy(id = "nav-login")
	WebElement login;
	
	// INITIALIZING THE PAGE OBJECTS
	
	public CorporateWellness() // CONSTRUCTOR CLASS	
		{
			PageFactory.initElements(driver, this); 
		}
	
	// ACTIONS PERFORMED ON THE WEB ELEMENTS (OBJECTS) DEFINED ABOVE --> CREATING METHODS
	
	
	// get corporate wellness url
	
	public String corpWellnessUrl()
		{
			return driver.getCurrentUrl();
		}
	
	// Validate the title of Corporate Wellness page
	
	 public String corporateWellnessTitle()
		 {		 
			 return driver.getTitle();
		 }
	 
	 // GET THE CONTACT DETAILS 
	 
	 // Access the contact us page
	 
	 public void contactDetails()
		 {	
			 contactDetails.click();		
		 }
	 
	 // Get the title of contact us page
	 
	 public String contactDetailsTitle()
		 {
			 return driver.getTitle();
		 }
	 
	 // Validate the heading on contact us page
	
	 public String validateHeading() throws InterruptedException 
		{		
			String headingtext =" ";
			Thread.sleep(3000);
			contactDetails.click();
			
			try{
			headingtext = heading.getText();
				
			}catch (Exception e){
				System.out.println(":: ::" +e.getMessage());				
			}  
			return headingtext;			 
		}
	 
	 // Navigate to homepage
	 
	 public void goToHomePage()
		 {
			 driver.get(prop.getProperty("url"));
		 }
	 
	 // 3. CHECK THE PRIVACY POLICY
	 
	 // Access the privacy policy page
	 
	 public void privacyPolicy()
	 {
		 	
		 privacyPolicy.click();
	 }
	 
	 // Get the privacy policy url
	 
	 public String privacyPolicyUrl()
	 {
		
		 return driver.getCurrentUrl();
	 }
	 
	 // LOGIN FUNCTIONALITY
	 
	 // Access the login page
	 
	 public void login()
	 {
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", login);
	 }
	 
	 // Get the url of the login page. 
	 
	 public String loginUrl()
	 {
		 return driver.getCurrentUrl();
	 }
	 
}
