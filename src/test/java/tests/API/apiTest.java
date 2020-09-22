package test.java.tests.API;

import org.testng.annotations.Test;
import test.java.utils.PropertyLoader;

import java.io.File;

import static io.restassured.RestAssured.given;

public class apiTest {
    Object createID;

    @Test
    public void createProjectTest() {
//        String bodyAsString = "{" +
//                "\"name\": \"Movies to watchSS\"," +
//                "\"color\": 48," +
//                "\"shared\": false" +
//                "}";

//        HashMap<String, Object> bodyAsMap = new HashMap<> ();
//        bodyAsMap.put ("name", "Movies to watchSS");
//        bodyAsMap.put ("color", 48);
//        bodyAsMap.put ("shared", false);

        createID = given()
                .header ("Authorization", "Bearer 2523a3c2a7e5c254b029e6eb8a47ffffb79f0933")
                .contentType ("application/json")
//                .header("Content-Type", "application/json")
//                .body (bodyAsString)
//                .body (bodyAsMap)
                .body (new File ("G:\\HomeWorks\\Lesson3\\src\\test\\java\\tests\\API\\createProjectBody.json "))
                .when ()
                    .post (PropertyLoader.loadProperty("api.url") + "/projects")
                .then ()
                    .statusCode (200)
                    .extract ().path ("id");

        System.out.println (createID);
    }

    @Test(dependsOnMethods = "createProjectTest")
    public void deleteProjectTest() {
        given()
                .header ("Authorization", "Bearer 2523a3c2a7e5c254b029e6eb8a47ffffb79f0933")
                .contentType ("application/json").log ().all ()
                .when ().log ().all ()
                    .delete (PropertyLoader.loadProperty("api.url") + "/projects/" + createID)
                .then ().log ().all ()
                    .statusCode (204);
    }



}
