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
import com.example.shapeolorpp.models.BodyHorizontalData

class BodyHorizontalAdapter(
    private val listenBody: OnBodyColorClick
) : ListAdapter<BodyHorizontalData, BodyHorizontalAdapter.BodyHorizontalColorHolder>(DifferCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BodyHorizontalColorHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal, parent, false)
        return BodyHorizontalColorHolder(view)
    }

    override fun onBindViewHolder(holder: BodyHorizontalColorHolder, position: Int) {
        val currentItem = getItem(position)

       val  gradBody = currentItem.radialDrawable
        gradBody?.gradientType = GradientDrawable.LINEAR_GRADIENT
        gradBody?.gradientRadius = 140f
        gradBody?.setGradientCenter(0.50f, 0.50f)
        holder.imagecircle.setImageDrawable(gradBody)

    }

    inner class BodyHorizontalColorHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imagecircle = itemView.findViewById<ImageView>(R.id.body_color_image)

        init {

            imagecircle.setOnClickListener {
                val position = adapterPosition
                if (position!=RecyclerView.NO_POSITION){
                    listenBody.changeBodyColor(position)
                }
            }

        }

    }

    class DifferCallback : DiffUtil.ItemCallback<BodyHorizontalData>() {

        override fun areItemsTheSame(oldItem: BodyHorizontalData, newItem: BodyHorizontalData) =
            oldItem.circleColor == newItem.circleColor

        override fun areContentsTheSame(oldItem: BodyHorizontalData, newItem: BodyHorizontalData) =
            oldItem == newItem
    }

    interface OnBodyColorClick {
        fun changeBodyColor(position: Int)
    }

}