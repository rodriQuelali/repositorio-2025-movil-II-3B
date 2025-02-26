package com.example.primeropasoskotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.primeropasoskotlin.models.Categoria
import com.example.primeropasoskotlin.models.CategoriaDao
import com.example.primeropasoskotlin.models.CategoriaRepositorio
import com.example.primeropasoskotlin.models.Proveedor

class CategoriaViewModel(aplication:Application):AndroidViewModel(aplication) {
    private val categoriaDao:CategoriaDao
    val categoria:MutableLiveData<List<Categoria>> = MutableLiveData()

    init {
        val categoriaRepositorio = CategoriaRepositorio(aplication)
        categoriaDao = CategoriaDao(categoriaRepositorio)
    }

    fun insertarCategoria(categoria: Categoria):Int{
        return  categoriaDao.insertarCategoria(categoria)
    }

    fun getAll(){
        categoria.value = categoriaDao.getAll()
    }

    fun buscarCategoria(id:String): Categoria? {
        val categoriaEncontrado = categoriaDao.buacarCategoriaId(id)
        return categoriaEncontrado
    }
}