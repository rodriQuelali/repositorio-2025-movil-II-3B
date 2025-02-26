package com.example.primeropasoskotlin.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class AdminSQLiteOpenHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE producto( " +
                "id_producto INTEGER PRIMARY KEY, " +
                "id_categoria INTEGER, " +
                "id_proveedor INTEGER, " +
                "nombre TEXT, " +
                "precio REAL, " +
                "FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor), " +
                "FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria))"
        )

        db?.execSQL("CREATE TABLE categoria( " +
                "id_categoria INTEGER PRIMARY KEY, " +
                "nombre TEXT, " +
                "descripcion TEXT)"
        )

        db?.execSQL("CREATE TABLE proveedor( " +
                "id_proveedor INTEGER PRIMARY KEY, " +
                "nombre TEXT, " +
                "nit INTEGER, " +
                "direccion TEXT)"
        )

        db?.execSQL("CREATE TABLE ventas( " +
                "id_venta INTEGER PRIMARY KEY, " +
                "id_producto INTEGER, " +
                "cantidad INTEGER, " +
                "precio_total REAL, " +
                "cliente TEXT," +
                "fecha TEXT," +
                "FOREIGN KEY (id_producto) REFERENCES producto(id_producto))"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS producto")
        db?.execSQL("DROP TABLE IF EXISTS categoria")
        db?.execSQL("DROP TABLE IF EXISTS proveedor")
        db?.execSQL("DROP TABLE IF EXISTS ventas")
        onCreate(db)
    }
}