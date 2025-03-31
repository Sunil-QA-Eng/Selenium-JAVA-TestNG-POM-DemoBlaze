package com.demoblaze.customlisteners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by Sunil Suhagiya
 */
public class RetryAnalyzerImpl implements IRetryAnalyzer {
    private static final int MAX_RETRY = 2;
    private int actualRetry = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (actualRetry < MAX_RETRY) {
                actualRetry++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}

