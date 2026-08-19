package com.appium.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.appium.driver.DriverFactory;
import com.appium.utils.ExtentReportManager;
import com.appium.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    private static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentReportManager.getReport()
                .createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed: " + result.getThrowable());

        try {

            String testName = result.getMethod().getMethodName();

            String screenshotPath = ScreenshotUtils.captureScreenshot(
                    DriverFactory.driver,
                    testName
            );

            test.addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {

            test.fail("Screenshot could not be captured: " + e.getMessage());

        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.getReport().flush();
    }
}