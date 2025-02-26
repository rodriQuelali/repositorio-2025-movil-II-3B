package com.example.primeropasoskotlin.models

class VentasDao (private val ventasRepositorio: VentasRepositorio){

    fun insertarVentas(venta: Venta):Int{
        return ventasRepositorio.insertVentas(venta)
    }
}