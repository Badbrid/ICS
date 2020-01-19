package com.mob.utils.testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/15 16:25
 */
public class ListenerImp implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("##############测试用例\""+iTestResult.getName() + "\"开始执行！##############");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("**************测试用例\""+iTestResult.getName() + "\"执行成功！**************");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("@@@@@@@@@@@@@@测试用例\""+iTestResult.getName() + "\"执行失败！@@@@@@@@@@@@@@");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("%%%%%%%%%%%%%%测试用例\""+iTestResult.getName() + "\"由于某些原因跳过！%%%%%%%%%%%%%%");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
