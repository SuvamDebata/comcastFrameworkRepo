package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
// Rule 1: Create A separate Java Class
// Rule 2: Object Creation
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
									//Rule 3: Object initialization

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}								//Rule 4: Object Encapsulation
	
	//Rule 5: Object Utilization
	// Through Business Action for Login
	public void loginToApp(String username, String password)
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginButton.click();
	}
	
	
	
}
