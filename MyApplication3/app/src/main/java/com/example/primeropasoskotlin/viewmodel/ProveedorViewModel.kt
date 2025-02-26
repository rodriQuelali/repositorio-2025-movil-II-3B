package com.example.primeropasoskotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.primeropasoskotlin.models.Proveedor
import com.example.primeropasoskotlin.models.ProveedorDao
import com.example.primeropasoskotlin.models.ProveedorRepositorio

class ProveedorViewModel(aplication:Application): AndroidViewModel(aplication) {

    private val proveedorDao:ProveedorDao
    //val proveedor:MutableLiveData<Proveedor?> = MutableLiveData()

    init {
        val proveedorRepositorio = ProveedorRepositorio(aplication)
        proveedorDao = ProveedorDao(proveedorRepositorio)
    }

    fun insertarProveedor(proveedor: Proveedor):Int{
        return proveedorDao.insertarProveedor(proveedor)
    }

    fun buscarProveedor(id:String): Proveedor? {
        val proveedorEncontrado = proveedorDao.buacarProveedorId(id)
        return proveedorEncontrado
    }

}