package com.example.petboarding.details;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.petboarding.R;
import com.example.petboarding.jobs.Job;
import com.example.petboarding.posts.Post;
import com.example.petboarding.util.AppDB;

public class PostDetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_post, container, false);

        int id = getActivity().getIntent().getIntExtra("ID",-1);

        Post post = AppDB.getInstance(getContext()).postDao().getPostByID(id);

        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);
        TextView upVotes = view.findViewById(R.id.postUpvotes);
        View upvote = view.findViewById(R.id.upvote);

        upvote.setOnClickListener(view1->{
            int newUpvote = AppDB.getInstance(getContext()).postDao().getPostByID(post.getId()).getUpVotes()+1;
            AppDB.getInstance(getContext()).postDao().updateUpVotes(newUpvote, post.getId());
            upVotes.setText("Upvotes: "+newUpvote);
        });

        title.setText(post.getPostTitle());
        description.setText(post.getPostDescription());
        upVotes.setText("Upvotes: "+post.getUpVotes());

        return view;
    }
}