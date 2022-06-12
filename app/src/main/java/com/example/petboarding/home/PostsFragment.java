package com.example.petboarding.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.petboarding.R;
import com.example.petboarding.add.AddNewActivity;
import com.example.petboarding.add.AddNewPostActivity;
import com.example.petboarding.details.DetailsActivity;
import com.example.petboarding.jobs.Job;
import com.example.petboarding.jobs.JobAdapter;
import com.example.petboarding.posts.Post;
import com.example.petboarding.posts.PostAdapter;
import com.example.petboarding.util.AppDB;

import java.util.List;

public class PostsFragment extends Fragment {

    ListView listView;
    View back,add;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        listView=view.findViewById(R.id.postsList);
        back =view.findViewById(R.id.back);
        add =view.findViewById(R.id.add);

        List<Post> posts = AppDB.getInstance(getContext()).postDao().getAll();
        PostAdapter adapter = new PostAdapter(getContext(), posts);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view1, i, l) -> {
            Post post =(Post) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(getContext(), DetailsActivity.class);
            intent.putExtra("ID", post.getId());
            intent.putExtra("DETAIL_TYPE", "POST");
            startActivity(intent);
        });

        back.setOnClickListener(view1 -> {
            getActivity().finish();
        });

        add.setOnClickListener(view1->{
            Intent intent = new Intent(getContext(), AddNewPostActivity.class);
            startActivity(intent);
        });

        return view;
    }
}