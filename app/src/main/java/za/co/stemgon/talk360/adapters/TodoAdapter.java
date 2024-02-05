package za.co.stemgon.talk360.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import za.co.stemgon.talk360.R;
import za.co.stemgon.talk360.holders.TodoHolder;
import za.co.stemgon.talk360.models.Todo;

public class TodoAdapter extends RecyclerView.Adapter<TodoHolder> {
    Context mContext;
    List<Todo> todosList;

    public TodoAdapter(Context mContext, List<Todo> todosList) {
        this.mContext = mContext;
        this.todosList = todosList;
    }

    @NonNull
    @Override
    public TodoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TodoHolder(LayoutInflater.from(mContext).inflate(R.layout.todo_layout, parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TodoHolder holder, int position) {
        holder.todoId.setText(Integer.toString(todosList.get(position).getId()));
        holder.todoTitle.setText(todosList.get(position).getTitle());
        holder.todoAuthorName.setText("Harrington Muleya");

        if(todosList.get(position).isCompleted()){
            holder.todoIcon.setImageResource(R.drawable.baseline_arrow_upward_24);
        }else {
            holder.todoIcon.setImageResource(R.drawable.baseline_arrow_downward_24);
        }

    }

    @Override
    public int getItemCount() {
        return todosList.size();
    }
}
