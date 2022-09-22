package Testcases;

import AutomationCore.Baseclass;
import Utilities.ExtentReportNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Baseclass implements ITestListener {
    ExtentTest test;
    ExtentReports extent= ExtentReportNG.getReportObject();
    ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
    @Override
    public void onTestStart(ITestResult result) {
        //ITestListener.super.onTestStart(result);
        test=extent.createTest(result.getMethod().getMethodName());
        extenttest.set(test);

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        //System.out.println("test case passed");
        //ITestListener.super.onTestSuccess(result);
        extenttest.get().log(Status.PASS,"Test pass");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        // ITestListener.super.onTestFailure(result);
        //System.out.println("test case failed");
        extenttest.get().fail(result.getThrowable());
        String testmethodname=result.getMethod().getMethodName();
        try {
            driver =(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            extenttest.get().addScreenCaptureFromPath(getScreenshotPath(testmethodname,driver), result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        extenttest.get().log(Status.FAIL,"Test Fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extenttest.get().log(Status.SKIP,"Test skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

    }
}
