package com.example.shapeolorpp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shapeolorpp.databinding.ItemStickerBinding
import com.example.shapeolorpp.models.StickerData

class StickerAdapter(
    private val listener: ImageTouchListner
) : ListAdapter<StickerData, StickerAdapter.StickerHolder>(DiffCallBack()) {

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
                        Toast.makeText(it.context, "$position", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


        fun bind(currentItem: StickerData?) {
            val data = currentItem?.sticker
            if (data != null) {
                item.imageSticker.setImageResource(data)
            }
        }

    }


    class DiffCallBack : DiffUtil.ItemCallback<StickerData>() {
        override fun areItemsTheSame(oldItem: StickerData, newItem: StickerData) =
            oldItem.sticker == newItem.sticker

        override fun areContentsTheSame(oldItem: StickerData, newItem: StickerData) =
            oldItem == newItem
    }


    interface ImageTouchListner {
        fun onImageClick(stickerItem: StickerData)
    }


}