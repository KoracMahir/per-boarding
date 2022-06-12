package com.example.petboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SplashFragment extends Fragment {

    Button get_started;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        get_started = view.findViewById(R.id.get_started);

        get_started.setOnClickListener(view1 -> {
            LoginFragment loginFragment = new LoginFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, loginFragment).commit();
        });

        return view;
    }

}