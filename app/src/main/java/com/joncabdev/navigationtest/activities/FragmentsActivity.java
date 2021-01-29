package com.joncabdev.navigationtest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.joncabdev.navigationtest.databinding.ActivityFragmentsBinding;
import com.joncabdev.navigationtest.interfaces.ComunicationInterface;

public class FragmentsActivity extends AppCompatActivity implements ComunicationInterface {
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


    @Override
    public void gotoCreateProducto() {

        Intent i = new Intent(this , RegisterProductsActivity.class);

        startActivity(i);

    }


}

