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

        var calculadora: Calculadora = Calculadora()
        var resultado = calculadora.suma(5,3)

        assertEquals(8, resultado)
    }
}