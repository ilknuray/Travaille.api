package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public Map<String,Object>expectedData(Integer userId,String title,Boolean completed){

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", userId);
        //expectedData.put("id", 2);
        expectedData.put("title", title);
        expectedData.put("completed", completed);
        return expectedData;
    }
}
