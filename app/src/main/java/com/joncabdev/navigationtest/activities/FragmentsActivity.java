package com.joncabdev.navigationtest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;
import com.joncabdev.navigationtest.R;
import com.joncabdev.navigationtest.adapters.ProductosAdapter;
import com.joncabdev.navigationtest.databinding.ActivityFragmentsBinding;
import com.joncabdev.navigationtest.fragments.FirstFragment;
import com.joncabdev.navigationtest.interfaces.ProductosInteractionListener;
import com.joncabdev.navigationtest.pojo.Productos;

public class FragmentsActivity extends AppCompatActivity {
    ActivityFragmentsBinding binding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setSupportActionBar(binding.toolbar);
        Intent i = new Intent(this, MainActivity.class);




        /*binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               *//* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*//*

                startActivity(i);


            }
        });*/
    }



}