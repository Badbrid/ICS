import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utils.RequestConfig;

import java.util.HashMap;
import java.util.Map;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BaiduLocation {

    @Test
    public void test(){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map1 = new HashMap<>();
//        Map<String,Object> map2 = new HashMap<>();
        map1.put("province","上海市");
        map1.put("city","上海市");
        map1.put("county","徐汇区");
        map1.put("address","龙华路289号");
        map.put("req",map1);
        map.put("productId","Mob-aaa");
        map.put("userId",91);
        map.put("businessId",9);
        map.put("workOrderId",157);

        given().contentType("application/json").params(map).when().post("http://10.21.131.11:10008/market/baidu/location")
                .then().body("lotto.winners.winnerId",hasItems(23,54));
    }



    @Test
    public void test1(){
        Map<String,Object> map = new HashMap<>();
        map.put("paramType","imei14");
        map.put("sourceType","mob");
        map.put("value","86098803545697");
        map.put("productId","Mob-aaa");
        map.put("userId",91);
        map.put("businessId",9);
        map.put("workOrderId",157);

        given().log().all().contentType("application/json").params(map).when().post("http://10.21.131.11:10008/phoneDevice/search/phone")
                .prettyPrint();
    }


    @Test
    public void test2(){
        String jsonStr ="{\n" +
                "  \"paramType\": \"imei14\",\n" +
                "  \"sourceType\": \"mob\",\n" +
                "  \"value\": \"86098803545697\",\n" +
                "  \"productId\": \"Mob-aaa\",\n" +
                "  \"userId\": 91,\n" +
                "  \"businessId\": 9,\n" +
                "  \"workOrderId\": 157\n" +
                "}";
        given().log().all().contentType("application/json").body(jsonStr).when().post("http://10.21.131.11:10008/phoneDevice/search/phone")
                .then().statusCode(200);

    }

    @Test
    public void  test3(){
        String jsonStr ="{\n" +
                "  \"paramType\": \"imei14\",\n" +
                "  \"sourceType\": \"mob\",\n" +
                "  \"value\": \"86098803545697\",\n" +
                "  \"productId\": \"MKTGO_demo\",\n" +
                "  \"userId\": 291,\n" +
                "  \"businessId\": 1,\n" +
                "  \"workOrderId\": 159\n" +
                "}";

        RequestConfig.setHttpURLandPortValue("http://10.21.131.11",10008);
        Response response = RequestConfig.setPost(jsonStr,"/phoneDevice/search/phone");
        response.then().log().all().body("data.value",equalTo("13367333220"));
    }
}
