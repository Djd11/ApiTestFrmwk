package utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class RestUtil {


    //path

    public static String path;

    public static void setPath(String mypath){

        path = mypath;
    }

    // set base Uri
    //http://api.5min.com
    public static void setBaseUri(String baseUri){

        RestAssured.baseURI = baseUri;

    }

    // set base path

    // search
    public  static void setBasePath (String basePath){

        RestAssured.basePath = basePath;

    }

    // After test we should reset the baesUri

    public static void resetBaseUri(){

        RestAssured.baseURI = null;
    }

    // reset the base path after test

    public static void resetBasePath(){

        RestAssured.basePath = null;
    }

    // Set the content type as Json or Xml

    public static void setContentType(ContentType contentType){

        given().contentType(contentType);
    }

    // create the search query path
    // for example "barack obama/videos.json?num_of_videos=4"

    public static void createSearchQueryPath(String search,String path, String param, String paramValue){

        setPath(search  +"/"+ path +"?"+ param  +"="+ paramValue);

    }



    // Now the response
    // we make a get call with the path and get a api response

    public static Response getResponse(){

        return get(path);

    }

    // Now return the JsonPath

    public static JsonPath getJsonPath(Response response){

        String json = response.toString();
        System.out.println("Returned json "+ json+ "\n");
        return new JsonPath(json);

    }
}
