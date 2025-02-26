package com.example.primeropasoskotlin.models

class Productos constructor(private var id_producto: Int, private var id_categoria:Int,private var id_proveedor:Int ,private var nombre:String, private var precio:Double){

    //get

    fun getIdProducto(): Int{
        return this.id_producto
    }
    fun getIdCategoria(): Int{
        return this.id_categoria
    }
    fun getIdProveedor(): Int{
        return this.id_proveedor
    }
    fun getNombre(): String{
        return this.nombre
    }

    fun getPrecio(): Double{
        return this.precio
    }
    fun calcularIVA(iva: Double):Double{
        var total:Double = precio*iva
        return total
    }
}