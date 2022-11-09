package apiTekrar;

import Base_Url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.RestfulTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends RestfulBaseUrl {
    /*

        Given
            https://restful-booker.herokuapp.com/booking/91
        When
            I send GET Request to the url
        Then
            Response body should be like that;
             {
            "firstname": "Sally",
            "lastname": "Brown",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2013-02-23",
                "checkout": "2014-10-23"
            },
            "additionalneeds": "Breakfast"
            }
     */
    @Test
    public void test01(){
        spec.pathParams("first","booking","second",91);


        //set the expected data
        Map<String,String>bookingMap=new HashMap<>();
        bookingMap.put("checkin","2013-02-23");
        bookingMap.put("checkout","2014-10-23");
        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("firstname","Sally");
        expectedData.put("lastname","Brown");
        expectedData.put("totalprice",111);
        expectedData.put("depossitpaid",true);

        expectedData.put("bookingdates",bookingMap);
        System.out.println(expectedData);
        Response response=given().spec(spec).when().get("/{first}/{second}");

         //do assertion
        Map<String,Object>actualData=response.as(HashMap.class);
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
    }


}
