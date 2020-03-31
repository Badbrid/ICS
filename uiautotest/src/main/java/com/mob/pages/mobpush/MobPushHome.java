package com.mob.pages.mobpush;

import com.mob.utils.base.AppiumUtils;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/19 18:31
 */
public class MobPushHome {

    /**
     * 在首页点击 APP内推送，进入APP内推送页面。
     */
    public static void clickInApp(){
        AppiumUtils.click("ID","com.mob.mobpush.demo:id/llAppNotify");
    }

    /**
     * 在首页点击通知，进入通知页面。
     */
    public static void clickNotice(){
        AppiumUtils.click("ID","com.mob.mobpush.demo:id/llNotify");
    }

    /**
     * 在首页点击定时通知，进入定时通知页面。
     */
    public static void clickTiming(){
        AppiumUtils.click("ID","com.mob.mobpush.demo:id/llTiming");
    }

    /**
     * 在首页点击本地通知，进入本地通知页面。
     */
    public static void clickLocal(){
        AppiumUtils.click("ID","com.mob.mobpush.demo:id/llLocal");
    }

    /**
     * 在首页点击通过推送打开指定链接页面，进入通过推送打开指定链接页面。
     */
    public static void clickMedia(){
        AppiumUtils.click("ID","com.mob.mobpush.demo:id/llMedia");
    }

    /**
     * 在首页点击推送打开应用内指定页面，进入推送打开应用内指定页面。
     */
    public static void clickOpenAct(){
        AppiumUtils.click("ID","com.mob.mobpush.demo:id/llOpenAct");
    }

    /**
    * 拉下通知栏
    */
    public static void pushNotify(){
        AppiumUtils.pushNotify();
    }
}
