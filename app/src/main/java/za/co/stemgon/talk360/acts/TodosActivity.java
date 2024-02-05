package za.co.stemgon.talk360.acts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import za.co.stemgon.talk360.adapters.TodoAdapter;
import za.co.stemgon.talk360.models.Todo;
import za.co.stemgon.talk360.services.TodoAPIService;

public class TodosActivity extends AppCompatActivity {
    RecyclerView todoRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        todoRecyclerView = findViewById(R.id.todosRecyclerview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoAPIService todoAPIService = retrofit.create(TodoAPIService.class);

        Call<List<Todo>> todosApiList = todoAPIService.getTodos();
        todosApiList.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(TodosActivity.this, "Failed to fetch the tods", Toast.LENGTH_SHORT).show();
                }

                List<Todo> todoList = response.body();
                if( todoList != null ){
                    List<Todo> myTodoList = new ArrayList<>(todoList);
                    TodoAdapter todoAdapter = new TodoAdapter(TodosActivity.this, myTodoList);
                    todoRecyclerView.setLayoutManager(new LinearLayoutManager(TodosActivity.this));
                    todoRecyclerView.setAdapter(todoAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Toast.makeText(TodosActivity.this, "Failed to fetch the tods", Toast.LENGTH_SHORT).show();
            }
        });


    }
}