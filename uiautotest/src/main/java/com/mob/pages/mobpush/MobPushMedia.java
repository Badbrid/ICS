package com.mob.pages.mobpush;

import com.mob.pages.mobpush.base.PushOperating;
import com.mob.utils.base.AppiumUtils;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/20 9:39
 */
public class MobPushMedia extends PushOperating {

    public static void inputUrl(String url){
        AppiumUtils.input("ID","com.mob.mobpush.demo:id/url",url);
    }

    public static void clickBack(){
//        AppiumUtils.click("class","android.widget.ImageView");
        AppiumUtils.back();
    }
}
