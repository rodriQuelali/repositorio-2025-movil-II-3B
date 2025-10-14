package com.example.examplounittest

import com.example.examplounittest.data.Usuario
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class userUnitTest {
    // realizar un test, que acepte solo nombre mayor e igual a 4
    // ana -- no pasa el test
    //rodrigo --- si pasa el test

    //setup --- se ejecuta por funcion -- 1-1, 2-2, ....

    @Before
    fun setup(){
        println("holaaa setup....")

    }

    //setupClass --- se ejecuta solo una unica vez.

    @Test
    fun validacionNombreMayorUsuario(){

        assertEquals("El nombre es menor a 4", nombreMenor.validarNombre())
        assertEquals("ok", nombreMayor.validarNombre())

    }

    @Test
    fun validacionNombreDUsuario(){

        //clase Usuario: Nombre, correo, password.


    }

    companion object {
        //setupClass --- se ejecuta solo una unica vez.
        @JvmStatic
        @BeforeClass
        fun setupClass(): Unit {
            println("hola seupClass....")
            var nombreMenor = Usuario("ana", "ana@gmail.com", "ana1234")
            lateinit var nombreMayor = Usuario("Rodrigo", "ana@gmail.com", "ana1234")
        }
    }
}