package com.sv.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {



	public void onTestFailure(ITestResult result) {
	System.out.println("Test case Failed :" + result.getName());
		
	}


	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test case Skipped :" + result.getName());
	}


	public void onTestStart(ITestResult result) {
		System.out.println("Test case started on :" + result.getName());
		
	}


	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case success :" + result.getName());
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test case Failed But within SuccessPercentage:" + result.getName());
	}


	public void onFinish(ITestContext result) {
		System.out.println("Test case finished within SuccessPercentage:" + result.getName());
		
	}


	public void onStart(ITestContext result) {
		System.out.println("Test case start :" + result.getName());
	}

}
