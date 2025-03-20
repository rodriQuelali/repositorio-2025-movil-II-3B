package com.example.primeropasoskotlin.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primeropasoskotlin.R
import com.example.primeropasoskotlin.models.Posts
import com.example.primeropasoskotlin.ui.adapter.AdapterPosts

class listPost : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterPosts.DataAdapter
    private val dataItemList = mutableListOf<Posts>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_post)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Agrega elementos de ejemplo
        dataItemList.add(Posts(1,3,"Título 1", "Contenido 1"))
        dataItemList.add(Posts(2,5,"Título 2", "Contenido 2"))

        adapter = AdapterPosts.DataAdapter(dataItemList, this)
        recyclerView.adapter = adapter
    }

    fun onEditClick(item: Posts) {
        // Manejar la acción de editar
    }

    fun onDeleteClick(item: Posts) {
        // Manejar la acción de eliminar
        //dataItemList.remove(item)
        //adapter.notifyDataSetChanged()
    }
}