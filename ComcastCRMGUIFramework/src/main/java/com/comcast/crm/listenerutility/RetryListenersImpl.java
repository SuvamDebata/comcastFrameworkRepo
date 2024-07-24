package com.comcast.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenersImpl implements IRetryAnalyzer{

	int count=0;
	int limitCount=0;
	public boolean retry(ITestResult result) {
		if(count<limitCount) {
			count++;
			return true;
		}
		return false;
		
	}
}
