package com.mob.testCase.ta.mobpush;

import com.mob.pages.mobpush.MobPushHome;
import com.mob.pages.mobpush.MobPushNotice;
import com.mob.pages.mobpush.MobPushUtil;
import com.mob.testCase.ta.mobpush.base.MobPush;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/21 11:55
 */
public class Notice extends MobPush {
    private static Logger logger = Logger.getLogger(Notice.class);

    @Test
    public void androidNotify(){
        String content = "推送通知拉";
        //在首页点击 通知，进入通知页面。
        MobPushHome.clickNotice();
        logger.info("在首页点击 通知");
        //填写推送内荣
        MobPushNotice.inputContent(content);
        logger.info("传入需要推送得内容"+content);
        //点击测试
        MobPushNotice.clickButton();
        logger.info("点击测试");
        //拉下通知栏
        MobPushHome.pushNotify();
        logger.info("拉下通知栏了");
        //点击通知
        MobPushNotice.notice(content);
        logger.info("点击通知成功了");
    }
}
