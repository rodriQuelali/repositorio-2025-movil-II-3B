package com.example.examplounittest.data

class Usuario (private val nombre:String, private val correo:String, private val password:String){

    fun setNombre () = this.nombre

    fun validarNombre():Any{
        return if (this.nombre.length >= 4) "ok" else "El nombre es menor a 4"
    }

}