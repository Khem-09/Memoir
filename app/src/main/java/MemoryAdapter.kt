package com.example.memoir // CHANGE THIS TO YOUR PACKAGE NAME

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Data Model
data class MemoryModel(val title: String, val date: String, val description: String)

// Adapter Class
class MemoryAdapter(private val memoryList: List<MemoryModel>) :
    RecyclerView.Adapter<MemoryAdapter.MemoryViewHolder>() {

    class MemoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val date: TextView = itemView.findViewById(R.id.tvDate)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_memory, parent, false)
        return MemoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemoryViewHolder, position: Int) {
        val currentItem = memoryList[position]
        holder.title.text = currentItem.title
        holder.date.text = currentItem.date
        holder.description.text = currentItem.description
    }

    override fun getItemCount() = memoryList.size
}