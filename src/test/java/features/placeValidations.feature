Feature: Validating Place APIs

# normal scenario in which hard coded values are being passed in AddPlace api payload
#Scenario: Verify if place is being added successfully
#	Given Add Place payload
#	When user calls "addplaceapi" with Post http request
#	Then the api call is success with status code 200
#	And "status" in response body is "OK"
#	And "scope" in response body is "APP"
	
@AddPlace
Scenario Outline: Verify if place is being added successfully
	Given Add Place payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "POST" http request
	Then the api call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_Id created maps to "<name>" using "getPlaceAPI"
	
Examples:
	|name 		| language | address     |
	|Cortland	| English  | Trump Tower | 
#	|Galeria    | spanish  | world center|

@DeletePlace
Scenario: Verify DeletePlace API is working 
	Given Deleteplace payload
	When user calls "deletePlaceAPI" with "POST" http request
	Then the api call is success with status code 200
	And "status" in response body is "OK"

 