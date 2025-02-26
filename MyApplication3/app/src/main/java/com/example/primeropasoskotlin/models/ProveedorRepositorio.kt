package com.example.primeropasoskotlin.models

import android.content.ContentValues
import android.content.Context
import com.example.primeropasoskotlin.db.AdminSQLiteOpenHelper

class ProveedorRepositorio(context: Context) {

    private val adminSQLiteOpenHelper: AdminSQLiteOpenHelper = AdminSQLiteOpenHelper(context, "administracion", null, 1)

    fun insertProveedor(proveedor: Proveedor): Int {
        return try {
            val db = adminSQLiteOpenHelper.writableDatabase
            val registro = ContentValues().apply {
                put("id_proveedor", proveedor.getIdProveedor())
                put("nombre", proveedor.getNombre())
                put("nit", proveedor.getNit())
                put("direccion", proveedor.getDireccion())
            }
            db.insert("proveedor", null, registro)
            db.close()
            1
        } catch (e: Exception) {
            0
        }
    }

    fun buscarProveedorPorId(id: String): Proveedor? {
        val db = adminSQLiteOpenHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM proveedor WHERE id_proveedor=$id", null)

        return if (cursor.moveToFirst()) {
            val id_proveedor:Int = cursor.getInt(cursor.getColumnIndexOrThrow("id_proveedor")).toInt()
            val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
            val nit:Int = cursor.getInt(cursor.getColumnIndexOrThrow("nit")).toInt()
            val direccion = cursor.getString(cursor.getColumnIndexOrThrow("direccion"))
            cursor.close()
            Proveedor(id_proveedor, nombre, nit, direccion.toString())
        } else {
            cursor.close()
            null
        }
    }

}