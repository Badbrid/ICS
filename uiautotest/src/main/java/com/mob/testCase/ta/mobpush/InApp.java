package com.mob.testCase.ta.mobpush;

import com.mob.pages.mobpush.MobPushHome;
import com.mob.pages.mobpush.MobPushInApp;
import com.mob.pages.mobpush.MobPushUtil;
import com.mob.testCase.ta.mobpush.base.MobPush;
import com.mob.utils.base.Asserts;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.Reader;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/20 16:23
 */
public class InApp extends MobPush {

    private static Logger logger = Logger.getLogger(InApp.class);

    @Test
    public void inApp(){
        String content = "透传消息啦";
        //在首页点击 APP内推送，进入APP内推送页面。
        MobPushHome.clickInApp();
        logger.info("在首页点击 APP内推送");
        //传入需要推送得内容，string类型。
        MobPushInApp.inputContent(content);
        logger.info("传入需要推送得内容"+content);
        //点击“点击测试”，点击后发送推送
        MobPushInApp.clickButton();
        logger.info("点击测试");
        //点击我知道了
        MobPushInApp.clickNoticeButton();
        logger.info("点击我知道了");
        MobPushInApp.clickReturn();
        logger.info("点击返回按钮");
        Boolean result = Asserts.textExist(androidDriver,"选择你想测试的推送类型");
        Assert.assertTrue(result,"校验测试结果：验证返回了首页。");
        logger.info("校验测试结果：验证返回了首页。" + result);
    }
}
