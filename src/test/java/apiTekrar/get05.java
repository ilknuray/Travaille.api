package apiTekrar;

import Base_Url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class get05 extends ReqresBaseUrl {
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */
    @Test
    public void test01(){
        spec.pathParams("first","unknown","second",3);

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        response.then().
               assertThat().statusCode(200).contentType("application/json; charset=utf-8").
                body("data.id",equalTo(3),"data.name",equalTo("true red"));

        //soft assert ile
        JsonPath jsonPath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(jsonPath.getInt("data.id"),3);
        softAssert.assertEquals(jsonPath.getString("data.name"),"true red");
        softAssert.assertEquals(jsonPath.getString("pantone_value"),"19-1664");
        softAssert.assertEquals(jsonPath.getString("support.url"),"https://reqres.in/#support-heading");
        softAssert.assertEquals(jsonPath.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!");



    }
}
