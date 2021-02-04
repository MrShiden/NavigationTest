package com.joncabdev.navigationtest.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "productosRoom")
public class ProductosEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String marca;
    public String tipo;
    public float cantidad;
    public String medida;
    public float precio;
    public String departamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public ProductosEntity(String marca, String tipo, float cantidad, String medida, float precio, String departamento) {
        this.marca = marca;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.medida = medida;
        this.precio = precio;
        this.departamento = departamento;


    }
}


