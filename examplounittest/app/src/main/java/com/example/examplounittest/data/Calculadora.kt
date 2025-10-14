package com.example.examplounittest.data

class Calculadora {

    fun suma(num1:Double, num2: Double):Double{
        return num1 + num2
    }

    fun suma(num1: Int, num2:Int):Int{
        return num1 + num2
    }

    fun resta(num1:Double, num2: Double):Double{
        return num1 - num2
    }

    fun resta(num1: Int, num2:Int):Int{
        return num1 - num2
    }

    fun multiplicacion(num1:Double, num2: Double):Double{
        return num1 * num2
    }

    fun multiplicacion(num1: Int, num2:Int):Int{
        return num1 * num2
    }

    fun division(num1:Double, num2: Double):Any{

        return num1 * num2
    }

    fun division(num1: Int, num2:Int):Any{
        if(num2 != 0){
            return num1 / num2
        }
        return errorMensaje()
    }

    fun errorMensaje():String{
        return "Error de la operacion"
    }


}