package Utilities;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {
    public void onStart(ITestContext context) {
        System.out.println("*** Test Suite " + context.getName() + " started ***");
    }

    public void onFinish(ITestContext context) {
        ReportHelper.endTest();
        Reporter.getInstance().flush();
    }

    public void onTestStart(ITestResult result) {
        ReportHelper.startTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        ReportHelper.getTest().log(Status.PASS, "Test passed");
    }

    public void onTestFailure(ITestResult result) {
        ReportHelper.getTest().log(Status.FAIL, "Test Failed");
    }

    public void onTestSkipped(ITestResult result) {
        ReportHelper.getTest().log(Status.SKIP, "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }
}
