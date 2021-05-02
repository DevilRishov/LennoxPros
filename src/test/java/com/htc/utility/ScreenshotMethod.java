package com.htc.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.htc.liidaveqa.com.*;



public class ScreenshotMethod implements  ITestListener{
	
	 public static WebDriver driver;

		public void onFinish(ITestContext arg0) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ITestContext arg0) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}
		
		
		public void onTestSuccess(ITestResult result,String Testname) {
			// TODO Auto-generated method stub
			
			TakesScreenshot ts = (TakesScreenshot)ApplicationTests.driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			
			try
			{
				FileHandler.copy(file, new File("./Screenshots/Success/"+getCurrentDateTime()+Testname+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("screenshot of success is taken");
			
		}
		
		public void onTestFailure(ITestResult result,String Testname) {
			// TODO Auto-generated method stub
			TakesScreenshot ts = (TakesScreenshot)ApplicationTests.driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			
			try {
				FileHandler.copy(file, new File("./Screenshots/Failure/"+getCurrentDateTime()+Testname+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("screenshot of failure  is taken");
			
		}
			
		

		public void onTestSkipped(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}

		public void onTestStart(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}

		public static String getCurrentDateTime() {

			DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

			Date currentDate = new Date();
			
			return customFormat.format(currentDate);

		}

		public void onTestFailure(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSuccess(ITestResult arg0) {
			// TODO Auto-generated method stub
			
		}


		}


