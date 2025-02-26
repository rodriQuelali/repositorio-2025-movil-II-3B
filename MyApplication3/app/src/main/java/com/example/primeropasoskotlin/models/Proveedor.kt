package com.example.primeropasoskotlin.models

class Proveedor constructor(private var id_proveedor:Int, private var nombre:String, private var nit:Int, private var direccion:String) {

    fun getIdProveedor():Int{
        return this.id_proveedor
    }

    fun getNombre ():String{
        return this.nombre
    }

    fun getDireccion ():String{
        return this.direccion
    }

    fun getNit ():Int{
        return this.nit
    }
}