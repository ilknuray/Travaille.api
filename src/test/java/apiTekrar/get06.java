package apiTekrar;

import Base_Url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class get06 extends ReqresBaseUrl {
     /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then
            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */
    @Test
    public void test01(){
        spec.pathParam("first","unknown");
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("data",hasSize(6));

        //2)Print all pantone_values
        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.getList("data.pantone_value"));

        //Print all ids greater than 3 on the console
        List<Integer>ids=jsonPath.getList("data.findAll{it.id>3}.id");
       // List<Integer> ids = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println(ids);
        //Assert that there are 3 ids greater than 3
        assertEquals(3,ids.size());
        //Print all names whose ids are less than 3 on the console
        List<String>names=jsonPath.getList("data.findAll{it.id<3}.names");
        System.out.println(names);
        assertEquals(2,names.size());




    }

}
