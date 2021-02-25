package com.example.shapeolorpp.adapters

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shapeolorpp.R
import com.example.shapeolorpp.models.LinearShade


class LinearAdapter(
    private val onColorSet: OnLinearSetColor
) : ListAdapter<LinearShade, LinearAdapter.LinearHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinearHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_linear, parent, false)
        return LinearHolder(view)
    }

    override fun onBindViewHolder(holder: LinearHolder, position: Int) {
        val currentItem = getItem(position)

        val linearGradient = currentItem.linearColor
        holder.imageLinear.apply {


            linearGradient?.gradientType  = GradientDrawable.LINEAR_GRADIENT
            linearGradient?.gradientRadius = 140f
            linearGradient?.setGradientCenter(50f, 50f)

            holder.imageLinear.setImageDrawable(linearGradient)

        }
    }

    inner class LinearHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageLinear = itemView.findViewById<ImageView>(R.id.linear_image)

        init {

            imageLinear.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onColorSet.setLinearColor(position)
                }
            }
        }

    }


    class DiffCallback : DiffUtil.ItemCallback<LinearShade>() {
        override fun areItemsTheSame(
            oldItem: LinearShade,
            newItem: LinearShade
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: LinearShade,
            newItem: LinearShade
        ) = oldItem == newItem

    }


    interface OnLinearSetColor {
        fun setLinearColor(position: Int)
    }

}