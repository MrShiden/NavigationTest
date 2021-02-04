package com.joncabdev.navigationtest.fragments;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.joncabdev.navigationtest.clases.ProductoRepository;
import com.joncabdev.navigationtest.db.entity.ProductosEntity;

import java.util.List;

public class NuevoProductoDialogViewModel extends AndroidViewModel {
    private LiveData<List<ProductosEntity>> allProducts;
    private ProductoRepository productoRepository;

    public NuevoProductoDialogViewModel(Application application){
        super(application);

        productoRepository = new ProductoRepository(application);
        allProducts = productoRepository.getAll();
    }

    //Fragment que recibe lista de datos
    public LiveData<List<ProductosEntity>>getAllProducts(){return allProducts;}

    //Fragment que inserte una nuvo producto
    public void insertarProducto(ProductosEntity productosEntity){productoRepository.insert(productosEntity);}



}