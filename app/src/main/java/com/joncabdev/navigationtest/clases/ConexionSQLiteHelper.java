package com.joncabdev.navigationtest.clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    final String CREAR_TABLA_PRODUCTOS = "CREATE TABLE PRODUCTOS (MARCA TEXT, TIPO TEXT, CANTIDAD TEXT, MEDIDA TEXT, FAVORITO BOOLEAN, DEPARTAMENTO TEXT )";

    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREAR_TABLA_PRODUCTOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCTOS");
        onCreate(db);

    }
}
