package apiTekrar;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class get02 {
     /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void test01(){
        String url="https://reqres.in/api/users/23";

        Response response=given().when().get(url);
        response.prettyPrint();

        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found").header("Server","cloudflare");
        assertEquals(2,response.asString().replaceAll("\\s","").length());

    }
}
