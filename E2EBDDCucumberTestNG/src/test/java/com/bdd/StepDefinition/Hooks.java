package com.bdd.StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bdd.Base.TestBase;
import com.bdd.Utilities.ScreenRecording;
//import com.bdd.Utilities.TestUtil;
import com.cucumber.listener.Reporter;
//import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
//import gherkin.formatter.model.Step;

// Hooks are blocks of code that can run at various points in the execution process. 
// HOOKS ARE USED TO MANAGE THE CODE WORKFLOW AND HELP REDUCE CODE REDUNDANCY. 
// hooks can be scenario hooks which run before and after the scenarios (@Before, @After) or before and after each step (@BeforeStep, @AfterStep)

public class Hooks extends TestBase {	
		
	@Before // the method setUp runs before every scenario --> so before every scenario, the browser is initialized, web site is launched 
	// browser actions are performed. 
	
	public void setUp(Scenario scenario) throws Exception // Scenario is an interface --> sending the interface as the parameter inside the method
	{
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Starting the Scenario - " + scenario.getName());
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------");
		
		ScreenRecording.startRecording(scenario.getName());
		
		initialization();
		
		System.out.println("Browser opened, url launched and user is on homepage");
		Log.info("Browser opened, url launched and user is on homepage");	 
		Reporter.addScenarioLog("Browser opened, url launched and user is on homepage");  // dont see the log in the report 
		
	}
		
	// CLOSING THE BROWSER
	
	@After(order=0) // the method cleanUp is invoked after every scenario --> tear down method is called after every scenario so the 
	// browser is closed after every scenario. 
	public void cleanUp(Scenario scenario) throws Exception
	{
		
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Status of the scenario - " + scenario.getName() + " is: " + scenario.getStatus());
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------");
		
		ScreenRecording.stopRecording();
		
		teardown(scenario); // takes the screenshot for every scenario 
		driver.close();
		
		
		System.out.println("Browser closed");
		Log.info("Browser Closed");		
		Reporter.addScenarioLog("Browser closed"); // dont see the log in the report. 	
	}  

	// ATTACHING SCREENSHOT TO THE EXTENT REPORT WHEN A SCENARIO FAILS 
	
	@After(order=1)  // order=1 is executed before order = 0
	public void embedScreenshot(Scenario scenario)
	{
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			System.out.println("The value of screenshotName is: " + screenshotName);
			try {
				 
				TakesScreenshot ts = (TakesScreenshot) driver; //This takes a screenshot by the driver 
				File source = ts.getScreenshotAs(OutputType.FILE); // saving it to a specified location
				
				// Building up the destination path to save the screenshot with .png extension
				// creating a folder 'screenshots' with in the cucumber-report folder
				
				String destination = System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png";
				
				File finalDestination = new File(destination);
				
				//Copying the screenshot from source location to destination location
				FileUtils.copyFile(source, finalDestination);  
 
				//This attaches the specified screenshot to the extent report
				Reporter.addScreenCaptureFromPath(destination.toString());
				
				} catch (IOException e) 
				{
					System.out.println("Capture Failed" + e.getMessage());
				}								
		}
		
	}
	
			

}
