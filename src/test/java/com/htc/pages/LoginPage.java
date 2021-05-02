package com.htc.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;





public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {

		this.driver=ldriver;
	}
	
	
    @FindBy(xpath="//a[contains(text(),'Sign In')]") WebElement signIn;
	@FindBy(id="j_username") WebElement userID;
	@FindBy(id="j_password") WebElement pass;
	@FindBy(id="loginSubmit") WebElement signInButton;
	
	@FindBy(className = "signedin-user" ) WebElement wc;
	@FindBy(id = "logout_id") WebElement signOut; 
	
	public void click1()
	{
		signIn.click();
	}

	
	public void loginPage(String username,String password)
	{
		userID.sendKeys(username);
		pass.sendKeys(password);
		
	}
	 public void click2()
	 {
		 signInButton.click();
	 }
	 
	 public void logout()
		{
			wc.click();
			signOut.click();
		}
	 

	
}


