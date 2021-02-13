package com.example.shapeolorpp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shapeolorpp.R
import com.example.shapeolorpp.data.FontStyleData

class FontStyleAdapter(
    private val onFontClick : OnFontStyleClick
): RecyclerView.Adapter<FontStyleAdapter.FontStyleHolder>()  {


    private val differCallback = object : DiffUtil.ItemCallback<FontStyleData>(){
        override fun areItemsTheSame(oldItem: FontStyleData, newItem: FontStyleData):
                Boolean = oldItem.font === newItem.font

        override fun areContentsTheSame(oldItem: FontStyleData, newItem: FontStyleData):
                Boolean = oldItem == newItem
    }

    val differ = AsyncListDiffer(this,differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FontStyleHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fontstyle,parent,false)
        return FontStyleHolder(view)
    }


    override fun onBindViewHolder(holder: FontStyleHolder, position: Int) {


        val fontStyle = listOf(
            "Bold", "Italic", "Extra Bold"
            , "Extra Sab", "italic", "sans", "light", "regular"
            , "semi", "bold italic"
        )

        fontStyle.forEachIndexed { index, s ->

            if (index == position)
                holder.button.text = s
        }

    }

    override fun getItemCount(): Int = differ.currentList.size


    inner class FontStyleHolder(itemView : View) : RecyclerView.ViewHolder(itemView){


        val button = itemView.findViewById<Button>(R.id.btn_font_changer)


        init {


            button.setOnClickListener {
                val position = adapterPosition
                onFontClick.onStyleChange(position)
            }
        }

    }

    interface OnFontStyleClick {
        fun onStyleChange(position: Int)

    }


}