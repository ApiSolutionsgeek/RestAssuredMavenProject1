package restUtils;

import Reporting.ExtentReportManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.util.Map;

public class RestUtils {
public static RequestSpecification getReqSpec(String baseUrl, Object requestPayload, Map<String,String > headers)
{
    return
    RestAssured.given().log().all()
        .baseUri(baseUrl) //hardcoded URL
        .headers(headers)
        .contentType(ContentType.JSON)
        .body(requestPayload);

}
public static void printRequestlogInReport(RequestSpecification reqSpec)
{
    QueryableRequestSpecification queryReqSpec=SpecificationQuerier.query(reqSpec);
    ExtentReportManager.logInfoDetails("EndPoint is "+ queryReqSpec.getBaseUri());
    ExtentReportManager.logInfoDetails("Method is "+ queryReqSpec.getMethod());
    ExtentReportManager.logInfoDetails("Headers are ");
    ExtentReportManager.logHeaders(queryReqSpec.getHeaders().asList());
    ExtentReportManager.logInfoDetails("Request body is ");
    ExtentReportManager.logJson(queryReqSpec.getBody());
}
    public static void printResponselogInReport(Response response)
    {
        ExtentReportManager.logInfoDetails("Response Status is"+ response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response Body is");
        ExtentReportManager.logJson(response.getBody().prettyPrint());

    }
    public static Response postAirlineBooking(String baseUrl, String requestPayload, Map<String,String > headers)
    {
       RequestSpecification reqSpec= getReqSpec(baseUrl,requestPayload, headers);
       Response response= reqSpec.post();
        printRequestlogInReport(reqSpec);
        printResponselogInReport(response);
        return response;
    }
    public static Response postAirlineBooking(String baseUrl, Map<String,Object> requestPayload, Map<String,String > headers)
    {
        RequestSpecification reqSpec= getReqSpec(baseUrl,requestPayload, headers);
        Response response= reqSpec.post();
        printRequestlogInReport(reqSpec);
        printResponselogInReport(response);
        return response;
    }














}
