package ApiTests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.RestUtil;

public class MyApiTest {


    private Response res = null;
    private JsonPath jp = null;


    @Before
    public void setUp(){

        RestUtil.setBaseUri("https://jsonplaceholder.typicode.com");
        RestUtil.setBasePath("posts/1");
        RestUtil.setContentType(ContentType.JSON);
//        RestUtil.createSearchQueryPath("Barak obama","videos.json", "num_of_videos", "4");
        RestUtil.setPath("https://jsonplaceholder.typicode.com/posts/1");
        res = RestUtil.getResponse();
        jp = RestUtil.getJsonPath(res);
    }


    @Test
    public void testResponseStatus(){

        Assert.assertEquals("Status Check Failed!",200,res.getStatusCode());
    }

    @Test
    public void postExamplebyGherkinTest()
    {
        RestAssured.baseURI  = "https://jsonplaceholder.typicode.com";

        Response res = given()
                .contentType("application/json").
                        body("{\"userId\":\"1\"}").
                        when().
                        post("/posts/1");

        String body = res.getBody().asString();
        System.out.println(body);

    }



}
