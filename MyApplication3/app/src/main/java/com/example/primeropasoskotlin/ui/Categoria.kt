package com.example.primeropasoskotlin.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.primeropasoskotlin.R
import com.example.primeropasoskotlin.models.Categoria
import com.example.primeropasoskotlin.viewmodel.CategoriaViewModel

class Categoria: AppCompatActivity() {

    lateinit var btnGuardarCategoria: Button
    lateinit var txtCodCate:EditText
    lateinit var txtNomCate:EditText
    lateinit var txtDesCate:EditText
    lateinit var listaCate:ListView

    //viewmodel
    private lateinit var categoriaViewModel: CategoriaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_categoria)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()
        estadoBoton()
        cargarCate()

    }

    fun cargarR(){
        btnGuardarCategoria = findViewById(R.id.btnRegistrarCategoria)
        txtCodCate = findViewById(R.id.txtCodigoCategoria)
        txtNomCate = findViewById(R.id.txtNombreCategoria)
        txtDesCate = findViewById(R.id.txtDescripcionCategoria)
        listaCate = findViewById(R.id.listaCategoria)
    }

    fun estadoBoton(){
        btnGuardarCategoria.setOnClickListener{
            categoriaViewModel = ViewModelProvider(this).get(CategoriaViewModel::class.java)
            val categoria = Categoria(txtCodCate.text.toString().toInt(),txtNomCate.text.toString(),txtDesCate.text.toString())
            val resul = categoriaViewModel.insertarCategoria(categoria)
            if (resul == 1){
                cargarCate()
                Toast.makeText(this, "inserto correctamente Ctegoria", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "error en el registro", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun cargarCate(){
        categoriaViewModel = ViewModelProvider(this).get(CategoriaViewModel::class.java)
        //val namesList = categoriaViewModel.getAll()
        //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesList)
        categoriaViewModel.categoria.observe(this, Observer {
            categorias -> categorias?.let {
                val nombresCategorias = it.map { categoria -> categoria.getNombre() }

                // Crear un ArrayAdapter para mostrar los nombres directamente en el ListView
                val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1, // Layout predefinido de Android
                    nombresCategorias
                )
            listaCate.adapter = adapter
            }
        })
        //adapter.setDropDownViewResource(android.R.layout.simple_list_item_2)
        //listaCate.adapter = adapter
    }
}