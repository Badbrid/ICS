package com.mob.pages.mobpush;

import com.mob.pages.mobpush.base.PushOperating;
import com.mob.utils.base.AppiumUtils;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/20 9:54
 */
public class MobPushOpenAct extends PushOperating {
    public static void clickBack(){
        AppiumUtils.click("ID","com.mob.mobpush.demo:id/ivBack");
        AppiumUtils.click("ID","com.mob.mobpush.demo:id/ivBack");
    }
}
