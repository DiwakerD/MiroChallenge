package org.miro.testClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.miro.pages.BasePage;
import org.miro.pages.LoginPage;
import org.miro.pages.PageClass;
import org.miro.utilities.TestUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public PageClass page;
    public ExtentTest test;
    public static TestUtilities Utility=new TestUtilities();
    public static ExtentReports extent;
    protected LoginPage loginPage;


    @BeforeSuite
    public void setupUtilityAndReport(){
        extent = Utility.extentTest();
    }

    @BeforeTest()
    public void driverSetup(XmlTest name ) throws IOException {
        test = extent.createTest(name.getName());
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(PageClass.EXPLICITWAIT));
        page = new BasePage(driver, wait);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PageClass.PAGELOADTIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(page.getImplicitwait()));
        driver.get(page.getProp().getProperty("URL"));
    }

    @DataProvider
    public Iterator<Object[]> getUserData() {
        return Utility.getUserDetails();
    }

    @AfterMethod
    public void verifyResultsAndAddToReport(ITestResult result) throws IOException {
        //Updating Results in Report
        Utility.checkResultsAndValidate(result,test, page,driver);
    }

    @AfterTest
    public void closingDriverSession() {
        //Closing the Driver Sessions
        driver.quit();
    }


    @AfterSuite
    public void closingReportSession() {
        //Closing Execution Report
        extent.flush();
    }

}
