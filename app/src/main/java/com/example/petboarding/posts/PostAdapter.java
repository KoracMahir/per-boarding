package com.example.petboarding.posts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.petboarding.R;
import com.example.petboarding.jobs.Job;
import com.example.petboarding.util.AppDB;

import java.util.List;

public class PostAdapter extends BaseAdapter {

    private List<Post> postList;
    private Context context;

    public PostAdapter(Context context, List<Post> postList){
        this.context = context;
        this.postList = postList;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int i) {
        return postList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return postList.indexOf(postList.get(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.post_layout_item, viewGroup, false);
        Post post = (Post) getItem(i);

        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);
        TextView upVotes = view.findViewById(R.id.postUpvotes);
        View upvote = view.findViewById(R.id.upvote);
        ImageView image = view.findViewById(R.id.imageUrl);

        upvote.setOnClickListener(view1->{
            int newUpvote = AppDB.getInstance(context).postDao().getPostByID(post.getId()).getUpVotes()+1;
            AppDB.getInstance(context).postDao().updateUpVotes(newUpvote, post.getId());
            upVotes.setText("Upvotes: "+newUpvote);
        });

        title.setText(post.getPostTitle());
        description.setText(post.getPostDescription());
        upVotes.setText("Upvotes: "+post.getUpVotes());
        try{
            Glide.with(context)
                    .load(post.getPostImageUrl())
                    .centerCrop()
                    .into(image);
        }catch (Exception exception){

        }

        return view;
    }
}
