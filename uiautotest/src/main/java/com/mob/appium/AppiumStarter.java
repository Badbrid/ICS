package com.mob.appium;

import com.mob.utils.base.Tools;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;


/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/15 12:20
 */
public abstract class AppiumStarter {
    private static Logger logger = Logger.getLogger(AppiumStarter.class);
    private DesiredCapabilities desiredCapabilities;
    private static String platformName; //平台名称
    private static String deviceName; //设备名称(可以是假的)
    private static String appPackage; //安卓应用包名
    private static String appActivity; //安卓activity类
    private String androidUid = Tools.getRandomAndroidDeviceId(); //安卓设备Uid(不能是假的)
    private String platformVersion = Tools.getDeviceRelease(androidUid); //安卓设备平台版本
    protected AppiumDriver driver;
    protected String testCaseName = "";
    private static String appPath;
    private static String appiumURL;    // "http://127.0.0.1:4723/wd/hub";//appium 服务URL地址


    public void appiumStarter() {
        String yamlName = yaml();
        Map<String, String> map = Tools.getYaml(yamlName+".yaml");
        platformName = map.get("platformName");
        deviceName = map.get("deviceName");
        appPackage = (String) map.get("appPackage");
        appActivity = (String) map.get("appActivity");
        appPath = Tools.appPath(yamlName+".apk");
        appiumURL = "http://" + Tools.getLocalIpAddr() + ":4723/wd/hub";
    }

    protected abstract String yaml();

    @BeforeSuite
    public void beforeSelf() throws MalformedURLException {
        logger.info("开始创建drvier实例 ...");
        appiumStarter();
        //设置Desired Capabilities相关参数
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("deviceName", deviceName);
        //设置安卓系统uid
        desiredCapabilities.setCapability("udid", androidUid);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        //配置apk文件
        desiredCapabilities.setCapability("app", appPath);
        //设置app的主包名和主类名
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("unicodeKeyboard", true);
        desiredCapabilities.setCapability("resetKeyboard", true);
        desiredCapabilities.setCapability("noReset", true);

        driver = new AndroidDriver(new URL(appiumURL), desiredCapabilities);
        logger.info("已经创建完drvier实例 ...");
    }

    @AfterSuite
    public void after() {
        logger.info("自动化测试" + testCaseName + "结束。");
        if (driver == null) {
            return;
        }
        driver.quit();
    }
}
