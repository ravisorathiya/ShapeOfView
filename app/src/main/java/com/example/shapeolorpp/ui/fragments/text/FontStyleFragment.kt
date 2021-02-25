package com.example.shapeolorpp.ui.fragments.text

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
import com.example.shapeolorpp.models.FontStyles


class FontStyleFragment(

) : Fragment(R.layout.fragment_font_style),
    FontStyleAdapter.OnFontStyleClick {

    // vars
    private val TAG = "FontStyleFragment"

    // widgets
    lateinit var fontStyleList: ArrayList<FontStyles>
    lateinit var textWishView: TextView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fontStyleAdapterSetup()
    }

    private fun fontStyleAdapterSetup() {

        val adapter = FontStyleAdapter(this)

        val recycle = view?.findViewById<RecyclerView>(R.id.recyclerview_fonr_style)
        fontStyleList = arrayListOf(
            FontStyles(R.font.bold),
            FontStyles(R.font.bold_italic),
            FontStyles(R.font.extra_bold_italic),
            FontStyles(R.font.extra_bold_sabs),
            FontStyles(R.font.light_italic),
            FontStyles(R.font.sans_italics),
            FontStyles(R.font.sans_light),
            FontStyles(R.font.sans_reglular),
            FontStyles(R.font.semi_bold),
            FontStyles(R.font.semi_bold_italic)
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