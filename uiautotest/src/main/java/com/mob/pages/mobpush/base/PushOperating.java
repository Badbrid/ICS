package com.mob.pages.mobpush.base;

import com.mob.utils.base.AppiumUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.ApplicationContext;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/30 20:30
 */
public class PushOperating {
    //通知内容
    public static void inputContent(String content){
        AppiumUtils.input("ID","com.mob.mobpush.demo:id/etContent",content);
    }
    //点击测试
    public static void clickButton(){
        AppiumUtils.click("ID","com.mob.mobpush.demo:id/btnTest");
    }
    //点击通知
    public static void notice(String content){
        AppiumUtils.click("name",content);
    }
    //回到首页
    public static void clickReturn(){
        AppiumUtils.click("ID","com.mob.mobpush.demo:id/ivBack");
    }

}
