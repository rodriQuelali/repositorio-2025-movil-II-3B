package com.example.primeropasoskotlin.models

data class Categoria constructor(private var id_categoria:Int, private var nombre:String, private var descrpcion:String ) {

    fun getIdCategoria ():Int{
        return this.id_categoria
    }

    fun getNombre ():String{
        return this.nombre
    }

    fun getDescripcion ():String{
        return this.descrpcion
    }
}