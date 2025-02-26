package com.example.primeropasoskotlin.models

import android.content.ContentValues
import android.content.Context
import com.example.primeropasoskotlin.db.AdminSQLiteOpenHelper

class VentasRepositorio (context: Context){

    private val adminSQLiteOpenHelper: AdminSQLiteOpenHelper = AdminSQLiteOpenHelper(context, "administracion", null, 1)

    fun insertVentas(venta: Venta): Int {
        return try {
            val db = adminSQLiteOpenHelper.writableDatabase
            val registro = ContentValues().apply {
                put("id_venta", venta.getIdVenta())
                put("id_producto", venta.getIdProducto())
                put("cantidad", venta.getCantidad())
                put("precio_total", venta.getPrecioTotal())
                put("cliente", venta.getCliente())
                put("fecha", venta.getFecha())
            }
            db.insert("ventas", null, registro)
            db.close()
            1
        } catch (e: Exception) {
            0
        }
    }
}