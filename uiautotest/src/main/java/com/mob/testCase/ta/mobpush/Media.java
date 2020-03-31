package com.mob.testCase.ta.mobpush;

import com.mob.pages.mobpush.MobPushHome;
import com.mob.pages.mobpush.MobPushInApp;
import com.mob.pages.mobpush.MobPushMedia;
import com.mob.pages.mobpush.MobPushTiming;
import com.mob.testCase.ta.mobpush.base.MobPush;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/30 20:23
 */
public class Media extends MobPush {
    private static Logger logger = Logger.getLogger(Media.class);

    @Test
    public void media(){
        String content = "打开指定链接页面了";
        String url = "https://www.baidu.com/";
        //在首页点击 通知，进入定时通知页面。
        MobPushHome.clickMedia();
        logger.info("在首页点击 打开指定链接页面");
        //传入要跳转的链接
        MobPushMedia.inputUrl(url);
        //填写推送内容
        MobPushMedia.inputContent(content);
        logger.info("传入需要推送得内容"+content);
        //点击测试
        MobPushMedia.clickButton();
        logger.info("点击测试");
        //拉下通知栏
        MobPushHome.pushNotify();
        logger.info("拉下通知栏了");
        //点击通知
        MobPushMedia.notice(content);
        logger.info("点击通知成功了");
        MobPushMedia.clickBack();
        logger.info("点击返回按钮");
    }
}
