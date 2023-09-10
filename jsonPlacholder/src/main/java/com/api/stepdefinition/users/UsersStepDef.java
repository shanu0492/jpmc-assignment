package com.api.stepdefinition.users;

import com.api.model.commons.RequestResponse;
import com.api.model.users.Users;
import com.api.utils.TestContext;
import com.api.validations.users.UserValidation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class UsersStepDef {

    private TestContext context;
    private RequestResponse response;
    private  List<Users> responseDeserialized;
    private  UserValidation users;

    public UsersStepDef(TestContext context, RequestResponse response, UserValidation users){
        this.context = context;
        this.response = response;
        this.users = users;
    }

    @And("validate the getUsers response by deserializing")
    public void validateTheGetCommentsResponseByDeserializing() throws JsonProcessingException {
        context.response = response.getResponse();
        ObjectMapper mapper = new ObjectMapper();
        responseDeserialized = mapper.readValue(context.response.asString(),new TypeReference<List<Users>>() {});
    }

    @Then("validate email-Id is valid in user request")
    public void validateEmailIdIsValidInUserRequest() {
        users.validateEmailId(responseDeserialized);
    }

    @And("email-Id is unique per user")
    public void emailIdIsUniquePerUser() {
        users.validateUniqueEmailId(responseDeserialized);
    }

    @Then("validate user name is unique")
    public void validateUserNameIsUnique() {
        users.validateUniqueUserName(responseDeserialized);
    }

    @Then("validate phone number is valid in user request")
    public void validatePhoneNumberIsValidInUserRequest() {
        users.validatePhoneNo(responseDeserialized);
    }


    @Then("validate all users of id {int} are in response")
    public void validateAllUsersOfIdIDAreInResponse(int id ) {
        users.validateResponseHasValidId(responseDeserialized, id);
    }
}
