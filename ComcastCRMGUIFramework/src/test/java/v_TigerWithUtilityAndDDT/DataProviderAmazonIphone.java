package v_TigerWithUtilityAndDDT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.generic.fileutility.ExcelUtility;

public class DataProviderAmazonIphone {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandname, String productname)throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.in");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		
		//capture product info
		String x="//span[text()='"+productname+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]";
		String price =driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility xlib = new ExcelUtility("C:\\Users\\suvam\\OneDrive\\Desktop\\GU_Automatication.xlsx");
		int rowcount=xlib.getRowCount("product");
		
		Object[][] objarr=new Object[rowcount][2];
		for(int i=0;i<rowcount;i++)
		{
			objarr[i][0]=xlib.getDataFromExcel("product", i+1, 0);
			objarr[i][1]=xlib.getDataFromExcel("product", i+1, 1);
		}
		
		return objarr;
	}
}
