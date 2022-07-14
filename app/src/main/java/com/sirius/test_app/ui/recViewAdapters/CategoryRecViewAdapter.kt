package com.sirius.test_app.ui.recViewAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.R

class CategoryRecViewAdapter: RecyclerView.Adapter<CategoryRecViewAdapter.CategoryViewHolder>() {
    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private var category : List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return CategoryViewHolder(layoutInflater.inflate(R.layout.category_layout,parent,false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int){
        val currentItem = category[position]
        val textView = holder.itemView.findViewById<TextView>(R.id.category)
        textView.text = currentItem
    }

    override fun getItemCount(): Int = category.size


    fun setCategory(category: List<String>){
        this.category = category
        notifyDataSetChanged()
    }
}