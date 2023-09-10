package com.api.validations.posts;

import com.api.model.posts.GetCommentsResponse;
import com.api.validations.commons.Common;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Comments {

    private Common common;

    public Comments(Common common){
        this.common = common;
    }

    public void validateEmailId(List<GetCommentsResponse> responses){
        responses.forEach(getCommentsResponse -> {
        common.isEmailValid(getCommentsResponse.getEmail());
        });

    }

    public void validateCommentId(List<GetCommentsResponse> responses){
        Set<Integer> commentId = new HashSet<>();
        responses.forEach(getCommentsResponse -> {
            if(commentId.contains(getCommentsResponse.getId()))
                throw new AssertionError("Comment Id is duplicate "+getCommentsResponse.getId());
        });

    }

    public void validateResponseHasValidId(List<GetCommentsResponse> response, int id){
        response.forEach(getCommentsResponse -> {
            if(getCommentsResponse.getId() !=  id)
                throw new AssertionError("Invalid id "+getCommentsResponse.getId()+" in posts for query filter "+ id );
        });
    }
}
