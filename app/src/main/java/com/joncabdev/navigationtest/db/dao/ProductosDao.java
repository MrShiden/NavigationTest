package com.joncabdev.navigationtest.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.joncabdev.navigationtest.db.entity.ProductosEntity;

import java.util.List;

@Dao
public interface ProductosDao {
    @Insert
    void insert(ProductosEntity producto);

    @Update
    void update(ProductosEntity producto);

    @Query("DELETE FROM productosRoom")
    void deleteAll();

    @Query("DELETE FROM productosRoom WHERE id = :idNota")
    void deleteById(int idNota);

   /* @Query("SELECT * FROM productosRoom WHERE departamento = :departamento ORDER BY id ASC")
    void selectDepartamento(String departamento);*/

    //LiveData permite que se este actualizando la informacion en el proceso
    @Query("SELECT * FROM productosRoom ORDER BY marca ASC")
   LiveData<List<ProductosEntity>> getAll();

    @Query("SELECT * FROM productosRoom WHERE departamento = :departamento ORDER BY id ASC")
    LiveData<List<ProductosEntity>> getDepartamentos(String departamento);


}
