package com.joncabdev.navigationtest.utilidades;

import com.joncabdev.navigationtest.pojo.Productos;

public class Utilidades {

    //Constantes
    public static final String TABLA_PRODUCTOS = "PRODUCTOS";
    public static final String MARCA = "productos";
    public static final String TIPO = "productos";
    public static final String CANTIDAD = "productos";
    public static final String MEDIDA = "productos";
    public static final String FAVORITO = "productos";
    public static final String DEPARTAMENTO = "productos";


   public static final String CREAR_TABLA_PRODUCTOS = "CREATE TABLE"+ TABLA_PRODUCTOS +  "  ("+ MARCA +" TEXT, "+ TIPO+" TEXT, " +CANTIDAD + " TEXT, "+ MEDIDA + " TEXT, " + FAVORITO +" BOOLEAN, "+ DEPARTAMENTO +" TEXT )";
}
