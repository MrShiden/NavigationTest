package com.joncabdev.navigationtest.clases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.joncabdev.navigationtest.db.dao.ProductosDao;
import com.joncabdev.navigationtest.db.entity.ProductosEntity;

@Database(entities = {ProductosEntity.class}, version = 1)
public abstract class ProductoRoomDatabase extends RoomDatabase {
    public abstract ProductosDao productosDao();
    private static volatile ProductoRoomDatabase INSTANCE;


    public static ProductoRoomDatabase getDatebase(final Context context){
        if (INSTANCE == null){
            synchronized (ProductoRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),ProductoRoomDatabase.class, "productos_database")
                            .build();
                }
            }

        }
        return INSTANCE;
    }


}
