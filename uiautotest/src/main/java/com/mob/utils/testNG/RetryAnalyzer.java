package com.mob.utils.testNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/15 16:03
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private final int MAX_RETRY_COUNT = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount < MAX_RETRY_COUNT){
            retryCount++;
            return true;
        }
        return false;
    }
}
