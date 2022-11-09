package apiTekrar;

import Base_Url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonplaceholderBaseUrl {
     /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */
    @Test
    public void test01(){
        spec.pathParams("first","todos","second",2);
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //set the expected data
        JsonPlaceHolderTestData expectedDta=new JsonPlaceHolderTestData();
       Map<String,Object>data= expectedDta.expectedData(1,"quis ut nam facilis et officia qui",false);
        //do assertion
        Map<String,Object>actualDta=response.as(HashMap.class);
        assertEquals(200,response.statusCode());
        assertEquals(data.get("userId"),actualDta.get("userId"));
        assertEquals(data.get("title"),actualDta.get("title"));
        assertEquals(data.get("completed"),actualDta.get("completed"));

    }
}
