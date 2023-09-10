package com.api.stepdefinition.posts;

import static org.junit.Assert.*;

import com.api.model.commons.RequestResponse;
import com.api.model.posts.MakePostsResponse;
import com.api.utils.impl.RestAssuredClient;
import com.api.validations.posts.GetPosts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.api.utils.TestContext;

import io.cucumber.java.en.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PostsStepDefinition {

	private TestContext context;
	private GetPosts getPosts;
	private RestAssuredClient client;
	private RequestResponse response;

	private static final Logger LOG = LogManager.getLogger(PostsStepDefinition.class);
	private List<MakePostsResponse> responseDeserialized;

	 public PostsStepDefinition(TestContext context, GetPosts getPosts, RestAssuredClient client, RequestResponse response ) {
	 	this.context = context;
	 	this.getPosts = getPosts;
	 	this.client = client;
	 	this.response = response;
	}

	@Given("user has access to endpoint {string}")
	public void userHasAccessToEndpoint(String endpoint) {
		context.session.put("endpoint", endpoint);
	}

	@When("user hits the request")
	public void userCreatesABooking() {
		context.response = client.get(context.session.get("endpoint").toString());
		response.setResponse(context.response);
		LOG.getLoggerRepository().getLogger(context.response.asString());

	}


	@Then("user should get the response code {int}")
	public void userShouldGetTheResponseCode(Integer statusCode) {
		assertEquals(Long.valueOf(statusCode), Long.valueOf(context.response.getStatusCode()));
	}

	@Then("validate the getPosts response by deserializing")
	public void validate_the_response_bt_deserializing() throws JsonProcessingException {
	 	context.response = response.getResponse();
	 	ObjectMapper mapper = new ObjectMapper();
		responseDeserialized = mapper.readValue(context.response.asString(),new TypeReference<List<MakePostsResponse>>() {});

	 }

	@Then("validate all id and titles are unique")
	public void validate_all_id_and_titles_are_unique() {
		getPosts.validateIdAndTitlesAreUnique(responseDeserialized);
	}

	@When("user hits the request with {int} as query param")
	public void userHitsTheRequestWithAsQueryParam(int id) {
	 	Map<String, String> params = new HashMap<>();
	 	params.put("id", String.valueOf(id));
		context.response = client.get(context.session.get("endpoint").toString(), params);
		response.setResponse(context.response);
	}


	@Then("validate all post of id {int} are in response")
	public void validateAllPostOfIdAreInResponse(int id) {
	 	getPosts.validateResponseHasValidId(responseDeserialized, id);
	}
}
