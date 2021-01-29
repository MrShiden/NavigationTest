package com.joncabdev.navigationtest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.joncabdev.navigationtest.R;
import com.joncabdev.navigationtest.databinding.ActivityRegisterProductsBinding;

public class RegisterProductsActivity extends AppCompatActivity {

    ActivityRegisterProductsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityRegisterProductsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        onItemSelected();
    }

    private void onItemSelected() {
        binding.btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}