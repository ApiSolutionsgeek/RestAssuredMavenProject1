package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {


    private static ObjectMapper mapper = new ObjectMapper();
    public static Map<String, Object> getJsonDataAsMap(String jsonFileName) throws IOException {

        String completeJsonFilePath = System.getProperty("user.dir") + jsonFileName;
        Map<String,Object>  data =mapper.readValue(new File(completeJsonFilePath), new TypeReference<>() { });
        return data;
    }
}





