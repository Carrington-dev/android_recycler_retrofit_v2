package za.co.stemgon.talk360;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

import za.co.stemgon.talk360.acts.PostsActivity;
import za.co.stemgon.talk360.acts.TodosActivity;

public class MainActivity extends AppCompatActivity {
    Button goToPostsViewButton, goToTodoListViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToPostsViewButton = findViewById(R.id.goToPostsViewButton);
        goToPostsViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostsActivity.class);
                startActivity(intent);
            }
        });

        goToTodoListViewButton = findViewById(R.id.goToTodosViewButton);
        goToTodoListViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TodosActivity.class);
                startActivity(intent);
            }
        });



    }


}