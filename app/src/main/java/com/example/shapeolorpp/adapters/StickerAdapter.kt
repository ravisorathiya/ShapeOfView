package com.example.shapeolorpp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shapeolorpp.databinding.ItemStickerBinding
import com.example.shapeolorpp.models.Sticker


class StickerAdapter(
    private val context: Context,
    private val listener: ImageTouchListner
) : ListAdapter<Sticker, StickerAdapter.StickerHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StickerHolder {
        val view = ItemStickerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StickerHolder(view)
    }

    override fun onBindViewHolder(holder: StickerHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class StickerHolder(private val item: ItemStickerBinding) :
        RecyclerView.ViewHolder(item.root) {

        init {
            item.apply {
                imageSticker.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val current = getItem(position)
                        listener.onImageClick(current)
                    }
                }
            }
        }


        fun bind(currentItem: Sticker?) {
            val data = currentItem?.sticker
            data?.let { Glide.with(context).load(it).into(item.imageSticker) }
        }

    }


    class DiffCallBack : DiffUtil.ItemCallback<Sticker>() {
        override fun areItemsTheSame(oldItem: Sticker, newItem: Sticker) =
            oldItem.sticker == newItem.sticker

        override fun areContentsTheSame(oldItem: Sticker, newItem: Sticker) =
            oldItem == newItem
    }


    interface ImageTouchListner {
        fun onImageClick(stickerItem: Sticker)
    }


}