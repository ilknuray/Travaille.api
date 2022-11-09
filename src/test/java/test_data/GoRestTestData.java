package test_data;

import java.util.HashMap;
import java.util.Map;

public class GoRestTestData {
    public Map<String,String>gorest(String name,String email,String gender,String status){
      Map<String,String>gorest=new HashMap<>();
      gorest.put("name",name);
      gorest.put("email",email);
      gorest.put("gender",gender);
      gorest.put("status",status);

      return gorest;

    }
    public Map<String,Object>metaGoRest(Object meta,Map<String,String>data){
        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("meta",meta);
        expectedData.put("data",data);
        return expectedData;

    }
}
