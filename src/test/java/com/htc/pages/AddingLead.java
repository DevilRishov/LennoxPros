package com.htc.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddingLead {
	
WebDriver driver;
	
	public AddingLead(WebDriver driver)
	{

		this.driver=driver;
	}
	
	@FindBy(className = "btn btn-primary hide-mobile introjs-l-9 introjs-l-83") WebElement addLead;
	
	@FindBy(id = "firstName") WebElement firstName;
	
	@FindBy(id = "lastName") WebElement lastName;
	
	@FindBy(id = "phNo") WebElement phoneNumber;
	
	@FindBy(id = "email") WebElement emailID;
	
	@FindBy(id = "calender1") WebElement srDate;
	
	@FindBy(id = "scheduleRequestTime") WebElement srTime;
	
	@FindBy(className = "m-0 add-document") WebElement addDocument;
	
	@FindBy(id = "multipleImageSelect[0]") WebElement addImages;
	
	@FindBy(id = "btn-addLeadsForm") WebElement saveLead;
	
	
	public void click1()
	{
		addLead.click();
	}
    
	
	public void lead(String fname, String lname, String pnumber, String email)
	{
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		phoneNumber.sendKeys(pnumber);
		emailID.sendKeys(email);
	}
	
	public void click2()
	{
		srDate.click();
		srTime.click();
		addDocument.click();
		addImages.click();
		saveLead.click();
	}
    

}
