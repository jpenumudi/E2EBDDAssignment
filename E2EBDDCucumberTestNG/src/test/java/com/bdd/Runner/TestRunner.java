package com.bdd.Runner;

//import org.apache.commons.mail.EmailException;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.bdd.Base.TestBase;
//import com.bdd.Utilities.TestUtil;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

//@RunWith(Cucumber.class)  // This is cucumber-JUnit annotation  
@CucumberOptions  // this annotation provides options 
		
		// (features = {"Features"}, 
		(features = {"C:\\BehaviorDrivenDevelopment\\E2EBDDCucumberTestNG\\src\\main\\java\\com\\bdd\\Features"}, // to run all feature files		
		//(features = {"C:\\BehaviorDrivenDevelopment\\E2EBDDCucumberTestNG\\src\\main\\java\\com\\bdd\\Features\\HomePage.feature"}, // to run specific feature file 		
		glue= {"com.bdd.StepDefinition"}, // glues the step def file with the feature file
		//plugin = {"pretty", "html:test-output", "json:target/JsonReports/Cucumber-Report.json", "junit:junit_xml/cucumber.xml"},	
		plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/Extent-reports/extentreport.html"},		
		monochrome = true, // displays the output in a readable format. 
		strict = true,  
		dryRun=false // when true this is kind of pseudo execution to make sure every step in the feature file has a corresponding step in the step def file
		//tags = {"@RunThis"} 
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	 // AbstractTestNGCucumberTests is a class supports testng integration with cucumber
	
	private TestNGCucumberRunner testNGCucumberRunner;	
	// TestNGCucumberRunner is a pre-defined or inbuilt class which provides various methods like runCucumber, provide features, finish etc. 
	
	@BeforeClass(alwaysRun = true) // runs before a scenario 
	public void setUpClass()
	{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass()); 		
	}	
	
	// once all the cucumber options are read @Test is executed. 	
	
	@Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature)
	// CucumberFeatureWrapper used as a parameter of a test method is an interface of making TestNG report more descriptive. 
	{
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());			
	}
	
	@DataProvider // dataProvider fetches the data like how many feature files are there that need to be executed. 
	public Object [][] features()
	{
		return testNGCucumberRunner.provideFeatures();
	}
	
	@AfterClass(alwaysRun = true) // runs after a scenario
	public void tearDownClass()
	{		
		TestBase.createExtentReport();
		System.out.println("Generated Extent report successfully.");		
		testNGCucumberRunner.finish();		// closes testng cucumber connection		
	}
	
	/*@AfterSuite
	public void sendEmailFinally() throws EmailException 
	{
		TestUtil.sendDetailedEmail("Email with attachments");
	} */

}
