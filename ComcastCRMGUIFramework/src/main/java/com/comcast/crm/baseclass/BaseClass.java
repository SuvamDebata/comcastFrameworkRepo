package com.comcast.crm.baseclass;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.generic.databaseutility.DatabaseUtility;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.comcast.generic.webdriverutility.UtilityClassObject;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class BaseClass {

	public WebDriverUtility wdu = new WebDriverUtility();
	public ExcelUtility xlib = new ExcelUtility("C:\\Users\\suvam\\OneDrive\\Desktop\\GU_Automatication.xlsx");
	public FileUtility flib = new FileUtility("C:\\Users\\suvam\\eclipse-workspace\\ComcastCRMGUIFramework\\configAppData\\commondata.properties");
	public DatabaseUtility dlib = new DatabaseUtility();
	public WebDriver driver = null;
	public SoftAssert assertobj=new SoftAssert();

	@BeforeSuite
	public void configBS() throws Throwable {
		System.out.println("====connect to DB, Report Config====");
		dlib.getDbConnection();
	}

	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("=====Launch the browser=======");
		driver = wdu.openBrowser(flib.getDataFromPropertiesFile("Browser"));
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod
	public void configBM() throws Throwable {
		driver.get(flib.getDataFromPropertiesFile("url"));
		System.out.println("===Login====");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(flib.getDataFromPropertiesFile("username"), flib.getDataFromPropertiesFile("password"));
	}

	@AfterMethod
	public void configAM() {
		System.out.println("===Logout====");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass
	public void configAC() {
		System.out.println("======Close the Browser========");
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() throws SQLException {
		System.out.println("=====close DB, Report backup=====");
		dlib.closeDbConnection();
	}

}
