package com.example.petboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.petboarding.user.User;
import com.example.petboarding.util.AppDB;

public class RegisterFragment extends Fragment {

    Button registration;
    EditText username, email, password;

    Button owner, freelance;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        registration = view.findViewById(R.id.register_btn);
        username = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);

        owner = view.findViewById(R.id.owner_btn);
        freelance = view.findViewById(R.id.freelance_btn);

        final boolean[] userOwner = {true};

        owner.setOnClickListener(view1 -> {
            userOwner[0] = true;
        });
        freelance.setOnClickListener(view1 -> {
            userOwner[0] = false;
        });

        registration.setOnClickListener(view1 -> {
            if(!username.getText().toString().equals("") && !email.getText().toString().equals("") && !password.getText().toString().equals("")){
                User regUser = new User(
                        username.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString()
                );
                AppDB.getInstance(getContext()).userDao().addUser(regUser);
                int userID = AppDB.getInstance(getContext()).userDao().getUserIdByUsername(regUser.getUsername());
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                intent.putExtra("USER_ID",userID);
                startActivity(intent);
            }else{
                Toast.makeText(getActivity(), "Some credentials are empty",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}