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
import com.example.shapeolorpp.models.BodyVerticleData

class BodyVerticleAdapter(
    private val verticleColorlist: VerticleColorSet
) : ListAdapter<BodyVerticleData, BodyVerticleAdapter.BodyColorVerticleHolder>(
    DifferCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BodyColorVerticleHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_verticlecolor, parent, false)
        return BodyColorVerticleHolder(view)
    }

    override fun onBindViewHolder(holder: BodyColorVerticleHolder, position: Int) {
        val currentItem = getItem(position)

        val gradint = currentItem.radialDrawable
        gradint?.gradientType = GradientDrawable.LINEAR_GRADIENT
        gradint?.gradientRadius = 140f
        gradint?.setGradientCenter(0.50f, 0.50f)
        holder.imagecircle.setImageDrawable(gradint)
    }

    inner class BodyColorVerticleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imagecircle = itemView.findViewById<ImageView>(R.id.body_verticle_image)

        init {

            imagecircle.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    verticleColorlist.onVerticle(position)
                }
            }

        }

    }

    class DifferCallback : DiffUtil.ItemCallback<BodyVerticleData>() {
        override fun areItemsTheSame(
            oldItem: BodyVerticleData,
            newItem: BodyVerticleData
        ) = oldItem.circleColor == newItem.circleColor

        override fun areContentsTheSame(
            oldItem: BodyVerticleData,
            newItem: BodyVerticleData
        ) = oldItem == newItem
    }

    interface VerticleColorSet {
        fun onVerticle(position: Int)
    }


}