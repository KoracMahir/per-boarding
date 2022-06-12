package com.example.petboarding.add;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.petboarding.R;
import com.example.petboarding.posts.Post;
import com.example.petboarding.util.AppDB;

public class AddNewPostActivity extends AppCompatActivity {

    View save;
    EditText title,description,imageurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_post);

        title=findViewById(R.id.postTitle);
        description=findViewById(R.id.postDescription);
        imageurl=findViewById(R.id.imageUrl);
        save =findViewById(R.id.save);
        save.setOnClickListener(view1-> {
            Post newPost = new Post(
                    title.getText().toString(),
                    description.getText().toString(),
                    imageurl.getText().toString()
            );
            AppDB.getInstance(this).postDao().addPost(newPost);
            finish();
        });
    }
}