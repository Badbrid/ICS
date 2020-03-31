package com.mob.pages.mobpush;

import com.mob.pages.mobpush.base.PushOperating;
import com.mob.utils.base.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/20 9:38
 */
public class MobPushTiming extends PushOperating {
    public static WebDriverWait webDriverWait;

    public static void timingClickNotice(AndroidDriver androidDriver ,String content){
        Long start = System.currentTimeMillis();
        webDriverWait = new WebDriverWait(androidDriver, 65000);
        WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@text='"+content+"']")
                )
        );
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
        webElement.click();
    }
}
