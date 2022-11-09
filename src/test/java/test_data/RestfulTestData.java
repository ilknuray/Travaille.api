package test_data;

import java.util.HashMap;
import java.util.Map;

public class RestfulTestData {
    public Map<String,Object>obj(String lastname,String firstname,Integer totalprice,Boolean depositpaid){

        //  "firstname": "Sally",
        //            "lastname": "Brown",
        //            "totalprice": 111,
        //            "depositpaid": true,
        //            "bookingdates": {
        //                "checkin": "2013-02-23",
        //                "checkout": "2014-10-23"
        //            },
        //            "additionalneeds": "Breakfast"
        Map<String,Object>obj=new HashMap<>();
        obj.put("firstname",firstname);
        obj.put("lastname",lastname);
        obj.put("totalprice",totalprice);
        obj.put("depossitpaid",depositpaid);
        Map<String,String>bookingMap=new HashMap<>();
        bookingMap.put("checkin","2013-02-23");
        bookingMap.put("checkout","2014-10-23");
        obj.put("bookingdates",bookingMap);

        return obj;
    }
}
