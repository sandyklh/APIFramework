package StepDefination;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    stepDefination sdf=new stepDefination();

    @Before("@Deleteplace")
    public void beforeScenario() throws IOException {

if(stepDefination.place==null) {
    sdf.add_place_payload_with_and_and("Test New", "French", "London");
    sdf.user_calls_with_http_request("AddPlaceAPI", "POST");
    sdf.verify_place_id_created_maps_to_using("Test New", "GetPlaceAPI");
}
    }
}
