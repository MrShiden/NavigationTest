package com.joncabdev.navigationtest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.joncabdev.navigationtest.databinding.ActivityFragmentsBinding;
import com.joncabdev.navigationtest.fragments.FirstFragment;
import com.joncabdev.navigationtest.interfaces.ComunicationInterface;

public class FragmentsActivity extends AppCompatActivity implements ComunicationInterface {
    ActivityFragmentsBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //Pare tener support del action bar se tiene que llamar primero a esta parte
        setSupportActionBar(binding.toolbar);
        toolBarActions();
        Intent i = new Intent(this, MainActivity.class);


        //Codigo para habilitar el suport del action bar



    }

    private void toolBarActions() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Navigation-Test");
    }


    @Override
    public void gotoCreateProducto() {

        Intent i = new Intent(this, RegisterProductsActivity.class);

        startActivity(i);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;

    }


}

