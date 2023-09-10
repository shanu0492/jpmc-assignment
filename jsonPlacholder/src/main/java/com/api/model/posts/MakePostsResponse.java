package com.api.model.posts;

import lombok.Data;

@Data
public class MakePostsResponse {

    private int userId;
    private int id;
    private String title;
    private String body;
}
