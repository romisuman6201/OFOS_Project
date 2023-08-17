package com.ofos1.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// Execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName + "=======Testscript Execution started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"====>Passed");
		Reporter.log(MethodName + "=======Testscript Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String Fscript = result.getMethod().getMethodName();
		String FailedScript=Fscript+new JavaUtility().getSystemDateFormat();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+FailedScript+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, Fscript+"--->failed");
		test.log(Status.FAIL, result.getThrowable());
		
		Reporter.log(Fscript+"=======Testscript failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,MethodName+"=====>skipped");
		test.log(Status.SKIP,result.getThrowable());

	}

	@Override
	public void onStart(ITestContext context) {
		// Create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("OFOS2");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Online Food Order System");

		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-url", "http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/index.php");
		report.setSystemInfo("reporter-Name", "sumant kumar");

	}

	@Override
	public void onFinish(ITestContext context) {

		
		//consolidate the report
		report.flush();
	}

}
