package com.mob.testCase.ta.mobpush;

import com.mob.pages.mobpush.MobPushHome;
import com.mob.pages.mobpush.MobPushInApp;
import com.mob.pages.mobpush.MobPushNotice;
import com.mob.pages.mobpush.MobPushOpenAct;
import com.mob.testCase.ta.mobpush.base.MobPush;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/30 20:23
 */
public class OpenAct extends MobPush {
    private static Logger logger = Logger.getLogger(OpenAct.class);

    @Test
    public void openAct(){
        String content = "打开应用内指定页面";
        //在首页点击 通知，进入通知页面。
        MobPushHome.clickOpenAct();
        logger.info("在首页点击 打开应用内指定页面");
        //填写推送内荣
        MobPushOpenAct.inputContent(content);
        logger.info("传入需要推送得内容"+content);
        //点击测试
        MobPushOpenAct.clickButton();
        logger.info("点击测试");
        //拉下通知栏
        MobPushHome.pushNotify();
        logger.info("拉下通知栏了");
        //点击通知
        MobPushOpenAct.notice(content);
        logger.info("点击通知成功了");
        MobPushOpenAct.clickBack();
        logger.info("点击返回按钮");

    }
}
