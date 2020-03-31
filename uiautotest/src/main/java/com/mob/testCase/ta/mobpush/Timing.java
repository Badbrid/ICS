package com.mob.testCase.ta.mobpush;

import com.mob.pages.mobpush.MobPushHome;
import com.mob.pages.mobpush.MobPushNotice;
import com.mob.pages.mobpush.MobPushTiming;
import com.mob.testCase.ta.mobpush.base.MobPush;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/30 20:22
 */
public class Timing extends MobPush {
    private static Logger logger = Logger.getLogger(Timing.class);

    @Test
    public void timing(){
        String content = "定时推送通知拉";
        //在首页点击 通知，进入定时通知页面。
        MobPushHome.clickTiming();
        logger.info("在首页点击 定时通知");
        //填写推送内荣
        MobPushTiming.inputContent(content);
        logger.info("传入需要推送得内容"+content);
        //点击测试
        MobPushTiming.clickButton();
        logger.info("点击测试");
        //拉下通知栏
        MobPushHome.pushNotify();
        logger.info("拉下通知栏了");
        //点击通知
        MobPushTiming.timingClickNotice(androidDriver,content);
        logger.info("点击通知成功了");
    }
}
