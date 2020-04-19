package GetRequests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured.*;
import org.testng.annotations.Test;

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


    @Test
    public void test_02(){
        String response = given().param("id","2172797").
                param("appid","673c5650a20311041c26d61291b186ae").when().
                get(OPEN_WEATHER_BASE_URL).then().
                contentType(ContentType.JSON).extract().path("weather[0].description");

        System.out.println("Weather Report :"+response);
    }
}


