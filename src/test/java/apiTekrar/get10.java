package apiTekrar;

import Base_Url.GorestBaseUrl;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.Map;

public class get10 extends GorestBaseUrl {
     /*
   Given
       https://gorest.co.in/public/v1/users/2986
   When
       User send GET Request to the URL
   Then
       Status Code should be 200
   And
       Response body should be like

   {
    "meta": null,
    "data": {
        "id": 2986,
        "name": "Chandraswaroopa Khan I",
        "email": "chandraswaroopa_khan_i@hirthe.com",
        "gender": "female",
        "status": "active"
    }
}
     }
*/
    @Test
    public void test01(){

        spec.pathParams("first","users","second",2986);

        GoRestTestData goRestTestData=new GoRestTestData();
        Map<String,String>dataKeyMap=goRestTestData.gorest("Chandraswaroopa Khan I","chandraswaroopa_khan_i@hirthe.com","female","active");
        Map<String,Object>expectedData=goRestTestData.metaGoRest(null,dataKeyMap);
        System.out.println(expectedData);


    }
}
