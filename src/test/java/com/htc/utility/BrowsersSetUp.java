package com.htc.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowsersSetUp 
{
	WebDriver driver;
	public WebDriver setUpBrowser(String browserType, String appUrl)
	{
		
		if(browserType.equalsIgnoreCase("ie"))
		{
			System.out.println("ie");
			
			System.setProperty("webdriver.ie.driver", "C:\\Users\\risho\\Downloads\\Selenium\\iedriver.exe");
			driver=new InternetExplorerDriver();
		}
		else if(browserType.equalsIgnoreCase("gecko"))
		{
			System.out.println("GeckoBrowser");
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\risho\\Downloads\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserType.equalsIgnoreCase("chrome"))
		{
			System.out.println("chromeBrowser");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\risho\\Downloads\\Selenium\\New folder\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("entered browser type is invalid");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
		
		
	}
	
	public WebDriver setUpBrowser2(String browserType)
	{
		
		if(browserType.equalsIgnoreCase("ie"))
		{
			System.out.println("ie");
			
			System.setProperty("webdriver.ie.driver", "C:\\Users\\risho\\Downloads\\Selenium\\iedriver.exe");
			driver=new InternetExplorerDriver();
		}
		else if(browserType.equalsIgnoreCase("gecko"))
		{
			System.out.println("GeckoBrowser");
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\risho\\Downloads\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserType.equalsIgnoreCase("chrome"))
		{
			System.out.println("chromeBrowser");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\risho\\Downloads\\Selenium\\New folder\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("entered browser type is invalid");
		}
		
		return driver;
		
		
		
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
		// TODO Auto-generated method stub
		
	}

	/*public static void quitBrowser(WebDriver driver) {
		driver.quit();
		
	}*/
}
