package v_TigerWithUtilityAndDDT;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class TestScript_System_1 
{
	@Test
	public void  testScript_Functional() throws IOException, InterruptedException
	//public static void main(String[] args) throws Throwable 
	{
		ExcelUtility xlib= new ExcelUtility("C:\\Users\\suvam\\OneDrive\\Desktop\\GU_Automatication.xlsx");
		FileUtility flib= new FileUtility("C:\\Users\\suvam\\eclipse-workspace\\ComcastCRMGUIFramework\\configAppData\\commondata.properties");
		WebDriverUtility wdu=new WebDriverUtility();
		//JavaUtility ju=new JavaUtility();
		
		
		WebDriver driver=wdu.openBrowser(flib.getDataFromPropertiesFile("Browser"));
		
	   //Login 
		  //Login 
		 LoginPage lp=new LoginPage(driver);
		  lp.loginToApp(flib.getDataFromPropertiesFile("username"), flib.getDataFromPropertiesFile("password"));
		
	  //Campaign module		
		HomePage hp=new HomePage(driver);
		hp.navigateToCampaignPage();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();	
		String campagin=xlib.getDataFromExcel("org", 16, 2);
		driver.findElement(By.name("campaignname")).sendKeys(campagin);
		wdu.select(driver.findElement(By.name("assigned_user_id")), " Administrator");
		driver.findElement(By.name("closingdate")).clear();
		driver.findElement(By.name("closingdate")).sendKeys(wdu.getRequiredDate("yyyy-MM-dd",30));
		Thread.sleep(5000);
		wdu.takeScreenShot(driver, "date1.png");
		wdu.takeElementScreenShot(driver.findElement(By.name("closingdate")), "dateElm.png");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
					  
	  //Search Campaign by name
		driver.findElement(By.xpath("(//a[text()='Campaigns'])[1]")).click();
		driver.findElement(By.name("search_text")).sendKeys(campagin);
		wdu.select(driver.findElement(By.id("bas_searchfield")), "Campaign Name");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
	  //Leads module
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();	  
		String lastName=xlib.getDataFromExcel("org", 16, 3);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		String CoName=xlib.getDataFromExcel("org", 16, 4);
		driver.findElement(By.name("company")).sendKeys(CoName);
		Select selobj1=new Select(driver.findElement(By.name("assigned_user_id")));
		selobj1.selectByVisibleText(" Administrator");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		 
	  //Search Lead by Company
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.name("search_text")).sendKeys(CoName);
		wdu.select(driver.findElement(By.id("bas_searchfield")), "Company");
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[1]")).click();
 
	  //Logout
		  hp.logout();
		
	  driver.quit();
					 

	}

}
