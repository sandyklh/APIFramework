package StepDefination;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResouces;
import resources.TestData;
import resources.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.junit.Assert.assertEquals;

public class stepDefination extends utils {
    RequestSpecification req;
    ResponseSpecification ResSpec;
    static String place;

    Response response;
TestData data=new TestData(); //calling data from resources
    @Given("Add Place  Payload with {string} and {string} and {string}")
    public void add_place_payload_with_and_and(String name, String language, String address) throws IOException {



         req=given().spec(requestspecification())//calling it from utils class
                 .body(data.addplace(name,language,address));
    }
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String httpmethod) {

        APIResouces resAPI=APIResouces.valueOf(resource);
        //System.out.println(resAPI.getResource());
        ResSpec=new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();

if(httpmethod.equalsIgnoreCase("POST"))
        response=req.when().post(resAPI.getResource())
                .then().spec(ResSpec).extract().response();
else if (httpmethod.equalsIgnoreCase("GET"))
    response=req.when().get(resAPI.getResource())
            .then().spec(ResSpec).extract().response();

    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(int int1) {
assertEquals(response.getStatusCode(),int1);

    }
    @Then("{string} in resposne body is {string}")
    public void status_in_resposne_body_is_ok(String key,String value) {


        // Write code here that turns the phrase above into concrete actions
       assertEquals(getFromJason(response,key),value);
    }


    @Then("verify place_id created maps to {string} using  {string}")
    public void verify_place_id_created_maps_to_using(String ExpectedName, String Resource) throws IOException {
         place=getFromJason(response,"place_id");
        req=given().spec(requestspecification()).queryParam("place_id",place);

        user_calls_with_http_request(Resource,"GET");

        String ActualName=getFromJason(response,"name");
        Assert.assertEquals(ActualName,ExpectedName);
    }


    @Given("Delete Payload")
    public void delete_payload() throws IOException {
        req =given().spec(requestspecification()).body(data.deletePlacePayload(place));

    }



}
