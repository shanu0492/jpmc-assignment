package com.api.validations.users;

import com.api.model.users.Users;
import com.api.validations.commons.Common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserValidation {

    private Common common;

    public UserValidation(Common common){
        this.common = common;
    }

    public void validateEmailId(List<Users> responses){
        responses.forEach(getCommentsResponse -> {
            common.isEmailValid(getCommentsResponse.getEmail());
        });
    }

    public  void validateUniqueEmailId(List<Users> responses){
        Set<String> emailId = new HashSet<>();
        responses.forEach(getCommentsResponse -> {
            if(emailId.contains(getCommentsResponse.getEmail()))
                throw new AssertionError("Email Id: "+getCommentsResponse.getEmail()+ " is duplicate");

            emailId.add(getCommentsResponse.getEmail());
        });
    }

    public void validateUniqueUserName(List<Users> responses){
        Set<String> userName = new HashSet<>();
        responses.forEach(getCommentsResponse -> {
            if(userName.contains(getCommentsResponse.getUsername()))
                throw new AssertionError("User name: "+getCommentsResponse.getUsername()+ " is duplicate");

            userName.add(getCommentsResponse.getUsername());
        });
    }

    public void validatePhoneNo(List<Users> responses){
        responses.forEach(getCommentsResponse -> {
            common.isValidUsPhoneNumber(getCommentsResponse.getPhone());
        });
    }


    public void validateResponseHasValidId(List<Users> response, int id){
        response.forEach(makePostsResponse -> {
            if(makePostsResponse.getId() !=  id)
                throw new AssertionError("Invalid id "+makePostsResponse.getId()+" in posts for query filter "+ id );
        });
    }
}
