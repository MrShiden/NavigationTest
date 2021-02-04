package com.joncabdev.navigationtest.clases;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.joncabdev.navigationtest.db.dao.ProductosDao;
import com.joncabdev.navigationtest.db.entity.ProductosEntity;

import java.util.List;

public class ProductoRepository {
    private ProductosDao productosDao;
    private LiveData<List<ProductosEntity>> allNotas;
    public ProductoRepository(Application application){

        ProductoRoomDatabase db = ProductoRoomDatabase.getDatebase(application);
        productosDao = db.productosDao();
        allNotas = productosDao.getAll();



    }

    public LiveData<List<ProductosEntity>> getAll() {return allNotas;}

    public void insert (ProductosEntity prodcutos){

        new insertAsyncTask(productosDao).execute(prodcutos);

    }

    private static class insertAsyncTask extends AsyncTask<ProductosEntity, Void,Void>{
        private  ProductosDao productosDaoAsyncTask;

        insertAsyncTask(ProductosDao dao){
            productosDaoAsyncTask = dao;
        }


        @Override
        protected Void doInBackground(ProductosEntity... productosEntities) {
            productosDaoAsyncTask.insert(productosEntities[0]);
            return null;
        }
    }





}
