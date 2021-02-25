package com.example.shapeolorpp.ui.fragments.text

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shapeofview.data.RadialShade
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.RadialAdapter
import com.example.shapeolorpp.utills.RadialColor

class RadialFragment
    : Fragment(R.layout.fragment_font_radial),
    RadialAdapter.OnRadialSetListener {

    private lateinit var radialRecyclerView: RecyclerView
    private lateinit var textWishView: TextView
    private lateinit var listRadialColor: ArrayList<RadialShade>



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textWishView = requireActivity().findViewById(R.id.text_wish)

        val paint = textWishView.paint
        val width = paint.measureText(textWishView.text.toString())
        val size = textWishView.textSize

        listRadialColor = RadialColor.radialColorObj(width, size)

        setupRadialRecyclerView()


    }

    private fun setupRadialRecyclerView() {

        val adapterRadial = RadialAdapter(this)
        radialRecyclerView = view?.findViewById(R.id.radial_recycler_view)!!
        radialRecyclerView.apply {

            adapterRadial.submitList(listRadialColor)
            layoutManager = GridLayoutManager(context, 6)
            setHasFixedSize(true)
            adapter = adapterRadial
        }

    }

    override fun setRadialColor(position: Int) {
        listRadialColor.forEachIndexed { index, radialData ->

            if (position == index) {

                radialData.circleColor?.let { textWishView.setTextColor(it) }
                textWishView.paint.shader = radialData.fontRadialShader

            }


        }
    }


}