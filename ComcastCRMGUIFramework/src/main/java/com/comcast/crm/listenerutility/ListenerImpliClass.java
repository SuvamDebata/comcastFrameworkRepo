package com.comcast.crm.listenerutility;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.generic.webdriverutility.UtilityClassObject;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class ListenerImpliClass implements ITestListener, ISuiteListener {
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	WebDriverUtility wdu = new WebDriverUtility();
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		//Spark Report config
		spark= new ExtentSparkReporter("./AdvanceReport/report"+wdu.getCurrentTimeStamp()+".html");
		spark.config().setDocumentTitle("CRM TestScript Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//Add Environment Info and create Test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "CHROME-11");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);	
		//Save Report
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test= report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"=====> STARTED <=====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		String timeStamp=wdu.getCurrentTimeStamp();
		String testName=result.getMethod().getMethodName()+ timeStamp;
		try {
			test.addScreenCaptureFromPath(wdu.takeScreenShotForReport(UtilityClassObject.getDriver(),testName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.PASS, result.getMethod().getMethodName()+"=====> COMPLETED <=====");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		
		
		String timeStamp=wdu.getCurrentTimeStamp();
		String testName=result.getMethod().getMethodName()+ timeStamp;
		try {
			test.addScreenCaptureFromPath(wdu.takeScreenShotForReport(UtilityClassObject.getDriver(),testName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getMethod().getMethodName()+"=====> FAILED <=====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		//test.log(Status.SKIP, result.getMethod().getMethodName()+"=====> SKIPPED <=====");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}



}
