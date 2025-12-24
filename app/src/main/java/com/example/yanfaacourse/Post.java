package com.example.yanfaacourse;

public class Post {
    private int userId;
    private int id;
    private String title;
    private String body; // 'body' in JSON is named 'text' in the API documentation, but the actual key is 'body'
    // Getters
    public int getUserId() {
        return userId;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }

}
