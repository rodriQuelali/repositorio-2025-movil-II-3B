package com.example.primeropasoskotlin.models

class Venta constructor(private var id_venta:Int, private var id_producto:Int,private var cantidad:Int, private var precio_total:Double, private var cliente:String, private var fecha:String){

    fun getIdVenta():Int{
        return this.id_venta
    }
    fun getIdProducto():Int{
        return this.id_producto
    }
    fun getCantidad():Int{
        return this.cantidad
    }
    fun getPrecioTotal():Double{
        return this.precio_total
    }
    fun getCliente():String{
        return this.cliente
    }
    fun getFecha():String{
        return this.fecha
    }

    companion object{
        fun calcularCantidad(productos:Productos, cantidad: Int):Double {
            return cantidad * productos.getPrecio()
        }
    }
}