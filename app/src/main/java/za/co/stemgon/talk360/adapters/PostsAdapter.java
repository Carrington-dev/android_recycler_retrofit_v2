package za.co.stemgon.talk360.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import za.co.stemgon.talk360.R;
import za.co.stemgon.talk360.holders.PostHolder;
import za.co.stemgon.talk360.models.Post;

public class PostsAdapter extends RecyclerView.Adapter<PostHolder> {
    Context mContext;
    List<Post> postList;

    public PostsAdapter(Context mContext, List<Post> postList) {
        this.mContext = mContext;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostHolder(LayoutInflater.from(mContext).inflate(R.layout.post_layout, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.idView.setText(Integer.toString(postList.get(position).getId()));

        holder.titleView.setText(postList.get(position).getTitle());
        holder.bodyView.setText(postList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
