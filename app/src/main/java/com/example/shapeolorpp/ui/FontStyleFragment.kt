package com.example.shapeolorpp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.FontStyleAdapter
import com.example.shapeolorpp.models.FontStyleData


class FontStyleFragment(

) : Fragment(R.layout.fragment_font_style),
    FontStyleAdapter.OnFontStyleClick {

    // vars
    private val TAG = "FontStyleFragment"

    // widgets
    lateinit var fontStyleList: ArrayList<FontStyleData>
    lateinit var textWishView: TextView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fontStyleAdapterSetup()
    }

    private fun fontStyleAdapterSetup() {

        val adapter = FontStyleAdapter(this)

        val recycle = view?.findViewById<RecyclerView>(R.id.recyclerview_fonr_style)
        fontStyleList = arrayListOf(
            FontStyleData(R.font.bold),
            FontStyleData(R.font.bold_italic),
            FontStyleData(R.font.extra_bold_italic),
            FontStyleData(R.font.extra_bold_sabs),
            FontStyleData(R.font.light_italic),
            FontStyleData(R.font.sans_italics),
            FontStyleData(R.font.sans_light),
            FontStyleData(R.font.sans_reglular),
            FontStyleData(R.font.semi_bold),
            FontStyleData(R.font.semi_bold_italic)
        )

        adapter.differ.submitList(fontStyleList)
        recycle?.setHasFixedSize(true)
        recycle?.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, true
        )
        recycle?.adapter = adapter

    }

    // interface implemantaion
    override fun onStyleChange(position: Int) {
        textWishView = requireActivity().findViewById(R.id.text_wish)
        fontStyleList.forEachIndexed { index, fontStyleData -> 
            if (index == position){
                Log.d(TAG, "onStyleChange: $index : $position")
                val style = fontStyleData.font

                textWishView.typeface = style?.let {
                    ResourcesCompat.getFont(
                        requireContext(), it
                    )
                }

            }
        }
    }

}