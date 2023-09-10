package com.api.utils.impl;

import com.api.utils.Client;
import com.api.utils.TestContext;
import io.restassured.response.Response;

import java.util.Map;


public class RestAssuredClient implements Client {

    private TestContext context;

    public RestAssuredClient(TestContext context) {
        this.context = context;
    }

    @Override
    public Response get(String endpoint){
        return  context.requestSetup().when().get(endpoint);
    }

    @Override
    public Response get(String endpoint, Map queryParams){
        return  context.requestSetup().queryParams(queryParams).when().get(endpoint);
    }
}
