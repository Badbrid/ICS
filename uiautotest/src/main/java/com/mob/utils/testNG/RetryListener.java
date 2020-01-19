package com.mob.utils.testNG;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/15 16:05
 */
public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        IRetryAnalyzer iRetryAnalyzer = iTestAnnotation.getRetryAnalyzer();
        if(null == iRetryAnalyzer){
            iTestAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
        }
    }
}
