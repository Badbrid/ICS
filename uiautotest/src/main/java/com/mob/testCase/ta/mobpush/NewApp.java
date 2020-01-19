package com.mob.testCase.ta.mobpush;

import com.mob.testCase.ta.mobpush.base.MobPush;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/17 12:24
 */
public class NewApp extends MobPush {
    private static Logger logger = Logger.getLogger(NewApp.class);

    @Test
    public void test(){

        logger.info("NewApp1");
    }

    @Test
    public void test1(){
        logger.info("NewApp2");
    }

}
