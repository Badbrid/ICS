package com.mob.testCase.ta.mobpush;

import com.mob.pages.mobpush.MobPushHome;
import com.mob.pages.mobpush.MobPushLocal;
import com.mob.pages.mobpush.MobPushTiming;
import com.mob.testCase.ta.mobpush.base.MobPush;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/30 20:22
 */
public class Local extends MobPush {
    private static Logger logger = Logger.getLogger(Local.class);

    @Test
    public void local() {
        String content = "本地通知了";
        String time = "立即";
        //从首页点击 本地通知
        MobPushHome.clickLocal();
        logger.info("在首页点击 本地通知");
        //填写推送内荣
        MobPushLocal.inputContent(content);
        logger.info("传入需要推送得内容"+content);
        //选择立即推送
        MobPushLocal.selectTime(time);
        logger.info("选择立即推送");
        //点击测试
        MobPushLocal.clickButton();
        logger.info("点击测试");
        //拉下通知栏
        MobPushHome.pushNotify();
        logger.info("拉下通知栏了");
        //点击通知
        MobPushLocal.notice(content);
        logger.info("点击通知成功了");
    }


}
