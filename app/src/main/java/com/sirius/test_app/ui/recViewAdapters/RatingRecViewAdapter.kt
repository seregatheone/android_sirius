package com.sirius.test_app.ui.recViewAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.R

class RatingRecViewAdapter: RecyclerView.Adapter<RatingRecViewAdapter.RatingViewHolder>() {
    inner class RatingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private var rating : Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return RatingViewHolder(layoutInflater.inflate(R.layout.rating_layout,parent,false))
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int){}

    override fun getItemCount(): Int = rating


    fun setRating(rating: Int){
        this.rating = rating
        notifyDataSetChanged()
    }
}