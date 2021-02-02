package com.joncabdev.navigationtest.utilidades;

import com.joncabdev.navigationtest.pojo.Productos;

public class Utilidades {

    //Constantes


    public static final String ID_PRODUCTO = "ID_PRODUCTO";
    public static final String TABLA_PRODUCTOS = "PRODUCTOS";
    public static final String MARCA = "MARCA";
    public static final String TIPO = "TIPO";
    public static final String CANTIDAD = "CANTIDAD";
    public static final String MEDIDA = "MEDIDA";
    public static final String PRECIO = "PRECIO";
    public static final String DEPARTAMENTO = "DEPARTAMENTO";


   public static final String CREAR_TABLA_PRODUCTOS =  "CREATE TABLE " + TABLA_PRODUCTOS +  "  ( " + ID_PRODUCTO+ " TEXT, " + MARCA +" TEXT, "+ TIPO+" TEXT, " +CANTIDAD + " TEXT, "+ MEDIDA + " TEXT, " + PRECIO +" TEXT, "+ DEPARTAMENTO +" TEXT )";
}
