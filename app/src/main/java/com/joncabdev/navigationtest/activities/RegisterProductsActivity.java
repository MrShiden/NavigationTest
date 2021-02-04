package com.joncabdev.navigationtest.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModel;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.joncabdev.navigationtest.R;
import com.joncabdev.navigationtest.clases.ConexionSQLiteHelper;
import com.joncabdev.navigationtest.databinding.ActivityRegisterProductsBinding;
import com.joncabdev.navigationtest.utilidades.Utilidades;

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

        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               registrarProductos();

            }
        });

    }

    //TODO: checar si se escribrio la base de datos 

    private void registrarProductos() {

        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(RegisterProductsActivity.this, "BD_Productos", null, 1);

        SQLiteDatabase db = conexion.getWritableDatabase();

        String id = "4";



        ContentValues values = new ContentValues();

        values.put(Utilidades.ID_PRODUCTO,id);
        values.put(Utilidades.MARCA,binding.textMarca.getText().toString());
        values.put(Utilidades.TIPO,binding.textTipo.getText().toString());
        values.put(Utilidades.DEPARTAMENTO,binding.textDepartamento.getText().toString());
        values.put(Utilidades.CANTIDAD,binding.textCantidad.getText().toString());
        values.put(Utilidades.MEDIDA,binding.textMedida.getText().toString());
        values.put(Utilidades.PRECIO,binding.textPrecio.getText().toString());

        Long idResultados = db.insert(Utilidades.TABLA_PRODUCTOS,Utilidades.ID_PRODUCTO,values);

        Toast.makeText(this, "id Registro: " + idResultados, Toast.LENGTH_SHORT).show();



    }
}