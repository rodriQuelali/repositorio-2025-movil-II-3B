package com.example.primeropasoskotlin.models

class CategoriaDao(private val categoriaRepositorio: CategoriaRepositorio) {

    fun insertarCategoria(categoria: Categoria):Int{
        return categoriaRepositorio.insertCategoria(categoria)
    }

    fun getAll(): MutableList<Categoria> {
        return categoriaRepositorio.getAll()
    }

    fun buacarCategoriaId(id:String): Categoria? {
        return categoriaRepositorio.buscarCategoriaPorId(id)
    }
}