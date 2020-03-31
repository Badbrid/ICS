package com.mob.pages.mobpush;

import com.mob.pages.mobpush.base.PushOperating;
import com.mob.utils.base.AppiumUtils;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/19 18:44
 */
public class MobPushInApp extends PushOperating {


    public static void clickNoticeButton(){

        AppiumUtils.click("ID","com.mob.mobpush.demo:id/btnKnown");

    }
}
