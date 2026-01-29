package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		
		
		StepDefination m= new StepDefination();
		if(StepDefination.placeId==null) {
		m.add_Place_Payload("Nidhi", "Hindi", "Park");
		m.user_calls_with_post_request("AddPlaceAPI","POST");
		m.verify_place_id_created_maps_to_using("Nidhi", "getPlaceAPI");
		
	}
	}

}
