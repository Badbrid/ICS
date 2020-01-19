package com.mob.testCase.ta.mobpush;

import com.mob.testCase.ta.mobpush.base.MobPush;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/1/17 11:52
 */

public class MobPushCa extends MobPush {

    private static Logger logger = Logger.getLogger(MobPushCa.class);

    @BeforeClass
    public void before() throws MalformedURLException {
        // setp 2
        logger.info("before");
    }

    @Test
    public void test(){
        logger.info("test1");
    }

    @Test
    public void test1(){
        logger.info("test2");
    }


}
