package com.example.shapeolorpp.ui.fragments.text

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.LinearAdapter
import com.example.shapeolorpp.models.LinearData
import com.example.shapeolorpp.utills.LinearColor


class LinearColorFragment : Fragment(R.layout.fragement_font_linear),
    LinearAdapter.OnLinearSetColor {

    private lateinit var linearColorRecyclerView: RecyclerView
    private lateinit var textWishView: TextView
    private lateinit var listOfLinearColor: ArrayList<LinearData>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        textWishView = activity?.findViewById(R.id.text_wish)!!
        val paint = textWishView.paint
        val width = paint.measureText(textWishView.text.toString())
        val size = textWishView.textSize

        listOfLinearColor = LinearColor.colorCollector(width, size)

        setupRecyclerViewLinearColor()


    }

    private fun setupRecyclerViewLinearColor() {


        val linerAdapter = LinearAdapter(this)
        linearColorRecyclerView = view?.findViewById(R.id.rv_linear)!!
        linearColorRecyclerView.apply {

            linerAdapter.submitList(listOfLinearColor)
//            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
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


    companion object {
        private const val TAG = "LinearColorFragment"
    }
}