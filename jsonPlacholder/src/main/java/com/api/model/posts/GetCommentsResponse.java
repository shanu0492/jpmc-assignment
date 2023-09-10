package com.api.model.posts;

import lombok.Data;

@Data
public class GetCommentsResponse {

    private int id;
    private int postId;
    private String email;
    private String body;
    private String name;

}
