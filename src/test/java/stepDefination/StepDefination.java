package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefination extends Utils  {
	 RequestSpecification res;
	 ResponseSpecification resspec;
	 Response response;
	static String placeId;
	 
	 TestDataBuild data=new TestDataBuild();
	
	 /*@Given("Add Place payload")
	public void add_Place_Payload() throws IOException {
		
		  resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		  res=given().spec(requestSpecification())
		 .body(data.addPlacePayload());
	}*/
	 
	 @Given("Add Place payload with {string} {string} {string}")
		public void add_Place_Payload(String name, String language, String address) throws IOException {
			
			 //   resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
			  res=given().spec(requestSpecification())
			 .body(data.addPlacePayload(name,language,address));
	 }
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_request(String resource, String method) {
		
		APIResources resourceAPI= APIResources.valueOf(resource);
	System.out.println(resourceAPI.getResource());
	
	if(method.equalsIgnoreCase("POST"))
		response =res.when().post(resourceAPI.getResource());
	else if(method.equalsIgnoreCase("GET"))
		response=res.when().get(resourceAPI.getResource());
	}
	
	@Then("the api call is success with status code {int}")
	public void api_all_success_with_statuscode(int statusCode) {
		assertEquals(response.getStatusCode(),200);
	}
	
	@And("{string} in response body is {string}")
	public void response_body_is(String keyValue,String ExpectedValue) {
		/*String resp= response.asString();
		js= new JsonPath(resp);
		js.get(key);
		js.get(value);*/
		
		
		//assertEquals(js.get(keyValue).toString(),ExpectedValue); 
		assertEquals(getJsonPath(response,keyValue),ExpectedValue);
		
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException  {
		placeId= getJsonPath(response,"place_id");
		res= given().spec(requestSpecification()).queryParam("place_id",placeId);
		user_calls_with_post_request(resource,"GET");
		String actualname= getJsonPath(response,"name");
		assertEquals(actualname,expectedName);
		}
	
	@Given("Deleteplace payload")
	public void deleteplace_payload() throws IOException {
	 res=  given().spec(requestSpecification())
	   .body(data.deletePayload(placeId));
	}
}
