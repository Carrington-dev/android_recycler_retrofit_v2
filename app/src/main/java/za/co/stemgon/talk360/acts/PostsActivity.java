package za.co.stemgon.talk360.acts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import za.co.stemgon.talk360.R;
import za.co.stemgon.talk360.adapters.PostsAdapter;
import za.co.stemgon.talk360.models.Post;
import za.co.stemgon.talk360.services.PostsAPIService;

public class PostsActivity extends AppCompatActivity {
    RecyclerView postsRecyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);


        postsRecyclerView = findViewById(R.id.postsRecyclerView);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostsAPIService postsAPIService = retrofit.create(PostsAPIService.class);

        Call<List<Post>> call = postsAPIService.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(PostsActivity.this, "Code: "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Post> posts = response.body();
                assert posts != null;
                List<Post> postLists = new ArrayList<Post>(posts);
                PostsAdapter postsAdapter = new PostsAdapter(PostsActivity.this, postLists);
                postsRecyclerView.setLayoutManager(new LinearLayoutManager(PostsActivity.this));
                postsRecyclerView.setAdapter(postsAdapter);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(PostsActivity.this, "API Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}