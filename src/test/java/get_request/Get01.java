package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
    @Test
    public void test01() {
        String url = "https://restful-booker.herokuapp.com/booking";
        //end pointe request gondermis olduk given ile
        Response response = given().when().get(url);
        //response api ile bana gelen response cevap

        //Response response=given().auth().basic("user",password).when().get(url);->basic aut ile request gondermek icin
        response.prettyPeek();//->response taki herseyi yazdirir
        //response.prettyPrint()->response daki body i yazdirir

        //response.peek();-> buda herseyi yazdirir

    }
}
