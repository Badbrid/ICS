package com.mob.testCase.ta.mobpush.base;

import com.mob.appium.AppiumStarter;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/19 11:49
 */
public class MobPush extends AppiumStarter {


    /*
    *  新建项目都要继承AppiumStarter，
    *  重写yaml方法，放入自己的项目配置文件
    * @return 自己的项目名称
    */

    @Override
    protected String yaml() {
        return "mobpush";
    }


}
