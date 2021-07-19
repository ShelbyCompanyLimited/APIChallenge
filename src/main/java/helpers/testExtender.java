package helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;

public class testExtender {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public ExtentTest test;
    public static String reportDestination = System.getProperty("user.dir") + "\\ExtentReports\\ExtentReportNEW.html";
    protected final Logger logger = LogManager.getLogger(getClass());

    @BeforeTest(alwaysRun = true)
    public void beforeTest() throws IOException {

    }

    @BeforeSuite
    public void createReqSpec() throws IOException {

        RestAssured.authentication = RestAssured.preemptive().basic("","");
        System.out.println("THis is happening before test");
        extentReport();

    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();

    }

    public void extentReport() throws IOException {

        htmlReporter = new ExtentHtmlReporter(reportDestination);
        ReadFromPom readFromPom = new ReadFromPom();
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Environment", readFromPom.getPropertyFomPom("Environment"));
        extent.setSystemInfo("Base URL", readFromPom.getPropertyFomPom("BaseURL"));
        extent.setSystemInfo("User Name", "Test Username - Need to be defined");
        extent.setSystemInfo("User Email", "Test Username - Need to be defined");


        htmlReporter.config().setDocumentTitle("Automation Testing Report");
        htmlReporter.config().setReportName("Automation Test Suite");
        htmlReporter.config().setTheme(Theme.DARK);

    }
}
