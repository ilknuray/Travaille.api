package apiTekrar;

import Base_Url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class get04 extends RestfulBaseUrl {

      /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
        When
            User sends get request to the URL "Philip",
    "lastname": "Touring",
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"*/
    @Test
    public  void test01(){
        spec.pathParam("first","booking").queryParams("firstname","Philip","lastname","Touring");

        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
       // assertTrue(response.asString().contains("bookingid"));
    }
}

