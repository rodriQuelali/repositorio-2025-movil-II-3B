package com.example.primeropasoskotlin.ui


import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.primeropasoskotlin.R

import com.example.primeropasoskotlin.db.AdminSQLiteOpenHelper
import com.example.primeropasoskotlin.models.Categoria
import com.example.primeropasoskotlin.models.Productos
import com.example.primeropasoskotlin.models.Proveedor
import com.example.primeropasoskotlin.viewmodel.CategoriaViewModel
import com.example.primeropasoskotlin.viewmodel.ProductoViewModel
import com.example.primeropasoskotlin.viewmodel.ProveedorViewModel

class Productos : AppCompatActivity() {
    lateinit var btnAgregar:Button
    lateinit var btnbuscaProvee:Button
    lateinit var btnbuscaCate:Button
    lateinit var txtNombre: EditText
    lateinit var txtPrecio: EditText
    lateinit var txtCodigo: EditText
    lateinit var txtCodigoProvee: EditText
    lateinit var txtCodigoCategoria: EditText

    var codigoProveedor:Int = 0
    var codigoCategoria:Int = 0

    private lateinit var proveedorViewModel: ProveedorViewModel
    private lateinit var categoriaViewModel: CategoriaViewModel
    private lateinit var productoViewModel: ProductoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cargarR()
        estadoButon()
    }

    fun cargarR(){
        btnAgregar = findViewById(R.id.btnRegistrarProducto)
        btnbuscaCate = findViewById(R.id.btnBuscarCategoria)
        btnbuscaProvee = findViewById(R.id.btnBuscarProveedor)
        txtNombre = findViewById(R.id.txtNombreProducto)
        txtCodigo = findViewById(R.id.txtCodigoProducto)
        txtPrecio = findViewById(R.id.txtPrecioProducto)
        txtCodigoProvee = findViewById(R.id.txtBusProvee)
        txtCodigoCategoria = findViewById(R.id.txtBusCategoria)
    }
    fun estadoButon(){
        btnAgregar.setOnClickListener{

            productoViewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)
            val producto = Productos(txtCodigo.text.toString().toInt(),codigoCategoria,codigoProveedor, txtNombre.text.toString(), txtPrecio.text.toString().toDouble())
            val resul = productoViewModel.insertarProducto(producto)
            if (resul == 1){
                Toast.makeText(this, "inserto correctamente Producto", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "error en el registro", Toast.LENGTH_SHORT).show()
            }
        }


        btnbuscaProvee.setOnClickListener{

            proveedorViewModel = ViewModelProvider(this).get(ProveedorViewModel::class.java)

            val idProducto = txtCodigoProvee.text.toString()
            if(idProducto != "") {
                val bauscar: Proveedor? = proveedorViewModel.buscarProveedor(idProducto)
                if (bauscar != null) {
                    txtCodigoProvee.setText(bauscar.getNombre())
                    codigoProveedor = bauscar.getIdProveedor()
                }else{
                    Toast.makeText(this, "No existe un proveedor con dicho código", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor ingresa un código válido", Toast.LENGTH_SHORT).show()
            }
        }

        btnbuscaCate.setOnClickListener{
            categoriaViewModel = ViewModelProvider(this).get(CategoriaViewModel::class.java)

            val idProducto = txtCodigoCategoria.text.toString()
            if(idProducto != "") {
                val bauscar: Categoria? = categoriaViewModel.buscarCategoria(idProducto)
                if (bauscar != null) {
                    txtCodigoCategoria.setText(bauscar.getNombre())
                    codigoCategoria = bauscar.getIdCategoria()
                }else{
                    Toast.makeText(this, "No existe un categoria con dicho código", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor ingresa un código válido", Toast.LENGTH_SHORT).show()
            }
        }

    }
}