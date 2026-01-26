package Listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private final static Logger logger = LogManager.getLogger(TestListener.class);

    public void onTestStart(ITestResult result) {
       logger.info("Starting test: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: " + result.getName());
    }
}
