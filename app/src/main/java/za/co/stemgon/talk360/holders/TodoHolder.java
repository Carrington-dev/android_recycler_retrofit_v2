package za.co.stemgon.talk360.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import za.co.stemgon.talk360.R;

public class TodoHolder extends RecyclerView.ViewHolder {
    public TextView todoId, todoTitle, todoAuthorName;
    public ImageView todoIcon;
    public TodoHolder(@NonNull View itemView) {
        super(itemView);

        todoIcon = itemView.findViewById(R.id.todo_icon);
        todoId = itemView.findViewById(R.id.todo_id);
        todoTitle = itemView.findViewById(R.id.todo_title);
        todoAuthorName = itemView.findViewById(R.id.todo_author);
    }
}
