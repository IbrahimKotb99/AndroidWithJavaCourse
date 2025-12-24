package com.example.yanfaacourse;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

    public interface ApiService {
        // This defines the endpoint for getting the posts.
        // The full URL will be "https://jsonplaceholder.typicode.com/posts"
        @GET("posts")
        Call<List<Post>> getPosts();

    }

