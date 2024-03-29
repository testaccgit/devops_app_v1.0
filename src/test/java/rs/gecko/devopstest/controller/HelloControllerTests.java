package rs.gecko.devopstest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import rs.gecko.devopstest.DevOpsTestApplication;

@SpringBootTest(classes = DevOpsTestApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class HelloControllerTests {

  @Autowired
  private TestRestTemplate restTemplate;

  private String name;
  private ResponseEntity<String> response;

  @Given("I use the name (.*)")
  public void useName(String name) {
    this.name = name;
  }

  @When("I request a hello resource")
  public void requestMessage() {
    response = restTemplate
        .exchange("/hello/{name}", HttpMethod.GET, null, String.class, name);
  }

  @Then("I should get a response with HTTP status code (.*)")
  public void shouldGetResponseWithHttpStatusCode(int statusCode) {
    assertThat(response.getStatusCodeValue()).isEqualTo(statusCode);
  }

  @And("The response should contain the message (.*)")
  public void theResponseShouldContainTheMessage(String message) {
    assertThat(response.getBody()).isEqualTo(message);
  }

}

