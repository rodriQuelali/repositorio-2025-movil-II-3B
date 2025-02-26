package com.example.primeropasoskotlin.models

import android.content.ContentValues
import android.content.Context
import com.example.primeropasoskotlin.db.AdminSQLiteOpenHelper

class CategoriaRepositorio(context: Context) {

    private val adminSQLiteOpenHelper: AdminSQLiteOpenHelper = AdminSQLiteOpenHelper(context, "administracion", null, 1)

    fun insertCategoria(categoria: Categoria): Int {
        return try {
            val db = adminSQLiteOpenHelper.writableDatabase
            val registro = ContentValues().apply {
                put("id_categoria", categoria.getIdCategoria())
                put("nombre", categoria.getNombre())
                put("descripcion", categoria.getDescripcion())
            }
            db.insert("categoria", null, registro)
            db.close()
            1
        } catch (e: Exception) {
            0
        }
    }

    fun getAll(): MutableList<Categoria> {
        val names = mutableListOf<Categoria>()
        val db = adminSQLiteOpenHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM categoria", null)
        if (cursor.moveToFirst()) {
            do {
                names.add(Categoria(cursor.getString(cursor.getColumnIndexOrThrow("id_categoria")).toInt(), cursor.getString(cursor.getColumnIndexOrThrow("nombre")), cursor.getString(cursor.getColumnIndexOrThrow("descripcion"))))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return names
    }


    fun buscarCategoriaPorId(id: String): Categoria? {
        val db = adminSQLiteOpenHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM categoria WHERE id_categoria=$id", null)

        return if (cursor.moveToFirst()) {
            val id_categoria: Int = cursor.getInt(cursor.getColumnIndexOrThrow("id_categoria")).toInt()
            val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
            val descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"))
            cursor.close()
            Categoria(id_categoria, nombre, descripcion.toString())
        } else {
            cursor.close()
            null
        }
    }
    // Eliminar un producto (aún no implementado completamente)
    fun deleteCate(producto: Productos): Int {

        return 1
    }

    // Actualizar un producto (aún no implementado completamente)
    fun updateCate(producto: Productos): Int {

        return 1
    }
}