package api;
import io.restassured.builder.RequestSpecBuilder;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.FileReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class NetworkUtil {
    public static final String CONTENT_TYPE_JSON = "application/json";

    public RequestSpecification addSpec () {
        return new RequestSpecBuilder()
                .setBaseUri(FileReader.readProperties("base_url"))
                .setContentType(CONTENT_TYPE_JSON)
                .setAccept(CONTENT_TYPE_JSON)
                .build()
                .log()
                .all();
    }

    public Response request (Method method, String path) {
        return given()
                .spec(addSpec())
                .when()
                .request(method, path)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public Response request (Method method, String path, Map<String, String> queryParams) {
        return given()
                .spec(addSpec())
                .queryParams(queryParams)
                .when()
                .request(method, path)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }
}
