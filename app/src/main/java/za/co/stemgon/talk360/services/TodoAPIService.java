package za.co.stemgon.talk360.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import za.co.stemgon.talk360.models.Todo;

public interface TodoAPIService {
    @GET("todos")
    Call<List<Todo>> getTodos();
}
