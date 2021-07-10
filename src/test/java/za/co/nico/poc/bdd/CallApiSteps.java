package za.co.nico.poc.bdd;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;



public class CallApiSteps extends Steps {
	String expectedResponseStatusCode=null;
	String expectedResponseStatusMessage=null;
	String responseStatusCode= null;
	String responseStatusMessage= null;
	

	
	/**
	 Scenario: 1 the data received from the SonarQube is valid persist project list data to database
	 Given the request has all fields populated with valid values (PENDING)
	 When I receive a valid request from the other service (PENDING)
	 Then the GET response and persist project list data to database (PENDING)
	 */
	@Given("the request has all fields populated with valid values")
	public void givenTheRequestHasAllFieldsPopulatedWithValidValues() {
	  // PENDING
	}

	@When("I receive a valid request from the other service")
	public void whenIReceiveAValidRequestFromTheOtherService() {
	  // PENDING
	}

	@Then("the GET response and persist project list data to database")
	public void thenTheGETResponseAndPersistProjectListDataToDatabase() {
	  // PENDING
	}
	
	/**
	Scenario: 2 the sent requests received from another service has missing fields dont send a message to the rabbitmq server
	Given the request does not have all needed fields populated (PENDING)
	When I receive an invalid request from another service (PENDING)
	Then I should return an error message (PENDING)	
	*/
	@Given("the request does not have all needed fields populated")
	public void givenTheRequestDoesNotHaveAllNeededFieldsPopulated() {
	  // PENDING
	}

	@When("I receive an invalid request from another service")
	public void whenIReceiveAnInvalidRequestFromAnotherService() {
	  // PENDING
	}

	@Then("I should return an error message")
	public void thenIShouldReturnAnErrorMessage() {
	  // PENDING
	}

}
