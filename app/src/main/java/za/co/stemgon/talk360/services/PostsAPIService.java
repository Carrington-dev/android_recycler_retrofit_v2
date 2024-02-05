package za.co.stemgon.talk360.services;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import za.co.stemgon.talk360.models.Post;

public interface PostsAPIService {

    @GET("posts")
    Call<List<Post>> getPosts();
}