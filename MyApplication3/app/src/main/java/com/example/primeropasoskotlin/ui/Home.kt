package com.example.primeropasoskotlin.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.primeropasoskotlin.R
import com.example.primeropasoskotlin.db.AdminSQLiteOpenHelper

class Home : AppCompatActivity() {
    lateinit var carProducto:CardView
    lateinit var carIva:CardView
    lateinit var carSalir:CardView
    lateinit var carVenta:CardView
    lateinit var carProvee:CardView
    lateinit var carCatego:CardView
    lateinit var btnReset : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()
        estadoBoton()
    }

    fun cargarR(){
        carProducto = findViewById(R.id.carProducto)
        carIva = findViewById(R.id.carIva)
        carSalir = findViewById(R.id.carSalir)
        btnReset = findViewById(R.id.btnRecerarBD)
        carVenta = findViewById(R.id.carVenta)
        carCatego = findViewById(R.id.carCategoria)
        carProvee = findViewById(R.id.carProveedor)
    }

    fun estadoBoton(){
        carIva.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        carProducto.setOnClickListener{
            val i = Intent(this, Productos::class.java)
            startActivity(i)
        }
        carVenta.setOnClickListener{
            val i = Intent(this, Ventas::class.java)
            startActivity(i)
        }
        carProvee.setOnClickListener{
            val i = Intent(this, Proveedor::class.java)
            startActivity(i)
        }
        carCatego.setOnClickListener{
            val i = Intent(this, com.example.primeropasoskotlin.ui.Categoria::class.java)
            startActivity(i)
        }
        btnReset.setOnClickListener{
            val adminDBHelper = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val db = adminDBHelper.writableDatabase

            db.close()  // Cerrar la base de datos antes de eliminarla

            val dbName = "administracion"
            val result = this.deleteDatabase(dbName)

            if (result) {
                Toast.makeText(this, "Base de datos eliminada correctamente", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error al eliminar la base de datos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}