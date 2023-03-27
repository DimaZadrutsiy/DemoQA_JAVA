package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private int maxRetryCount = 3; // default retry count

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            try {
                TimeUnit.SECONDS.sleep(5); // add a delay between retries
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            retryCount++;
            Reporter.log("Retrying test method " + result.getMethod().getMethodName() + " for the " + retryCount + " time.", true);
            return true;
        }
        return false;
    }
}

