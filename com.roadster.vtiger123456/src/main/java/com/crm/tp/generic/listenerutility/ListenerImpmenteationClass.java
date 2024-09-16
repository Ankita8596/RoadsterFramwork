package com.crm.tp.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.tp.baseutility.BaseClass;

public class ListenerImpmenteationClass implements ISuiteListener,ITestListener {
	public ExtentReports report;
	public ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		//ExtentReports report;
		System.out.println("report configuration");
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/reports.html");
		spark.config().setDocumentTitle("CRM suite result");
		spark.config().setReportName("CRM report name");
		spark.config().setTheme(Theme.DARK);
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "Chrome-100");
	}
	@Override
    public void onFinish(ISuite suite) {
    	System.out.println("report backup");
    	report.flush();
    }
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===="+result.getMethod().getMethodName()+"=====>START=====");
		test=report.createTest("===="+result.getMethod().getMethodName());
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("====="+result.getMethod().getMethodName()+"=====END=====");
		test.log(Status.INFO, result.getMethod().getMethodName()+"=======COMPLETED======");
	}
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		TakesScreenshot edriver = (TakesScreenshot)BaseClass.sdriver;
		String filepath = edriver.getScreenshotAs(OutputType.BASE64);
		 String time=new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath,testName+"_"+time);
		test.log(Status.INFO, result.getMethod().getMethodName()+"======Failure====");
	}
	
}
