package com.example.examplounittest


import com.example.examplounittest.data.Calculadora
import org.junit.Test

import org.junit.Assert.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        //assertEquals --- verifica lo que se espera de una accion, classe problema,
        // crear la clase calculadora.
        // crear una funcion que pase dos numeros.
        // 2 + 2 = 4
        // 5 + 3 = 8
        //refactorizacion
        //2.5 + 1 = 3.5


        //fefactorizacion para los siguiente.
        // 1.0+1.0 = 2.0
        // 1+1=2

        var calculadora = Calculadora()
        var resultado = calculadora.suma(1,1)
        var resultado2 = calculadora.suma(1.0,1.0)

        //ver en consola
        print("Dataaaaaaa ${resultado} ")
        //
        var epserar = 2

        assertEquals(2.0, resultado2, 0.0)
        assertEquals(epserar, resultado)
    }

    @Test
    fun addition_resta(){
        //assertEquals --- verifica lo que se espera de una accion, classe problema,
        // crear la clase calculadora.
        // crear una funcion que pase dos numeros.
        // 2 - 2 = 0
        // 5 - 3 = 2
        //refactorizacion
        //2.5 - 1 = 1.5


        //fefactorizacion para los siguiente.
        // 1.0-1.0 = 0.0
        // 1-1=0

        val resta = Calculadora()
        assertEquals(5, resta.resta(10,5))
        assertEquals(2.5, resta.resta(5.0, 2.5), 0.0)
    }

    @Test
    fun addition_multiplicacion(){
        //assertEquals --- verifica lo que se espera de una accion, classe problema,
        // crear la clase calculadora.
        // crear una funcion que pase dos numeros.
        // 2 * 2 = 4
        // 5 * 3 = 15
        //refactorizacion
        //2.5 * 1 = 2.5


        //fefactorizacion para los siguiente.
        // 1.0*1.0 = 2.0
        // 1*1=2

    }

    @Test
    fun addition_division(){
        // assertEquals --- verifica lo que se espera de una accion, classe problema,
        // crear la clase calculadora.
        // crear una funcion que pase dos numeros.
        // 2 + 2 = 4
        // 5 + 3 = 8
        // refactorizacion
        // 2.5 + 1 = 3.5


        // fefactorizacion para los siguiente.
        // 1.0+1.0 = 2.0
        // 1+1=2

        // refactorizacion me van un test: "Error en al ooperacion"
        // 2/0 -- "Error en al ooperacion"

        val div = Calculadora()
        //assertEquals("Error de la operacion", div.division(2,0))
        assertEquals(2, div.division(10,5))
        //assertEquals(1.5, div.division(2.5,0.5), 0.0)
        assertEquals("Error de la operacion", div.division(2.5,0.0), 0.0)
    }


}