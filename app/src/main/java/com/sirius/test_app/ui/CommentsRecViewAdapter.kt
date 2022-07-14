package com.sirius.test_app.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sirius.test_app.R
import com.sirius.test_app.data.ReviewModel

class CommentsRecViewAdapter(private val context : Context): RecyclerView.Adapter<CommentsRecViewAdapter.CommentViewHolder>() {
    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private var reviewModel : List<ReviewModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return CommentViewHolder(layoutInflater.inflate(R.layout.comment_layout,parent,false))
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int){
        val currentItem = reviewModel[position]

        val authorImage = holder.itemView.findViewById<ImageView>(R.id.authorIcon)
        val authorName = holder.itemView.findViewById<TextView>(R.id.authorName)
        val date = holder.itemView.findViewById<TextView>(R.id.date)
        val commentText = holder.itemView.findViewById<TextView>(R.id.commentText)

        authorName.text = currentItem.userName
        date.text = currentItem.date
        commentText.text = currentItem.message

        Glide.with(context)
            .load(currentItem.userImage)
            .into(authorImage)
    }

    override fun getItemCount(): Int = reviewModel.size


    fun setReview(reviewModel: List<ReviewModel>){
        this.reviewModel = reviewModel
        notifyDataSetChanged()
    }
}