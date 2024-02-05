package za.co.stemgon.talk360.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import za.co.stemgon.talk360.R;

public class PostHolder extends RecyclerView.ViewHolder {
    public TextView idView, titleView, bodyView;


    public PostHolder(@NonNull View itemView) {
        super(itemView);

        idView = itemView.findViewById(R.id.post_id);
        titleView = itemView.findViewById(R.id.post_title);
        bodyView = itemView.findViewById(R.id.post_body);
    }
}
