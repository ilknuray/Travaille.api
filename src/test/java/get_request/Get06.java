package get_request;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get06 extends Authentication {
    @Test
    public void test06(){
        String url="https://www.gmibank.com/api/tp-customers/114351";



        Response response=given().headers("Authorization","Bearer " + generateToken()).when().get(url);
        //response.prettyPrint();

        //Matcher class ile musteri bilgilerini dogrulayin

        response.then().assertThat().
                body("firstName",equalTo("Della"),
                        "lastName",equalTo("Heaney"),
                        "email",equalTo("ricardo.larkin@yahoo.com"),
                        "phoneNumber",equalTo("213-456-7893"),
                        "accounts[1].balance",equalTo(69700),
                        "accounts[1].accountType",equalTo("CREDIT_CARD"),
                        "accounts[0].balance",equalTo(11190),"accounts[0].accountType",equalTo("CHECKING"));

        //jsonpath ile musteri bilgilerini dogrulayin

        JsonPath jsonPath=response.jsonPath();

       assertEquals("Della",jsonPath.getString("firstName"));
       assertEquals("Heaney",jsonPath.getString("lastName"));
       assertEquals("ricardo.larkin@yahoo.com",jsonPath.getString("email"));
       assertEquals("213-456-7893",jsonPath.getString("phoneNumber"));




    }
}
