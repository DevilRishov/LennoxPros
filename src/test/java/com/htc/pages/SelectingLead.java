package com.htc.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


  public class SelectingLead {
	
	WebDriver driver;
	
	public SelectingLead(WebDriver driver)
	{

		this.driver=driver;
	}
   
	
	@FindBy(xpath = "//body/div[@id='page']/div[1]/div[1]/div[1]/a[1]/i[1]") WebElement SelectBar;
	
	@FindBy(xpath = "//body/div[@id='page']/div[1]/div[1]/div[3]/div[3]/div[1]/div[5]/a[1]") WebElement SalesTools;
	
	@FindBy(xpath = "//a[contains(text(),'Build a Proposal')]") WebElement BuildAProposal;
	
	@FindBy(xpath = "//button[contains(text(),'SELECT LEAD')]") WebElement SelectLead;
	
	
	public void click()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectBar.click();
		
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
          js.executeScript("arguments[0].scrollIntoView();", SalesTools);

		
		SalesTools.click();
		BuildAProposal.click();
		SelectLead.click();
	}
}
