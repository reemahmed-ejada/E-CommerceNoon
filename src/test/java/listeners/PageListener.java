package listeners;

import com.aventstack.extentreports.Status;
import base.BasePage;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;

import static utils.ExtentReportManager.extent;

public class PageListener extends BasePage implements ITestListener, IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 3;
    @Override
    public void onStart(ITestContext context) {
        extent = ExtentReportManager.createInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test passed");
    }

    public void screenShots(){
        // we can add code of screen shot here
    }
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test failed");
        extentTest.log(Status.FAIL, result.getThrowable());

        // Capture screenshot on failure
        String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
        extentTest.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }



        @Override
        public boolean retry(ITestResult result) {
            if (retryCount < maxRetryCount) {
                retryCount++;
                return true;
            }
            return false;
        }

}