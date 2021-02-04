package com.joncabdev.navigationtest.fragments;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.joncabdev.navigationtest.R;
import com.joncabdev.navigationtest.db.entity.ProductosEntity;

public class NuevoProductoDialogFragment extends DialogFragment {

    private NuevoProductoDialogViewModel mViewModel;
    private View view;
    private TextInputEditText textMarca, textProdcuto, textDepartamento, textCantidad, textMedida, textPrecio;

    public static NuevoProductoDialogFragment newInstance() {
        return new NuevoProductoDialogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nuevo_producto_dialog_fragment, container, false);
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_create_product_title);
        builder.setMessage(R.string.dialog_create_product)
                .setPositiveButton(R.string.btn_guardar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String marca = textMarca.getText().toString();
                        String producto = textProdcuto.getText().toString();
                        String departamento = textDepartamento.getText().toString();
                        float cantidad = Float.valueOf(textCantidad.getText().toString());
                        String medida = textMedida.getText().toString();
                        float precio = Float.valueOf(textPrecio.getText().toString());

                        NuevoProductoDialogViewModel mViewModel = new ViewModelProvider(getActivity()).get(NuevoProductoDialogViewModel.class);
                        mViewModel.insertarProducto(new ProductosEntity(marca,producto,cantidad,medida,precio,departamento));
                        dialog.dismiss();

                    }


                })
                .setNegativeButton(R.string.btn_cancelar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });

        LayoutInflater inflater = getActivity().getLayoutInflater();

        view = inflater.inflate(R.layout.nuevo_producto_dialog_fragment, null);

        textMarca = view.findViewById(R.id.text_marca);
        textProdcuto = view.findViewById(R.id.text_tipo);
        textDepartamento = view.findViewById(R.id.text_departamento);
        textCantidad = view.findViewById(R.id.text_cantidad);
        textMedida = view.findViewById(R.id.text_medida);
        textPrecio = view.findViewById(R.id.text_cantidad);



        builder.setView(view);
        // Create the AlertDialog object and return it
        return builder.create();
    }




}