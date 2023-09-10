package com.api.stepdefinition.posts;

import com.api.model.commons.RequestResponse;
import com.api.model.posts.GetCommentsResponse;
import com.api.utils.TestContext;
import com.api.validations.posts.Comments;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class CommentsStepDef {

    List<GetCommentsResponse> responseDeserialized;

    private RequestResponse response;
    private TestContext context;
    private Comments comments;

    public CommentsStepDef(TestContext context, RequestResponse response, Comments comments){
        this.response = response;
        this.context = context;
        this.comments = comments;
    }

    @And("validate the getComments response by deserializing")
    public void validateTheGetCommentsResponseByDeserializing() throws JsonProcessingException {
        context.response = response.getResponse();
        ObjectMapper mapper = new ObjectMapper();
        responseDeserialized = mapper.readValue(context.response.asString(),new TypeReference<List<GetCommentsResponse>>() {});
    }


    @Then("validate email-Id is valid")
    public void validateEmailIdIsValid() {
        comments.validateEmailId(responseDeserialized);
    }

    @Then("validate comment ID is unique")
    public void validateCommentIDIsUnique() {
        comments.validateCommentId(responseDeserialized);
    }

    @Then("validate all comments of id {int} are in response")
    public void validateAllCommentsOfIdIDAreInResponse(int id) {
        comments.validateResponseHasValidId(responseDeserialized, id);
    }
}
