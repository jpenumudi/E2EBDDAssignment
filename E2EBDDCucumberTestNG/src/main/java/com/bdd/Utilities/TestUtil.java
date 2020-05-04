package com.bdd.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 
import com.bdd.Base.TestBase;
import com.bdd.Pages.HomePage;

import gherkin.formatter.model.Step;

public class TestUtil extends TestBase {
	
	HomePage homepage = new HomePage(); 
		
	public static long page_load_timeout = 60;
	public static long implicit_wait = 30;
	
	// Switching to Frame Utility.
	
		public void frameDetails() {
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int numberOfTags = frames.size();
		System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);
		for (WebElement iframe : frames) {
		System.out.println("Frame name :" + iframe.getAttribute("name"));
		}  
	
		}
		
		public void switchToIframe() {
			driver.switchTo().frame(0);
		}
		
		public void switchBackToParentFrame()
		{
			driver.switchTo().parentFrame(); 
		}
		
		public void navigateBack()
		{
			driver.navigate().back();
		}
		
		public void closeBrowser() 
		{
			driver.close();
		}
		
		// CLICK ACTION
		
		public void clickAction(String uniqueName){
			
			//homepage = new HomePage();
			
			if(uniqueName.equals("videoButton")) {
				homepage.videoButton.click();
			}else if(uniqueName.equals("playVideoButton")) {
				homepage.playVideoButton.click();
			}else if(uniqueName.equals("muteVideoButton")) {
				homepage.muteVideoButton.click();
			}else if(uniqueName.equals("unmuteVideoButton")) {
				homepage.unmuteVideoButton.click();
			}else if(uniqueName.equals("stopVideoButton")) {
				homepage.stopVideoButton.click();	
			}else if(uniqueName.equals("exitVideoButton")) {
				homepage.exitVideoButton.click();			
			}else if(uniqueName.equals("aboutUs")) {
				homepage.aboutUs.click();
			}
		}
			
				
		//To Scroll to Particular Element.
		
		public static void scrollToSpecificElement(WebDriver driver, WebElement element)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		}

		// explicit wait
		
		// EXPLICIT WAIT FOR CLICK ACTION (ON ANY ELEMENT)
		
			public static WebDriver waitForElementClick(WebDriver driver, WebElement element, int timeout)
			{
				new WebDriverWait(driver, timeout).
				until(ExpectedConditions.elementToBeClickable(element));			
				return driver;
			}
			
		// NAVIGATING TO CHILD WINDOW
			
			public String childUrl()
			{
				Set<String> set = driver.getWindowHandles(); 
				// returns ids of all the windows opened by webdriver and returns set of strings
				// set is one of the collection types in java
				
				System.out.println("The ids of handles in the set: " +set);
				Iterator<String> itr = set.iterator(); // iterator is used to iterate within the windows
				String childurl = "";
				while(itr.hasNext())
				{
					String childwindow = itr.next();
					System.out.println("The id of child window is: " +childwindow);
					driver.switchTo().window(childwindow);	
				    childurl = driver.switchTo().window(childwindow).getCurrentUrl();
				    System.out.println("The value of Childurl is: " +childurl);
				}
				
				return childurl;						
	}
			// NAVIGATING TO PARENT WINDOW
			
			public void switchToParentWindow()
			{
				Set<String> totalWindowsOpened = driver.getWindowHandles();
				System.out.println("Window Handles before closing current active window: " + totalWindowsOpened);		
				System.out.println("Current Window title is: " +driver.getTitle());	
				driver.close();	// closing the current active window which is facebook page
				
				Set<String> remainingWindows = driver.getWindowHandles(); 
				System.out.println("Window handles after closing current active window: " + remainingWindows.stream().findFirst().get());
				//String name = remainingWindows.stream().findFirst().get(); // this is alternative code for line # 128
				String mainWindow = remainingWindows.iterator().next();
				driver.switchTo().window(mainWindow);			
				System.out.println("Title of the main window is: " + driver.getTitle());
				//driver.quit();
						 
			}
			
		// GET STEP NAME 
			
			public static String getStepName(Step stepname) {
				System.out.println("Keyword is: " +stepname.getKeyword());
				System.out.println("Stepname is: " +stepname.getName());
				return stepname.getKeyword() + stepname.getName();
				
			}
			
		// SCREENSHOT - 1 --> Used this for taking the screenshot for each step (source: stackoverflow)  -- DINT WORK
						
	/*		public void captureScreenshot(WebDriver driver, String stepname) {
				try {
					System.out.println("Name of the step: " + stepname);
					String dateName = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
				    TakesScreenshot ts = (TakesScreenshot) driver;
				    File source = ts.getScreenshotAs(OutputType.FILE);
				    FileUtils.copyFile(source, new File("./ScreenShots/"+ stepname + dateName + ".png"));
				    System.out.println("ScreenShot Taken");
				} 
				catch (Exception e) 
				{
				    System.out.println("Exception while taking ScreenShot "+e.getMessage());
				}
			} */
			
			//  SCREENSHOT - 2 --> Used this method to take screenshot of the scenarios (source: from the previous E2E project)
			
			public static String getScreenshot(WebDriver driver, String ScreenshotName){
				
			System.out.println("Screenshot name: " + ScreenshotName);
			String dateName = new SimpleDateFormat("yyyy_MM_dd").format(new Date());	
			System.out.println("The value of dateName is: " +dateName);
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);	
			String destination = System.getProperty("user.dir")+"./Screenshots/" + ScreenshotName + dateName + ".png";
			System.out.println("The value of destination is: " +destination);
			
			File finalDestination = new File(destination);
							
			try {
				FileUtils.copyFile(source, finalDestination);
				}catch (IOException e) 
				{
					System.out.println("Capture Failed" + e.getMessage());
				}
			return destination;	
		
			}	
			
			
		// EMAIL 
			
			public static void sendDetailedEmail(String msg) throws EmailException {
				
				
				System.out.println("Emailing the test results");
				
				EmailAttachment attachment = new EmailAttachment();
				
				//attachment.setPath("test-output\\emailable-report.html"); // to attach the emailable report from test-output folder
				attachment.setPath("C:\\BehaviorDrivenDevelopment\\E2EBDDCucumberTestNG\\target\\cucumber-reports\\extentreport.html"); // to attach the extent report 
				attachment.setDisposition(EmailAttachment.ATTACHMENT);
				attachment.setDescription("Cucumber Test Report");
				attachment.setName("Ahyush.html");
						
				MultiPartEmail email = new MultiPartEmail();		
					
				email.setHostName("smtp.gmail.com");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator(prop.getProperty("username"), prop.getProperty("emailpwd")));
				//System.out.println(prop.getProperty("username"));
				//System.out.println(prop.getProperty("emailpwd"));
				email.setSSLOnConnect(true);
				email.setFrom(prop.getProperty("emailto"));  // sender's email
				//System.out.println(prop.getProperty("gmailaccount"));				
				email.setSubject("BDD Automation Test Report");
				email.setMsg(msg);
				email.addTo(prop.getProperty("emailfrom")); // recipient's email	
				//System.out.println(prop.getProperty("emailto"));
				email.attach(attachment);	
				email.send();
				System.out.println("Email Sent");
								
				} 
				
}