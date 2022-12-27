package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinitions extends Utils {

	RequestSpecification res;
	TestDataBuild data = new TestDataBuild();
	Response response;

    @Given("^\"([^\"]*)\" payload with (.+), (.+), (.+)$")
    public void something_payload_with_(String resource,String name, String salary, String age) throws IOException{
    	
            	 res=given().spec(requestSpecification())
            			 .body(data.createEmployeePayload(name, salary, age));
        		
    		 
    		 
    }

    @When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public void user_calls_something_with_something_http_request(String resource, String method) {
        
    	APIResources resourceAPI = APIResources.valueOf(resource);
    	if(method.equalsIgnoreCase("POST")) {
    	response = res.when().post(resourceAPI.getResource()).
				then().extract().response();
    	}
    	else if(method.equalsIgnoreCase("GET")){
    		response = res.when().get(resourceAPI.getResource()).
					then().extract().response();
    	}
    	else if(method.equalsIgnoreCase("PUT")){
    		response = res.when().put(resourceAPI.getResource()).
					then().extract().response();
    	}
    	
    	else if(method.equalsIgnoreCase("DELETE")){
    		response = res.when().delete(resourceAPI.getResource()).
					then().extract().response();
    	}
    }

    @Then("^the API call got success with status code 200$")
    public void the_api_call_got_success_with_status_code_200() {
    
    	assertEquals(response.statusCode(),200);
       
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String key, String value){
    	
    	assertEquals(getJsonPath(response,key),value);
    }
    
    @Given("^pass the employee (.+) to \"([^\"]*)\" the employee record$")
    public void pass_the_employee_to_something_the_employee_record(String id, String strArg1) throws IOException {
    	
    	res=given().spec(requestSpecification()).pathParam("id", id);
       
    }
    
    @Given("^updateEmployee payload with (.+), (.+), (.+) and Pass (.+) to update the employee$")
    public void updateemployee_payload_with_and_pass_to_update_the_employee(String name, String salary, String age, String id) throws Throwable {
    	 res=given().spec(requestSpecification()).pathParam("id",id)
				 .body(data.createEmployeePayload(name, salary, age));
    }
}
