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
import com.example.primeropasoskotlin.models.Productos
import com.example.primeropasoskotlin.models.Proveedor
import com.example.primeropasoskotlin.models.Venta
import com.example.primeropasoskotlin.viewmodel.CategoriaViewModel
import com.example.primeropasoskotlin.viewmodel.ProductoViewModel
import com.example.primeropasoskotlin.viewmodel.ProveedorViewModel
import com.example.primeropasoskotlin.viewmodel.VentasViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Ventas: AppCompatActivity() {

    lateinit var btnAgregar: Button
    lateinit var btnBuscar:Button
    lateinit var txtCodigo:EditText
    lateinit var txtNombre:EditText
    lateinit var txtCantidad:EditText
    lateinit var txtPrecio:EditText
    lateinit var txtCliente:EditText
    lateinit var txtFecha:EditText
    private var codProducto: Int = 0

    private lateinit var ventasViewModel: VentasViewModel
    private lateinit var productoViewModel: ProductoViewModel
    private var productos: Productos? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarR()
        seatdoFecha()
        estadoBoton()
    }

    fun cargarR(){
        btnAgregar = findViewById(R.id.btnRegistrarVenta)
        btnBuscar = findViewById(R.id.btnBuscarProducto)
        txtCodigo = findViewById(R.id.txtCodigoVenta)
        txtNombre = findViewById(R.id.txtBuscarProducto)
        txtCantidad = findViewById(R.id.txtCantidad)
        txtPrecio = findViewById(R.id.txtPrecioTotal)
        txtCliente = findViewById(R.id.txtCliente)
        txtFecha = findViewById(R.id.txtFechaVenta)
    }
    fun estadoBoton(){
        btnAgregar.setOnClickListener{
            ventasViewModel = ViewModelProvider(this).get(VentasViewModel::class.java)
            Toast.makeText(this, "datos: ${productos?.getPrecio()}", Toast.LENGTH_SHORT).show()
            val precioTotal: Double = Venta.calcularCantidad(productos!!, txtCantidad.text.toString().toInt())
            val venta = Venta(txtCodigo.text.toString().toInt(),codProducto,txtCantidad.text.toString().toInt(),precioTotal, txtCliente.text.toString(),txtFecha.text.toString())
            val resul = ventasViewModel.insertarVentas(venta)
            if (resul == 1){
                //cargarCate()
                Toast.makeText(this, "inserto correctamente Venta", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "error en el registro", Toast.LENGTH_SHORT).show()
            }
        }

        btnBuscar.setOnClickListener {
            productoViewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)

            val idProducto = txtNombre.text.toString()
            if(idProducto != "") {
                productos = productoViewModel.buscarProductoPorId(idProducto)
                if (productos != null) {
                    txtNombre.setText(productos!!.getNombre())
                    codProducto = productos!!.getIdProducto()
                    Toast.makeText(this, "Datos: ${productos!!.getIdCategoria()} ${productos!!.getIdProveedor()}", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "No existe un proveedor con dicho código", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor ingresa un código válido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun seatdoFecha(){
        txtFecha.setOnClickListener {
            // Crear el selector de fecha
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecciona una fecha")
                .build()

            // Mostrar el selector
            datePicker.show(supportFragmentManager, "DATE_PICKER")

            // Obtener la fecha seleccionada
            datePicker.addOnPositiveButtonClickListener { selection ->
                // Formatear la fecha seleccionada
                val formatoFecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val fechaSeleccionada = formatoFecha.format(Date(selection))

                // Mostrar la fecha en el EditText
                txtFecha.setText(fechaSeleccionada)
            }
        }
    }

}