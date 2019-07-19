package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RequestConfig {

    //设置请求的地址和端口号
    public static void setHttpURLandPortValue(String url,int port){
        RestAssured.baseURI=url;
        RestAssured.port=port;
    }

    //发送post请求
    public static Response setPost(String jsonUrl,String url){
        return RestAssured.given().log().all().contentType("application/json").body(jsonUrl).when().post(url);
    }

    public static Response setPost(String jsonUrl,String url,String contentType){
        return RestAssured.given().log().all().contentType(contentType).body(jsonUrl).when().post(url);
    }
}
