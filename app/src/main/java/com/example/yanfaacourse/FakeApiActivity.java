package com.example.yanfaacourse;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// The correct binding class name based on "activity_fake_api.xml"
import com.example.yanfaacourse.databinding.ActivityFakeApiBinding;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Class name is now FakeApiActivity
public class FakeApiActivity extends AppCompatActivity {

    // Use the new, correct binding class
    private ActivityFakeApiBinding binding;

    private ArrayAdapter<String> adapter;
    private ArrayList<String> postTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using the new binding class
        binding = ActivityFakeApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Access views through the correct binding object
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, postTitles);
        binding.listView.setAdapter(adapter);

        fetchPosts();
    }

    private void fetchPosts() {
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.listView.setVisibility(View.GONE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Post>> call = apiService.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                binding.progressBar.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null) {
                    binding.listView.setVisibility(View.VISIBLE);
                    List<Post> posts = response.body();
                    postTitles.clear();
                    for (Post post : posts) {
                        postTitles.add(post.getTitle());
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(FakeApiActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(FakeApiActivity.this, "Network Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}