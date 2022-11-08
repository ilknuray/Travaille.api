package apiTekrar;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class get01 {
    /*
         Given
             https://reqres.in/api/users/3
         When
             User sends a GET Request to the url
         Then
             HTTP Status Code should be 200
         And
             Content Type should be JSON
         And
             Status Line should be HTTP/1.1 200 OK
      */

    @Test
    public void test01(){
        //set the url
        String url="https://reqres.in/api/users/3";
        //send requeqt and get response
        Response response=given().when().get(url);
        response.prettyPrint();
        //do assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");
        //2.yol
        assertEquals(200,response.statusCode());
        assertEquals("HTTP/1.1 200 OK",response.statusLine());
        assertEquals("application/json; charset=utf-8",response.contentType());

    }
}
