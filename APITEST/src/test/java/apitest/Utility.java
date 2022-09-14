package apitest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class Utility {
    protected static boolean equals(JSONObject jsonobject, JsonPath jsonpath) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode j1 = mapper.readTree(String.valueOf(jsonobject));
        JsonNode j2 = mapper.readTree(jsonpath.prettify());
        return j1.equals(j2);
    }

    public static Response createResponse(String requestText, String url, String api) {
        Response response = null;
        switch (api) {
            case "post":
                response = given().contentType(ContentType.JSON).when().body(requestText).post(url);
                break;
            case "put":
                response = given().contentType(ContentType.JSON).when().body(requestText).put(url);
                break;
            case "get":
                response = given().contentType(ContentType.JSON).when().get(url, requestText);
                break;
            case "delete":
                response = given().contentType(ContentType.JSON).when().delete(url, requestText);
            default:
                break;
        }

        return response;
    }

}
