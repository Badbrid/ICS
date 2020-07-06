package com.example.liang.setting.controller.response;

import lombok.Data;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/6/28 14:32
 */
@Data
public class DataResult {
    // 描述信息
    private String message;
    // 请求是否成功
    private boolean success;
    // 返回数据
    private Object data;

    public DataResult(){
        this.success = true;
    }

    public DataResult(Object data){
        this.success = true;
        this.data = data;
    }

    public DataResult(boolean success , String msg){
        this.success = success;
        this.message = msg;
    }

    public DataResult(boolean success , String msg , Object data){
        this.message = msg;
        this.success = success;
        this.data = data;
    }

    public static DataResult success(Object object){
        return new  DataResult(object);
    }

    public static DataResult error(String message){
        return new DataResult(false, message, null);
    }

    public static DataResult error(String message, Object object){
        return new DataResult(false,message,object);
    }


}
