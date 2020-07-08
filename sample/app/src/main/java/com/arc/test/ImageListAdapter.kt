package com.arc.test

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.arc.test.model.ImageItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_row.view.*

class ImageListAdapter(var images: ArrayList<ImageItem>) :
    RecyclerView.Adapter<ImageListAdapter.ImageViewHolder>() {
    fun updateUsers(newUsers: List<ImageItem>) {
        images.clear()
        images.addAll(newUsers)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ImageViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
    )
    override fun getItemCount() = images.size
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("url", images[position].url)
            holder.itemView.context.startActivity(intent)
        }
    }
    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView = view.imageView
        fun bind(item: ImageItem) {
            val options = RequestOptions()
                .placeholder(R.drawable.loader)
                .error(R.mipmap.ic_launcher_round)
            Glide.with(imageView.context)
                .setDefaultRequestOptions(options)
                .load(item.url)
                .into(imageView)

        }
    }
}