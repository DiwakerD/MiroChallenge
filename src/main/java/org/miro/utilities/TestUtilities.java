package org.miro.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import org.miro.pages.PageClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class TestUtilities  {
	public static final String REPORTS = "\\Report.html";
	public static final String SCREENSHOT_MESSAGE = "ScreenShot Attached";
	public static final String STEP_INFORMATION = "Step Description :";
	public static final String EXECUTION_STATUS_MESSAGE = "Execution % -";
	public static final String USER_DIRECTORY=System.getProperty("user.dir");


	public ExtentReports extentTest() {
		ExtentSparkReporter html=new ExtentSparkReporter(USER_DIRECTORY+ REPORTS);
		html.config().setEncoding("utf-8");
		html.config().setDocumentTitle("AUTOMATION REPORT");
		html.config().setReportName("Automation Test Results");
		html.config().setTheme(Theme.DARK);
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(html);
		extent.setSystemInfo("Project","Miro QA Assignment");
		extent.setSystemInfo("Environment", "Miro Dashboard");
		extent.setSystemInfo("Team","Diwaker Dutta");
		return extent;
		
	}

	public void checkResultsAndValidate(ITestResult result, ExtentTest test, PageClass page, WebDriver driver) throws IOException {
		ExtentTest node = test.createNode(result.getMethod().getMethodName());
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getThrowable().getMessage());
			node.fail(result.getThrowable().fillInStackTrace());
			node.info(TestUtilities.SCREENSHOT_MESSAGE, MediaEntityBuilder.createScreenCaptureFromBase64String(page.takeScreenshot(driver)).build());

		} else if (result.getStatus() == ITestResult.SKIP) {
			node.skip(MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.YELLOW));
			node.info(result.getThrowable().getMessage());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			node.info(STEP_INFORMATION+result.getMethod().getDescription());
			node.info(TestUtilities.EXECUTION_STATUS_MESSAGE + result.getMethod().getSuccessPercentage());
			node.info(TestUtilities.SCREENSHOT_MESSAGE, MediaEntityBuilder.createScreenCaptureFromBase64String(page.takeScreenshot(driver)).build());
		}
	}

	public Iterator<Object[]> getUserDetails() {
		try {
			Faker faker = new Faker(new Locale("de"));
			List<Object[]> myData = new ArrayList<>();
			String name=faker.name().firstName();
				Object[] ob = {name, name+faker.number().digits(5)+"@gmail.com"};
				myData.add(ob);
			return myData.iterator();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}


	}



}
