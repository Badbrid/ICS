package com.mob.utils.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/31 15:49
 */
public class Asserts {

    public static Boolean textExist(AppiumDriver driver , String content){
        boolean result = false;
        List<WebElement> textViews = driver.findElementsByClassName("android.widget.TextView");
        Iterator iterator = textViews.iterator();
        while (iterator.hasNext()){
            WebElement webElement = (WebElement) iterator.next();
            String textView = webElement.getText();
            if(textView.contains(content)){
                result = true;
                return result;
            }
        }
        return result;
    }
}
