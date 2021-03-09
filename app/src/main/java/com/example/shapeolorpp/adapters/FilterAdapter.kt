package com.example.shapeolorpp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shapeolorpp.databinding.ItemFilterBinding
import com.example.shapeolorpp.models.Filter

class FilterAdapter(
    private val context: Context?,
    private val listener: OnSetFilter
) : ListAdapter<Filter, FilterAdapter.FilterViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val view = ItemFilterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class FilterViewHolder(private val itemBinding: ItemFilterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        init {
            itemBinding.apply {
                imageView.setOnClickListener {
                    val postion = adapterPosition
                    if (postion != RecyclerView.NO_POSITION) {
                        val current = getItem(postion)
                        listener.setFilter(current)
                    }
                }
            }
        }


        fun bind(item: Filter) {

            val filter = item.filter
            val editor = item.photoFilter
            editor.setFilterEffect(filter)

            val uri = item.imageUri
            context?.let { Glide.with(it).load(uri).into(itemBinding.imageView) }
        }

    }


    class DiffCallback() : DiffUtil.ItemCallback<Filter>() {
        override fun areItemsTheSame(oldItem: Filter, newItem: Filter) =
            oldItem.filter == oldItem.filter

        override fun areContentsTheSame(oldItem: Filter, newItem: Filter) =
            oldItem == newItem
    }


    interface OnSetFilter {
        fun setFilter(filter: Filter)
    }

}

