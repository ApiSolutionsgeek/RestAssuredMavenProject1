package airlines;

import Utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Airlinetests extends AirlineAPIs {

    @Test
    public void createAirline() throws IOException {


        Map<String,Object> requestPayload=Payloads.createAirlinePayloadFromMap("Jim","Brown","111","true","Breakfast");

       Response response= createAirline(requestPayload);
       System.out.println( response.statusCode());
     //  Assert.assertEquals(resp.statusCode(),200);
    }










}
