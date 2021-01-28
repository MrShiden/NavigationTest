package com.joncabdev.navigationtest.pojo;


public class Productos {

    private String marca;
    private String tipo;
    private String cantidad;
    private String medida;
    private boolean favorito;
    private String departamento;

    public Productos(String marca, String tipo, String cantidad, String medida, boolean favorito, String departamento) {
        this.marca = marca;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.medida = medida;
        this.favorito = favorito;
        this.departamento = departamento;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}