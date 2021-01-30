package com.joncabdev.navigationtest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.joncabdev.navigationtest.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    
    ActivityMainBinding binding;
    MaterialButton btnWelcome;
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        binding.btnWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FragmentsActivity.class );
                startActivity(i);
            }
        });



    }
}