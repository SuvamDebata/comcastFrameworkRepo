package v_TigerWithUtilityAndDDT;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.CreateNewVendorsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.VendorsPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class TestScript_Integration_2 {
	@Test
	public void  testScript_Functional() throws IOException {

	//public static void main(String[] args) throws Throwable {
		
		ExcelUtility xlib= new ExcelUtility("C:\\Users\\suvam\\OneDrive\\Desktop\\GU_Automatication.xlsx");
		FileUtility flib= new FileUtility("C:\\Users\\suvam\\eclipse-workspace\\ComcastCRMGUIFramework\\configAppData\\commondata.properties");
		WebDriverUtility wdu=new WebDriverUtility();
		//JavaUtility ju=new JavaUtility();
		
		
		WebDriver driver=wdu.openBrowser(flib.getDataFromPropertiesFile("Browser"));
		driver.get(flib.getDataFromPropertiesFile("url"));
		
		//Login 
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(flib.getDataFromPropertiesFile("username"), flib.getDataFromPropertiesFile("password"));
		  
		//Vendors module
		 HomePage hp=new HomePage(driver);
		 hp.navigateToVendorPage();
		 VendorsPage vp=new VendorsPage(driver);
		 vp.getCreateNewVenButton().click();
		 CreateNewVendorsPage cvp= new CreateNewVendorsPage(driver);
		 String vender=xlib.getDataFromExcel("org", 13, 2);
		 cvp.getvendorNameEdit().sendKeys(vender);
		 String phoneNo=xlib.getNumDataFromExcel("org", 13, 3);
		 cvp.getphoneNoEdit().sendKeys(phoneNo);
		 cvp.getsaveBtn().click();
		 
		//Search vendor by phone number
		 hp.getVendorslink().click();
		 vp.getSearchtextEdit().sendKeys(phoneNo);
		 wdu.select(vp.getSearchDd(), "Phone");
		 vp.getsearchBtn().click();
		 
		//Logout
		 hp.logout();
		  
		 driver.quit();
		
	}

}
