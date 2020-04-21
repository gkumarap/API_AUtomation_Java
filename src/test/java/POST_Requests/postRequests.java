package POST_Requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


/**
 * pre requisite : install json server to run this post requests...
 *
 * follow it here : https://github.com/typicode/json-server
 *
 * step 1: install npm
 * step install json server
 * step 3: create a db.json file .
 * step 4: start json server.
 *
 */
public class postRequests {

    @Test
    public void test_01(){

        PostObject postPayload = new PostObject();
        postPayload.setId("2");
        postPayload.setTitle("WHO WILL CRY WHEN YOU DIE");
        postPayload.setAuthor("govind");

        Response resp = given().when().contentType(ContentType.JSON).
                body(postPayload).post("http://localhost:3000/posts");

        System.out.println(resp.statusCode());

        System.out.println("response: "+ resp.asString());


    }

    @Test
    public void patchRequest(){
        Response response = given().when().contentType(ContentType.JSON).body("{\"title\":\"updated by PUT request\" }")
                .patch("http://localhost:3000/posts/1");

        System.out.println(response.asString());
    }

    //below request to object under object

    @Test
    public void postRequest(){
        PostObject_info info = new PostObject_info();

        info.setEmail("Gk@gmail.com");
        info.setPhone("78945624822");
        info.setAddress("new address");

        PostObject postsPayload = new PostObject();
        postsPayload.setId("4");
        postsPayload.setTitle("New title");
        postsPayload.setAuthor("New author");
        postsPayload.setInfo(info);


        Response response = given().when().contentType(ContentType.JSON).body(postsPayload).
                post("http://localhost:3000/posts");

        System.out.println(response.asString());
    }

}
