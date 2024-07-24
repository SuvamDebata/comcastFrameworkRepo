package v_TigerWithUtilityAndDDT;

import java.io.IOException;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.CreatingNewLeadsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadsPage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.generic.fileutility.FileUtility;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class TestScript_Functional {

	//public static void main(String[] args) throws Throwable 
	@Test
	public void  testScript_Functional() throws IOException
	{
		
		FileUtility flib= new FileUtility("C:\\Users\\suvam\\eclipse-workspace\\ComcastCRMGUIFramework\\configAppData\\commondata.properties");
		WebDriverUtility wdu=new WebDriverUtility();
		//JavaUtility ju=new JavaUtility();
		
		
		WebDriver driver=wdu.openBrowser(flib.getDataFromPropertiesFile("Browser"));
	//Login 
		 //wdu.waitForPageLoad(driver); implemented in the login business class
		 // driver.manage().window().maximize(); implemented in the login business class
		
		  driver.get(flib.getDataFromPropertiesFile("url"));
		  
		  //By using page factory class, when the business action do not have a constructor with the page factory
		  //LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		  
		  
		  //Or we can declare a constructor with the page factory in the business action class and pass the driver through the constructor
		  LoginPage lp=new LoginPage(driver);
		  
		  //Login without getters or without encapsulation
			/*
			 * lp.usernameEdt.sendKeys(flib.getDataFromPropertiesFile("username"));
			 * lp.passwordEdt.sendKeys(flib.getDataFromPropertiesFile("password"));
			 * lp.loginButton.click();
			 */
		  //Login with getters
			/*
			 * lp.getUsernameEdt().sendKeys(flib.getDataFromPropertiesFile("username"));
			 * lp.getPasswordEdt().sendKeys(flib.getDataFromPropertiesFile("password"));
			 * lp.getLoginButton().click();
			 */
		  //LoginBusinessAction
		  lp.loginToApp(flib.getDataFromPropertiesFile("username"), flib.getDataFromPropertiesFile("password"));
		  
		  //Leads module
		  HomePage hp=new HomePage(driver);
		  hp.getLeadslink().click();
		  LeadsPage lep=new LeadsPage(driver);
		  lep.getCreateNewLeadsButton().click();
		  
		  //CreateNewLeadButton Module
		  CreatingNewLeadsPage clp=new CreatingNewLeadsPage(driver);
		  clp.getSaveBtn().click();
		  
		  //Alert Handled with passion
		  System.out.println("Warning!!! *Mandatory Field "+wdu.switchToAlertAndGetText(driver));
		  wdu.switchToAlertAndAccept(driver);

		  
		  //Logout
		  hp.logout();
		  driver.quit();
		  
	}
}
