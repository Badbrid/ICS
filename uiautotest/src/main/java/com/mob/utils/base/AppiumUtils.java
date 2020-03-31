package com.mob.utils.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.ios.IOSDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/19 12:19
 */
public class AppiumUtils {

    private static Logger logger = Logger.getLogger(AppiumUtils.class);
    public static AndroidDriver<WebElement> androidDriver;
    public static IOSDriver<WebElement> iosDriver;
    public static String platformName;
    public static By by = null;

    public AppiumUtils(AndroidDriver<WebElement> androidDriver ){
        //设置driver为 AndroidDriver
        this.androidDriver = androidDriver;
        this.platformName = "android";
    }

    public AppiumUtils(IOSDriver<WebElement> iosDriver){
        this.iosDriver = iosDriver;
        this.platformName = "ios";
    }

    /**
     * type为定位方法,
     * value为元素值。
     * 返回By
     * @param value 元素名称
     * @return
     */
    public static By getBy(String type,String value){
        if(type.equalsIgnoreCase("ID")){
            by = By.id(value);
        }else if (type.equalsIgnoreCase("name")){
            by = By.xpath("//*[@text='"+value+"']");
        }else if (type.equalsIgnoreCase("xpath")){
            by = By.xpath(value);
        }else {
            by = By.className(value);
        }
        return by;
    }

    /**
     * appium点击操作。
     * id参数为点击。
     * @param id
     */
    public static void click(String type,String id){
        by = getBy(type,id);
        elementExist(by);
        if(platformName.equalsIgnoreCase("android")){
            androidDriver.findElement(by).click();
        }else {
            iosDriver.findElement(by).click();
        }
    }

    public static void input(String type,String id,String content){
        by = getBy(type,id);
        elementExist(by);
        if(platformName.equalsIgnoreCase("android")){
            androidDriver.findElement(by).click();
            androidDriver.findElement(by).sendKeys(content);
        }else {
            iosDriver.findElement(by).click();
            iosDriver.findElement(by).sendKeys(content);
        }
    }

    public static void elementExist(By by){
        if(by == null){
            logger.info("没有找到对应的元素");
            return ;
        }
    }

    public static void pushNotify(){
        androidDriver.openNotifications();
    }

    public static void back(){
        androidDriver.pressKeyCode(4);
    }

//    public static void assertElement(String type, String id){
//        if(platformName.equalsIgnoreCase("android")){
//            if(type.equalsIgnoreCase("ID")){
//                androidDriver.find
//            }else if (type.equalsIgnoreCase("name")){
//                by = By.xpath("//*[@text='"+value+"']");
//            }else if (type.equalsIgnoreCase("xpath")){
//                by = By.xpath(value);
//            }else {
//                by = By.className(value);
//            }
//        }
//    }
}
