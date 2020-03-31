package com.mob.pages.mobpush;

import com.mob.pages.mobpush.base.PushOperating;
import com.mob.utils.base.AppiumUtils;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/20 9:38
 */
public class MobPushLocal extends PushOperating {

    public static void selectTime(String time){
        AppiumUtils.click("name",time);
    }
}
