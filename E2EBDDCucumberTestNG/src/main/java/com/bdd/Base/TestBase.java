	package com.bdd.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.bdd.Utilities.TestUtil;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String screenshot;
	//public static ExtentReports report; 
	//public static ExtentTest test; 
	public static Logger Log; 

	public TestBase(){ 
		
		// Initializing the log object (Log) using getLogger method of LogManager class. 
		
				Log = LogManager.getLogger(this.getClass());
				
		// This Log object writes logs to the log file. 
		
		try {
			prop = new Properties();			 
			FileInputStream file = new FileInputStream((System.getProperty("user.dir") + "\\src\\main\\java\\com\\bdd\\Configuration\\Config.properties"));					
			prop.load(file);
						
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}	
	
	}
	
		
public static void initialization() 
		{
		// READ THE PROPERTIES FROM CONFIG.PROPERTIES FILE AND INITIALIZE THE BROWSERS, OPEN THE URL, MAXIMIZE THE BROWSER WINDOW AND DELETE COOKIES. 
		
		String BrowserName = prop.getProperty("browser");
		
			if(BrowserName.equals("chrome")){
					
			System.setProperty("webdriver.chrome.driver", "C:\\BehaviorDrivenDevelopment\\E2EBDDCucumberProject\\Drivers\\chromedriver.exe");			
			System.setProperty("webdriver.chrome.silentOutput", "true"); // Stops showing starting chrome browser...... in the console
			driver = new ChromeDriver();  																		
			}
			else if(BrowserName.equals("firefox")){
				
				System.setProperty("webdriver.gecko.driver", "C:\\BehaviorDrivenDevelopment\\E2EBDDCucumberProject\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(BrowserName.equals("firefox")){
				
				System.setProperty("webdriver.ie.driver", "C:\\BehaviorDrivenDevelopment\\E2EBDDCucumberProject\\Drivers\\IEDriverServer64.exe");
				driver = new InternetExplorerDriver();
			}
														
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
								
				driver.get(prop.getProperty("url"));			
			}

//EXTENT REPORTS

		public static void createExtentReport() {
				Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/src/test/java/resources/Extent-Config.xml"));
				Reporter.setSystemInfo("Host name", "LAPTOP-PBGFF7J3");
				Reporter.setSystemInfo("Username", "Jyothi");
				Reporter.setSystemInfo("Environment", "Automation");
				Reporter.setSystemInfo("OS", "Windows 10");
				Reporter.setSystemInfo("Java Version", "1.8.0_60");
				Reporter.setSystemInfo("Selenium Version", "3.141.59");
				Reporter.setSystemInfo("TestNG Version", "6.14.3");
				Reporter.setSystemInfo("Extent Reports Version", "2.41.2");
				Reporter.setSystemInfo("log4j", "1.2.17");
				Reporter.setTestRunnerOutput("Sample test runner output message");
				}
		
		
	public static void teardown(Scenario scenario) {
		
		if(scenario.getStatus().equalsIgnoreCase("failed"))
		{
			System.out.println("Test Case Failed is " + scenario.getName());
			Log.info("Test Case Failed is " + scenario.getName());
			
			// Capture screenshot of failed tests
			
			screenshot = TestUtil.getScreenshot(driver, scenario.getName() ); // gets the name of the screenshot	
						
			System.out.println("scenario.getName: " + scenario.getName());
			Log.info("scenario.getName: " + scenario.getName());
			System.out.println("The value of Screenshot is: " +screenshot);
			System.out.println("Name of the failed testcase screenshot is: " +scenario.getName() + ".png");
			Log.info("Name of the failed testcase screenshot is: " +scenario.getName() + ".png");
		}
		else if(scenario.getStatus().equalsIgnoreCase("skipped"))
		{
			System.out.println("Test Case Skipped is " + scenario.getName());
			Log.info("Test Case Skipped is: " + scenario.getName());
			screenshot = TestUtil.getScreenshot(driver, scenario.getName() );	
			System.out.println("Name of the skipped testcase screenshot is: " +scenario.getName() + ".png");
			Log.info("Name of the skipped testcase screenshot is: " +scenario.getName() + ".png");
		}
		else if(scenario.getStatus().equalsIgnoreCase("passed"))
		{	
			System.out.println( "Test Case Passed is " + scenario.getName());
			Log.info("Test Case Passed is: " + scenario.getName());
			screenshot = TestUtil.getScreenshot(driver, scenario.getName() );	
			System.out.println("Name of the passed testcase screenshot is: " +scenario.getName() + ".png");
			Log.info("Name of the passed testcase screenshot is: " +scenario.getName() + ".png");
		}
			
	}
	
	
	

}
