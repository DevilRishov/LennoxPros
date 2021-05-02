package com.htc.liidaveqa.com;

import java.io.File;
import java.io.IOException;


import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.htc.utility.ConfigDataProvider;

import com.htc.utility.ExcelDataProvider;
import com.htc.utility.Helper;
import com.htc.utility.ScreenshotMethod;
import com.htc.utility.BrowsersSetUp;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.htc.pages.AddingLead;
import com.htc.pages.LoginPage;
import com.htc.pages.SelectingLead;

@Listeners(ScreenshotMethod.class)

public class ApplicationTests{
	
	 String RequestDate;
	    String Document;
	    String Image;
	    
	    public static WebDriver driver;
		ConfigDataProvider config = new ConfigDataProvider();
		ExtentReports report;
		ExtentTest logger;
		ScreenshotMethod scmethod = new ScreenshotMethod();
		
		@BeforeSuite
		public void setUpSuite() {
			
			Reporter.log("Setting up reports and Test is getting ready ", true);
			
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/lennoxPros"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done- Test can be started ", true);

		}
		
		@BeforeClass
		public void setup() {
			
			Reporter.log("Trying to start the Browser and Getting application ready ", true);


			driver = new BrowsersSetUp().setUpBrowser(config.getBrowser(), config.getStagingURL());
			
			Reporter.log("Browser and Application is up and running", true);
			
			        LoginPage login =
					PageFactory.initElements(driver, LoginPage.class);
			        login.click1();
					login.loginPage(config.getusername(), config.getpassword());
					login.click2();
					logger.pass("Login Successfully");

		}

		@DataProvider(name = "data")
		public Object[][] readExcelData() {
			Object[][] objectData = null;
			try {
				objectData = new ExcelDataProvider().webPage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return objectData;
		}

		
		@Test(priority = 1)
		public void selectlead() {
		   SelectingLead selectinglead = PageFactory.initElements(driver, SelectingLead.class);
			selectinglead.click();
			
		}
		
		@Test(priority = 2, dataProvider = "data")
		public void addlead(Object... objectArray) {
			System.out.println("firstname" + (String) objectArray[0]);
			AddingLead addinglead = PageFactory.initElements(driver, AddingLead.class);
			addinglead.click1();
			addinglead.lead((String) objectArray[0], (String) objectArray[1], (String) objectArray[2],
					(String) objectArray[3]);
			addinglead.click2();
			RequestDate = (String) objectArray[4];
			Document = (String) objectArray[5];
			Image = (String) objectArray[6];
			scmethod.onTestFailure(null, "Addlead");
			scmethod.onTestSuccess(null, "Addlead");
		}
		
		@AfterMethod
		public void tearDownMethod(ITestResult result) throws IOException {
			
			Reporter.log("Test is about to end ", true);


			if (result.getStatus() == ITestResult.FAILURE) {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			}
			
			else if(result.getStatus() == ITestResult.SUCCESS) {
				logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			}
			
			report.flush();
			
			Reporter.log("Test is completed >>> Reports Generated ", true);

		}

		@AfterClass
		public void afterClass() {
			
			LoginPage logout =
			PageFactory.initElements(driver, LoginPage.class);
			logout.logout();
			
			driver.quit();
		}
}