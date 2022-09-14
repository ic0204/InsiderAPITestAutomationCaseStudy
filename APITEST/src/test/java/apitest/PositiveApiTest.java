package apitest;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.TestCase;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import static apitest.Utility.createResponse;


public class PositiveApiTest extends TestCase {
    @Test(priority = 1)
    public void postRequest() throws JsonProcessingException {
        String url = "https://petstore.swagger.io/v2/pet";
        compareResponseAndExpectedResponse(ApiRequest.POST.getText(), ApiResponse.POST.getText(), url, "post");
    }

    @Test(priority = 2)
    public void putRequest() throws JsonProcessingException {
        String url = "https://petstore.swagger.io/v2/pet";
        compareResponseAndExpectedResponse(ApiRequest.PUT.getText(), ApiResponse.PUT.getText(), url, "put");
    }

    @Test(priority = 3)
    public void getRequest() throws JsonProcessingException {
        String url = "https://petstore.swagger.io/v2/pet/{id}";
        compareResponseAndExpectedResponse(ApiRequest.GET.getText(), ApiResponse.GET.getText(), url, "get");
    }

    @Test(priority = 4)
    public void deleteRequest() throws JsonProcessingException {
        String url = "https://petstore.swagger.io/v2/pet/{id}";
        compareResponseAndExpectedResponse(ApiRequest.DELETE.getText(), ApiResponse.DELETE.getText(), url, "delete");
    }

    public void compareResponseAndExpectedResponse(String requestText, String expectedResponseText, String url, String api) throws JsonProcessingException {
        //Give request url and get response
        JSONObject expectedResponse = new JSONObject(expectedResponseText);
        Response response = createResponse(requestText, url, api);
        JsonPath actualResponse = response.jsonPath();
        //Assertion of response body and status code
        Assert.assertTrue(Utility.equals(expectedResponse, actualResponse));
        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);
    }


}
