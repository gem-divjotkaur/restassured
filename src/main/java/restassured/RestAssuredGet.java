package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredGet {
    @Test
    public void methodGet(){
        // adding try and catch block to handle exceptions
        try{
            // creating RestAssured (library of java used to test restful web services) with
            // given (part of behaviour driven testing) which represents given conditions.
            RestAssured.given()
                    // providing the path of base URI (URL which is common for all the requests)

                    .baseUri("https://gorest.co.in/public/v2")
                    // providing content-type = application/json in headers section

                    .header("Content-Type", "application/json")
                    // to execute the response , use log().all()

                    .log().all()
                    // adding when to represent the upcoming conditions and inside get request,
                    // provide its path
                    .when().get("/users/3786885")

                    // add then to represent the outcome of the condition
                    // log().all() is to execute all the response
                    .then().log().all()

                    //below condition is to check the status code 200 or not.
                    .assertThat().statusCode(200);

        }
        catch(Exception e){
            // print the stack trace of exception to the console
            e.printStackTrace();
        }
    }
}
