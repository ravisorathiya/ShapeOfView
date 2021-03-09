package com.example.shapeolorpp.ui.fragments.text

import android.graphics.*
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shapeofview.data.RadialShade
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.LinearAdapter
import com.example.shapeolorpp.adapters.RadialAdapter
import com.example.shapeolorpp.adapters.SweeperAdapter
import com.example.shapeolorpp.databinding.FragmentColorsBinding
import com.example.shapeolorpp.models.LinearShade
import com.example.shapeolorpp.models.Sweeper
import com.example.shapeolorpp.utills.LinearColor
import com.example.shapeolorpp.utills.RadialColor
import com.example.shapeolorpp.utills.SweeperColor


class FontColorFragment : Fragment(R.layout.fragment_colors), LinearAdapter.OnLinearSetColor,
    RadialAdapter.OnRadialSetListener, SweeperAdapter.SweppeClick {


    private lateinit var binding: FragmentColorsBinding
    private lateinit var textWishView: TextView
    private lateinit var listOfLinearColor: ArrayList<LinearShade>
    private lateinit var listRadialColor: ArrayList<RadialShade>
    private lateinit var listSweeperColor: ArrayList<Sweeper>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentColorsBinding.bind(view)




        spinnerToSelectColor()
        setRecyclerViewOnButton()

        textWishView = activity?.findViewById(R.id.text_wish)!!
        val paint = textWishView.paint
        val width = paint.measureText(textWishView.text.toString())
        val size = textWishView.textSize
        val point = Point(textWishView.width, textWishView.height)
        listOfLinearColor = LinearColor.colorCollector(width, size)
        listRadialColor = RadialColor.radialColorObj(width, point)

        listSweeperColor = context?.let { SweeperColor.sweeperColor(it, point) }!!

        setupRecyclerViewLinear()

    }

    private fun setRecyclerViewOnButton() {

        binding.imageLinear.setOnClickListener {
            setupRecyclerViewLinear()

        }
        binding.imageGreadint.setOnClickListener {
            setupRecyclerViewGradient()
        }


    }

    private fun spinnerToSelectColor() {
        val color = resources.getStringArray(R.array.color)
        val adapter = context?.let { it1 ->
            ArrayAdapter(
                it1,
                android.R.layout.simple_spinner_item, color
            )
        }
        binding.spinnerPickColor.adapter = adapter
        binding.spinnerPickColor.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    when (position) {
                        0 -> {
                            binding.imageGreadint.isEnabled = true
                            binding.imageLinear.isEnabled = true

                            setupRecyclerViewLinear()

                        }
                        1 -> {
                            binding.imageGreadint.isEnabled = true
                            binding.imageLinear.isEnabled = true
                            setupRecyclerViewGradient()
                        }
                        2 -> {
                            setupSweeperRecyclerView()
                            binding.imageGreadint.isEnabled = false
                            binding.imageLinear.isEnabled = false
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

    }

    private fun setupSweeperRecyclerView() {
        binding.rvColor.apply {

            val adapterRadial = SweeperAdapter(context, this@FontColorFragment)
            adapterRadial.submitList(listSweeperColor)
            layoutManager = GridLayoutManager(context, 6)
            setHasFixedSize(true)

            adapter = adapterRadial
        }
    }


    private fun setupRecyclerViewGradient() {
        binding.rvColor.apply {
            val adapterRadial = RadialAdapter(context, this@FontColorFragment)
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

    override fun onSweeperClick(sweeper: Sweeper) {

        sweeper.circleColor?.let { textWishView.setTextColor(it) }

        val colors = intArrayOf(
            -0x78,  // yellow
            -0xff7701,  // blue
            -0x1000000,  // black
            -0x66AD47 // yellow
        )

        val positions = floatArrayOf(0.33f, 0.66f, 0.01f, 1.0f)
        val shaders = SweepGradient(50f, 100f, colors, positions)


        textWishView.paint.shader = sweeper.sweeperGradient

//        val shader = GradientManager(context, Point(textWishView.width, textWishView.height))
//        textWishView.paint.shader = shader.randomSweepGradient


    }
}

private const val TAG = "FontColorFragment"
