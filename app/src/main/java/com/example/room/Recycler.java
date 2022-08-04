package com.example.room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler extends RecyclerView.Adapter<Recycler.viewHolder> {

    ArrayList<Post> posts;

    public Recycler (ArrayList<Post> posts){
        this.posts = posts;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_adpater
                , parent,false);
        viewHolder vh = new viewHolder(v);

        return  vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Post post = posts.get(position);
        holder.tv_title.setText(post.getTitle());
        holder.tv_body.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tv_title , tv_body;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.cutom_title);
            tv_body = itemView.findViewById(R.id.custom_body);
        }
    }
}
