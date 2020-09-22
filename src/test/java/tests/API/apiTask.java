package test.java.tests.API;

import org.testng.annotations.Test;
import test.java.utils.PropertyLoader;

import java.io.File;

import static io.restassured.RestAssured.given;

public class apiTask {
    Object createIDTask;

    @Test
    public void createTask1() {
        createIDTask = given()
                .header ("Authorization", "Bearer 2523a3c2a7e5c254b029e6eb8a47ffffb79f0933")
                .contentType ("application/json")
                .body (new File ("src/test/java/tests/API/createTaskBody.json"))
                .when ()
                    .post (PropertyLoader.loadProperty("api.url") + "/tasks")
                .then ()
                    .statusCode (200)
                    .extract ().path ("id");

//        System.out.println (createIDTask);
    }

    @Test(dependsOnMethods = "createTask1")
    public void getTask1() {
        given()
                .header ("Authorization", "Bearer 2523a3c2a7e5c254b029e6eb8a47ffffb79f0933")
                .contentType ("application/json")
                .when ()
                    .get (PropertyLoader.loadProperty("api.url") + "/tasks/" + createIDTask)
                .then ()
                    .statusCode (200);
    }

    @Test(dependsOnMethods = "getTask1")
    public void updateTask1() {
        given ()
                .header ("Authorization", "Bearer 2523a3c2a7e5c254b029e6eb8a47ffffb79f0933")
                .contentType ("application/json")
                .body ("{\"content\": \"Appointment with Alex\"}")
                .when ()
                    .post (PropertyLoader.loadProperty("api.url") + "/tasks/" + createIDTask)
                .then ()
                    .statusCode (204);
    }


    @Test(dependsOnMethods = "updateTask1")
    public void deleteTask1() {
        given ()
                .header ("Authorization", "Bearer 2523a3c2a7e5c254b029e6eb8a47ffffb79f0933")
                .contentType ("application/json")
                .when ()
                    .delete (PropertyLoader.loadProperty("api.url") + "/tasks/" + createIDTask)
                .then ()
                    .statusCode (204);
    }

}
