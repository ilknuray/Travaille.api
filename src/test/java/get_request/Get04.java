package get_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class Get04 {
    @Test
    public void test04(){
        /*
        http://dummy.restapiexample.com/api/v1/employees  url’ine
GET request’i yolladigimda gelen response’un
status kodunun 200 ve content type’inin “application/json”
ve employees sayisinin 24
ve employee’lerden birinin “Ashton Cox”
ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.
         */

        //set the url
        String url="http://dummy.restapiexample.com/api/v1/employees";

        //set the expected body


        //send to request and get the response
        Response response=given().when().get(url);
        response.prettyPeek();

        //assertion
        response.
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200);

        response.
                then().
                assertThat().
                body("data", Matchers.hasSize(24),"data.employee_name",hasItem("Ashton Cox"),"data.employee_age",hasItems(21,23,61));
    }
}
