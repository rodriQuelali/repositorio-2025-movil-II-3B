package com.example.primeropasoskotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.primeropasoskotlin.models.Venta
import com.example.primeropasoskotlin.models.VentasDao
import com.example.primeropasoskotlin.models.VentasRepositorio

class VentasViewModel(aplication:Application): AndroidViewModel(aplication){
    private val ventasDao:VentasDao

    init {
        val ventasRepositorio = VentasRepositorio(aplication)
        ventasDao = VentasDao(ventasRepositorio)
    }
    fun insertarVentas(venta: Venta):Int{
        return ventasDao.insertarVentas(venta)
    }
}