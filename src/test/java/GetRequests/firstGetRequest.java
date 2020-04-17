package GetRequests;
import io.restassured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class firstGetRequest {

    @Test
    public void first_getRequest(){
        Response response = when().get("http://restapi.demoqa.com/utilities/weather/city/chennai");
        System.out.println(response.getStatusCode());
        System.out.println(response.body());
        System.out.println("******************");
        System.out.println(response.prettyPrint());

    }
}
