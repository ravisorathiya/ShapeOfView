package com.example.shapeolorpp.adapters

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shapeolorpp.databinding.ItemSweepterBinding
import com.example.shapeolorpp.models.Sweeper

class   SweeperAdapter(
    private val context: Context,
    private val listener: SweppeClick
) : ListAdapter<Sweeper, SweeperAdapter.SweeperHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SweeperHolder {
        val view = ItemSweepterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SweeperHolder(view)
    }

    override fun onBindViewHolder(holder: SweeperHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class SweeperHolder(private val itemBinding: ItemSweepterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        init {
            itemBinding.apply {
                sweeperColor.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val current = getItem(position)
                        listener.onSweeperClick(current)
                    }
                }
            }
        }


        fun bind(currentItem: Sweeper?) {
            val data = currentItem?.sweeperGradient

            // set color sweep to imageview
            val gradient = currentItem?.sweeperDrawable
            gradient?.gradientType = GradientDrawable.SWEEP_GRADIENT
            gradient?.gradientRadius = 140f
            gradient?.setGradientCenter(0.50f, 0.50f)
            Glide.with(context).load(gradient).into(itemBinding.sweeperColor)
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<Sweeper>() {
        override fun areItemsTheSame(oldItem: Sweeper, newItem: Sweeper) = oldItem == newItem


        override fun areContentsTheSame(oldItem: Sweeper, newItem: Sweeper) = oldItem == newItem
    }

    interface SweppeClick {
        fun onSweeperClick(sweeper: Sweeper)
    }

}