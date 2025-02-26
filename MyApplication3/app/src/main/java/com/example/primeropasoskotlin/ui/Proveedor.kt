package com.example.primeropasoskotlin.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.primeropasoskotlin.R
import com.example.primeropasoskotlin.models.Categoria
import com.example.primeropasoskotlin.models.Proveedor
import com.example.primeropasoskotlin.viewmodel.CategoriaViewModel
import com.example.primeropasoskotlin.viewmodel.ProveedorViewModel

class Proveedor: AppCompatActivity() {

    lateinit var btnGuardarProveedor: Button
    lateinit var txtCodProve: EditText
    lateinit var txtNomPro: EditText
    lateinit var txtNit: EditText
    lateinit var txtDireccion: EditText

    private lateinit var proveedorViewModel: ProveedorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_proveedor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()
        estadoBoton()
    }

    fun cargarR(){
        btnGuardarProveedor = findViewById(R.id.btnRegistrarProveedor)
        txtCodProve = findViewById(R.id.txtCodigoProveedor)
        txtNomPro = findViewById(R.id.txtNombreProveedor)
        txtNit = findViewById(R.id.txtNIT)
        txtDireccion = findViewById(R.id.txtDireccion)

    }
    fun estadoBoton(){
        btnGuardarProveedor.setOnClickListener{
            proveedorViewModel = ViewModelProvider(this).get(ProveedorViewModel::class.java)
            val proveedor = Proveedor(txtCodProve.text.toString().toInt(),txtNomPro.text.toString(),txtNit.text.toString().toInt(), txtDireccion.text.toString())
            val resul = proveedorViewModel.insertarProveedor(proveedor)
            if (resul == 1){

                Toast.makeText(this, "inserto correctamente Proveedor", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "error en el registro", Toast.LENGTH_SHORT).show()
            }
        }
    }
}