package com.example.primeropasoskotlin.models

class ProveedorDao(private val proveedorRepositorio: ProveedorRepositorio) {

    fun insertarProveedor(proveedor: Proveedor):Int{
        return proveedorRepositorio.insertProveedor(proveedor)
    }

    fun buacarProveedorId(id:String): Proveedor? {
        return proveedorRepositorio.buscarProveedorPorId(id)
    }
}