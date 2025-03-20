package com.example.primeropasoskotlin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.primeropasoskotlin.R
import com.example.primeropasoskotlin.models.Posts

class AdapterPosts (private val dataList: List<Posts>, private val listener: OnItemClickListener): RecyclerView.Adapter<AdapterPosts.DataAdapter.ViewHolder>(){

    interface OnItemClickListener {
        fun onEditClick(item: Posts)
        fun onDeleteClick(item: Posts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_list_posts, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) {
        val title: TextView = view.findViewById(R.id.textTitle)
        val body: TextView = view.findViewById(R.id.textBody)
        val editButton: Button = view.findViewById(R.id.buttonEdit)
        val deleteButton: Button = view.findViewById(R.id.buttonDelete)
    }

    class DataAdapter {

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.title.text = item.title
        holder.body.text = item.body

        holder.editButton.setOnClickListener { listener.onEditClick(item) }
        holder.deleteButton.setOnClickListener { listener.onDeleteClick(item) }
    }

    override fun getItemCount() = dataList.size


}