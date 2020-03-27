package test.spring.data.mongodemo.base.api;

import lombok.Data;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/25 20:10
 */
@Data
public class DataResult<T> {
    private Integer code ;
    private T data;
    private String msg;

    public static <T> DataResult<T> success(){
        DataResult<T> dataResult = new DataResult<>();
        dataResult.code = 200;
        return dataResult;
    }

    public static <T> DataResult<T> newSuccess(T data){
        DataResult<T> dataResult = new DataResult<>();
        dataResult.code = 200;
        dataResult.data = data;
        return dataResult;
    }

    public static <T> DataResult<T> newError(Integer code){
        DataResult<T> dataResult = new DataResult<>();
        dataResult.code = code;
        dataResult.msg = "Error";
        return dataResult;
    }

    public static <T> DataResult<T> newError(Integer code,String msg){
        DataResult<T> dataResult = new DataResult<>();
        dataResult.code = code;
        dataResult.msg = msg;
        return dataResult;
    }

    public static <T> DataResult<T> newRequestError(String msg){
        DataResult<T> dataResult = new DataResult<>();
        dataResult.code = 400;
        dataResult.msg = msg;
        return dataResult;
    }
}
