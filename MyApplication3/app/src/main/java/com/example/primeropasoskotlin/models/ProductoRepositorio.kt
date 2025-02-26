package com.example.primeropasoskotlin.models

import android.content.ContentValues
import android.content.Context
import com.example.primeropasoskotlin.db.AdminSQLiteOpenHelper

class ProductoRepositorio(context:Context) {

    private val adminSQLiteOpenHelper: AdminSQLiteOpenHelper = AdminSQLiteOpenHelper(context, "administracion", null, 1)

    fun insertProduc(producto: Productos): Int {
        return try {
            val db = adminSQLiteOpenHelper.writableDatabase
            val registro = ContentValues().apply {
                put("id_producto", producto.getIdProducto())
                put("id_categoria", producto.getIdCategoria())
                put("id_proveedor", producto.getIdProveedor())
                put("nombre", producto.getNombre())
                put("precio", producto.getPrecio())
            }
            db.insert("producto", null, registro)
            db.close()
            1
        } catch (e: Exception) {
            0
        }
    }

    fun buscarProductoPorId(id: String): Productos? {
        val db = adminSQLiteOpenHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM producto WHERE id_producto=$id", null)

        return if (cursor.moveToFirst()) {
            val id_producto: Int = cursor.getInt(cursor.getColumnIndexOrThrow("id_producto")).toInt()
            val id_categoria = cursor.getInt(cursor.getColumnIndexOrThrow("id_categoria"))
            val id_proveedor = cursor.getInt(cursor.getColumnIndexOrThrow("id_proveedor"))
            val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
            val precio = cursor.getInt(cursor.getColumnIndexOrThrow("precio"))
            cursor.close()
            Productos(id_producto,id_categoria,id_proveedor, nombre, precio.toDouble())
        } else {
            cursor.close()
            null
        }
    }

   /*fun getAll(): MutableList<Productos> {
        val names = mutableListOf<Productos>()
        val db = adminSQLiteOpenHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM producto", null)
        if (cursor.moveToFirst()) {
            do {
                names.add(Productos(cursor.getString(cursor.getColumnIndexOrThrow("id_categoria")).toInt(), cursor.getString(cursor.getColumnIndexOrThrow("nombre")), cursor.getString(cursor.getColumnIndexOrThrow("descripcion"))))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return names
    }*/

    // Eliminar un producto (aún no implementado completamente)
    fun deletePro(producto: Productos): Int {

        return 1
    }

    // Actualizar un producto (aún no implementado completamente)
    fun updatePro(producto: Productos): Int {

        return 1
    }
}