package apitest;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.internal.http.HttpResponseException;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.TestCase;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import static apitest.Utility.createResponse;
import static io.restassured.RestAssured.given;


public class NegativeApiTest extends TestCase {
    @Test(priority = 1)
    public void postRequestNegativeScenario() throws JsonProcessingException {
        String url = "https://petstore.swagger.io/v2/pet";
        compareResponseAndExpectedResponse(ApiRequest.POST_NEGATIVE.getText(), ApiResponse.POST_NEGATIVE.getText(), url, "post", 400);
    }

    @Test(priority = 2)
    public void putRequest() {
        String url = "https://petstore.swagger.io/v2/pet";
        int status = 0;
        try {
            given().contentType(ContentType.JSON).when().body(ApiRequest.PUT_NEGATIVE.getText()).put(url);
        } catch (Exception e) {
            int x = 0;
            status = ((HttpResponseException) e).getResponse().getStatus();
        }
        Assert.assertEquals(400, status);

    }

    @Test(priority = 3)
    public void getRequestNegativeScenario() {
        String url = "https://petstore.swagger.io/v2/pet/{id}";
        int status = 0;
        try {
            Response response = given().contentType(ContentType.JSON).when().get(url, ApiRequest.GET_NEGATIVE.getText());
        } catch (Exception e) {
            status = ((HttpResponseException) e).getResponse().getStatus();
        }
        Assert.assertEquals(404, status);
    }

    @Test(priority = 4)
    public void deleteRequest() {
        String url = "https://petstore.swagger.io/v2/pet/{id}";
        int status = 0;
        try {
            Response response = given().contentType(ContentType.JSON).when().get(url, ApiRequest.DELETE_NEGATIVE.getText());
        } catch (Exception e) {
            status = ((HttpResponseException) e).getResponse().getStatus();
        }
        Assert.assertEquals(404, status);

    }

    public void compareResponseAndExpectedResponse(String requestText, String expectedResponseText, String url, String api, int expectedStatusCode) throws JsonProcessingException {
        //Give request url and get response
        Response response = createResponse(requestText, url, api);
        JsonPath actualResponse = response.jsonPath();
        //Assertion of response body and status code
        JSONObject expectedResponse = new JSONObject(expectedResponseText);
        Assert.assertTrue(Utility.equals(expectedResponse, actualResponse));
        response.then().assertThat().contentType(ContentType.JSON).statusCode(expectedStatusCode);

    }

}
