package com.api.validations.posts;

import com.api.model.posts.MakePostsResponse;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetPosts {

    public void validateIdAndTitlesAreUnique(List<MakePostsResponse> response){
        Set<Integer> id = new HashSet<>();
        Set<String> title = new HashSet<>();
        response.forEach(postResponse-> {
            if(id.contains(postResponse.getId())){
                throw new AssertionError("Duplicate id in posts "+ postResponse.getId() );
            }
            else {
                id.add(postResponse.getId());
            }

            if(title.contains(postResponse.getTitle())){
                throw new AssertionError("Duplicate title in posts"+ postResponse.getTitle() );
            }
            else {
                title.add(postResponse.getTitle());
            }

        });
    }

    public void validateResponseHasValidId(List<MakePostsResponse> response, int id){
        response.forEach(makePostsResponse -> {
            if(makePostsResponse.getId() !=  id)
                throw new AssertionError("Invalid id "+makePostsResponse.getId()+" in posts for query filter "+ id );
        });
    }
}
