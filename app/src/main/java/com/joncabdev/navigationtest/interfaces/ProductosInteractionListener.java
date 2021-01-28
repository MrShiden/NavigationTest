package com.joncabdev.navigationtest.interfaces;

import com.joncabdev.navigationtest.pojo.Productos;

public interface ProductosInteractionListener {
    void editProducto(int position);
    void eliminarProducto(int position);
    void favoritaProducto(int position);
    void onItemClick(int position);
    void onLongItemClcik(int position);
}