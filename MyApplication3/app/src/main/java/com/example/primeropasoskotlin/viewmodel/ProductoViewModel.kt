package com.example.primeropasoskotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.primeropasoskotlin.models.Categoria
import com.example.primeropasoskotlin.models.ProductoDao
import com.example.primeropasoskotlin.models.ProductoRepositorio
import com.example.primeropasoskotlin.models.Productos

class ProductoViewModel(aplication:Application):AndroidViewModel(aplication) {

    private val productoDao:ProductoDao
    init {
        val productoRepositorio = ProductoRepositorio(aplication)
        productoDao = ProductoDao(productoRepositorio)
    }

    fun insertarProducto(productos: Productos):Int{
        return  productoDao.insertarProducto(productos)
    }

    fun buscarProductoPorId(id:String): Productos?{
        return productoDao.buscarProductoPorId(id)
    }
}