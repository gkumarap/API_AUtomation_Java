package GetRequests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static GetRequests.commons.OPEN_WEATHER_BASE_URL;
import static io.restassured.RestAssured.given;

public class openWeatherMap_api {

    @Test
    public void test_01(){
        Response response = given().param("id","2172797").
                param("appid","673c5650a20311041c26d61291b186ae").when().
                get("http://api.openweathermap.org/data/2.5/weather");
        System.out.println(response.asString());
        System.out.println(response.prettyPeek());
        System.out.println("\n"+response.prettyPrint());


    }


    @Test(enabled = false)
    public void test_02(){
        String response = given().param("id","2172797").
                param("appid","673c5650a20311041c26d61291b186ae").when().
                get(OPEN_WEATHER_BASE_URL).then().
                contentType(ContentType.JSON).extract().path("weather[0].description");

        System.out.println("Weather Report :"+response);
    }


    @Test(invocationCount = 2)
    public void test_03(){
        Map payload = new HashMap();
        payload.put("id","2172797");
        payload.put("appid","673c5650a20311041c26d61291b186ae");

        Response resp = given().params(payload).when().get(OPEN_WEATHER_BASE_URL);
//        System.out.println(resp.prettyPrint());
        String longitude = String.valueOf(resp.then().contentType(ContentType.JSON).extract().path("coord.lon"));
        System.out.println(longitude+"--longitude");


        String latitude = String.valueOf(resp.then().contentType(ContentType.JSON).extract().path("coord.lat"));
        System.out.println(latitude +"-- latitude");

        Map payload_latitude = new HashMap();
        payload_latitude.put("appid","673c5650a20311041c26d61291b186ae");
        payload_latitude.put("lat",latitude);
        payload_latitude.put("lon",longitude);

        String weatherByOtherApiCalls = given().params(payload_latitude).when().get(OPEN_WEATHER_BASE_URL).then().
                contentType(ContentType.JSON).extract().path("weather[0].description");

        System.out.println(weatherByOtherApiCalls);
    }
}


