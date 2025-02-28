package airlines;
import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.*;
public class AirlineAPIs {

    public Response createAirline(Map<String,Object> createAirlinePayload)
    {
            String baseUrl= (String) Base.dataFromJsonFile.get("baseUrl");
             return  RestUtils.postAirlineBooking(baseUrl,createAirlinePayload,new HashMap<>());
    }







}
