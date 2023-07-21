package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

public class RestAssuredPatch {
    @Test
    public void methodPatch(){
        // adding try and catch block to handle the exceptions
        try{
            // creating json object and adding payload in the patch request
            JSONObject payload = new JSONObject();
            payload.put("name", "Div Kaur");
            payload.put("status", "inactive");

            // using rest assured (library of java to test the restful web services) with
            // given (part of Behaviour driven development) to represent given conditions
            Response response = RestAssured.given()

                    // providing url link of base url which is common to all the requests
                    .baseUri("https://gorest.co.in/public/v2")

                    // providing headers :
                    // providing content type , accept as application/json
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")

                    // using authentication just to authorize or to authenticate user the access of
                    // protected API.
                    .header("Authorization", "Bearer 66749fba446a1a9cf5f6fac297a180fb2c2008b60c573de494af8aa49ce099ac")

                    // converting the json object to string and passing it through the body
                    .body(payload.toString())

                    // add when to represent the upcoming condition and passing the url of patch request
                    .when().patch("/users/3786885");

            // print the body of request as string value
            System.out.println(response.getBody().asString());
        }
        catch(Exception e){
            // print the stack trace of the exception to the console
            e.printStackTrace();
        }
    }
}
