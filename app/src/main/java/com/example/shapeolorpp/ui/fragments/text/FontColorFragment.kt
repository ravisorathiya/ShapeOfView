package com.example.shapeolorpp.ui.fragments.text

import android.graphics.Point
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shapeofview.data.RadialShade
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.LinearAdapter
import com.example.shapeolorpp.adapters.RadialAdapter
import com.example.shapeolorpp.databinding.FragmentColorsBinding
import com.example.shapeolorpp.models.LinearShade
import com.example.shapeolorpp.utills.LinearColor
import com.example.shapeolorpp.utills.RadialColor

class FontColorFragment : Fragment(R.layout.fragment_colors), LinearAdapter.OnLinearSetColor,
    RadialAdapter.OnRadialSetListener {

    private lateinit var binding: FragmentColorsBinding
    private lateinit var textWishView: TextView
    private lateinit var listOfLinearColor: ArrayList<LinearShade>
    private lateinit var listRadialColor: ArrayList<RadialShade>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentColorsBinding.bind(view)


        binding.imageLinear.setOnClickListener {

            setupRecyclerViewLinear()
        }
        binding.imageGreadint.setOnClickListener {
            setupRecyclerViewGradient()
        }



        textWishView = activity?.findViewById(R.id.text_wish)!!
        val paint = textWishView.paint
        val width = paint.measureText(textWishView.text.toString())
        val size = textWishView.textSize
        val point = Point(textWishView.width,textWishView.height)
        listOfLinearColor = LinearColor.colorCollector(width, size)
        listRadialColor = RadialColor.radialColorObj(width, point)


        setupRecyclerViewLinear()

    }


    private fun setupRecyclerViewGradient() {
        binding.rvColor.apply {
            val adapterRadial = RadialAdapter(context , this@FontColorFragment)
            adapterRadial.submitList(listRadialColor)
            layoutManager = GridLayoutManager(context, 6)
            setHasFixedSize(true)

            adapter = adapterRadial
        }
    }

    private fun setupRecyclerViewLinear() {
        val linerAdapter = context?.let { LinearAdapter(it, this) }

        binding.rvColor.apply {


            linerAdapter?.submitList(listOfLinearColor)
            layoutManager = GridLayoutManager(context, 6)
            setHasFixedSize(true)
            adapter = linerAdapter
        }
    }

    override fun setLinearColor(position: Int) {
        listOfLinearColor.forEachIndexed { index, linearData ->
            if (position == index) {


                linearData.circleColor?.let { textWishView.setTextColor(it) }
                textWishView.paint.shader = linearData.fontShader

            }
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
