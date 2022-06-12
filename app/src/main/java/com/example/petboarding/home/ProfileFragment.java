package com.example.petboarding.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.petboarding.R;
import com.example.petboarding.user.User;
import com.example.petboarding.util.AppDB;

public class ProfileFragment extends Fragment {

    EditText username, email, password;
    Button save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        save = view.findViewById(R.id.save);
        username = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);

        int id = getActivity().getIntent().getIntExtra("USER_ID",-1);

        User user = AppDB.getInstance(getContext()).userDao().getUserIdByID(id);

        username.setText(user.getUsername());
        email.setText(user.getEmail());
        password.setText(user.getPassword());


        save.setOnClickListener(view1-> {
            User updateUser = new User(
                    id,
                    username.getText().toString(),
                    email.getText().toString(),
                    password.getText().toString()
            );
            AppDB.getInstance(getContext()).userDao().updateUser(updateUser);
        });
        return view;
    }
}