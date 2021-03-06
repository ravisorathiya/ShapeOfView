package com.example.shapeolorpp.adapters

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shapeofview.data.RadialShade
import com.example.shapeolorpp.R

class RadialAdapter(
    private val context: Context,
    private val radialListener: OnRadialSetListener
) : ListAdapter<RadialShade, RadialAdapter.RadialHolder>(DifferCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadialHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_radial, parent, false)
        return RadialHolder(view)
    }

    override fun onBindViewHolder(holder: RadialHolder, position: Int) {
        val currentItem = getItem(position)

        var gradientDrawable = currentItem.radialDrawable

        gradientDrawable?.gradientType = GradientDrawable.RADIAL_GRADIENT
        gradientDrawable?.gradientRadius = 140f
        gradientDrawable?.setGradientCenter(0.50f, 0.50f)


        Glide.with(context).load(gradientDrawable).into(holder.circleRadial)
//        holder.circleRadial.setImageDrawable(gradientDrawable)

    }

    inner class RadialHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val circleRadial = itemView.findViewById<ImageView>(R.id.radial_image)

        init {

            circleRadial.setOnClickListener {

                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    radialListener.setRadialColor(position)
                }
            }


        }


    }

    class DifferCallback : DiffUtil.ItemCallback<RadialShade>() {
        override fun areItemsTheSame(
            oldItem: RadialShade,
            newItem: RadialShade
        ) = oldItem == newItem


        override fun areContentsTheSame(
            oldItem: RadialShade,
            newItem: RadialShade
        ) = oldItem == newItem
    }

    interface OnRadialSetListener {
        fun setRadialColor(position: Int)
    }

}

private const val TAG = "RadialAdapter"