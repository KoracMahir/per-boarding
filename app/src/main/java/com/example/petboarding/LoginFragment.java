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

public class LoginFragment extends Fragment {

    Button login,register;
    EditText email, password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        login = view.findViewById(R.id.login_btn);
        register = view.findViewById(R.id.register_btn);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);

        login.setOnClickListener(view1 -> {
            if(!email.getText().toString().equals("") && !password.getText().toString().equals("")){
                User user = AppDB.getInstance(getContext()).userDao().checkLogin(email.getText().toString(),
                        password.getText().toString());
                if(user!=null){
                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    intent.putExtra("USER_ID", user.getId());
                    startActivity(intent);
                }else{
                    Toast.makeText(getActivity(), "Login incorrect",Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(getActivity(), "Login credentials empty",Toast.LENGTH_LONG).show();
            }


        });

        register.setOnClickListener(view1 ->{
            RegisterFragment registerFragment = new RegisterFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, registerFragment).commit();
        });

        return view;
    }
}