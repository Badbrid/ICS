package com.mob.pages.mobpush;

import com.mob.utils.base.AppiumUtils;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/21 12:05
 */
public class MobPushUtil {
    //回到首页
    public static void clickReturn(){
        AppiumUtils.click("ID","com.mob.demo.mobpush:id/ivBack");
    }
}
