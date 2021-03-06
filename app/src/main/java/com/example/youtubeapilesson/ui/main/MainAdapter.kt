package com.example.youtubeapilesson.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapilesson.R
import com.example.youtubeapilesson.extension.inflate
import com.example.youtubeapilesson.model.Items
import kotlinx.android.synthetic.main.item_playlist.view.*

class MainAdapter(
    private val list: MutableList<Items> = mutableListOf(),
    val onHolderClick: (item: Items) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_playlist))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])

        holder.itemView.setOnClickListener {
            onHolderClick(list[position])
        }
    }

    override fun getItemCount(): Int = list.size
}

open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(item: Items) {

        itemView.tv_name_rv_playlist.text = item.snippet.title
        itemView.tv_group_rv_playlist.text = item.snippet.description

    }
}