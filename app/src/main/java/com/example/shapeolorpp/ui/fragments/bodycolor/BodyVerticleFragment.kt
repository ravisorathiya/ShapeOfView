package com.example.shapeolorpp.ui.fragments.bodycolor

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.BodyVerticleAdapter
import com.example.shapeolorpp.models.BackgrondVerticle
import com.example.shapeolorpp.utills.BodyVerticle

class BodyVerticleFragment : Fragment(R.layout.dailog_bodyverticle_color),
    BodyVerticleAdapter.VerticleColorSet {
    private lateinit var listVentricleColor: ArrayList<BackgrondVerticle>
    lateinit var viewLayout: ConstraintLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecylcleBodyColor()
    }

    private fun setupRecylcleBodyColor() {
        val rvVentricle = view?.findViewById<RecyclerView>(R.id.rv_verticle_body_color)
        val ventricleAdapter = BodyVerticleAdapter(this)
        rvVentricle?.setHasFixedSize(true)
        listVentricleColor = BodyVerticle.verticleColor()
        BodyVerticleAdapter(this)
        ventricleAdapter.submitList(listVentricleColor)
        rvVentricle?.layoutManager = GridLayoutManager(context, 6)
        rvVentricle?.adapter = ventricleAdapter
    }

    override fun onVerticle(position: Int) {
        viewLayout = requireActivity().findViewById(R.id.const_layout)
        listVentricleColor.forEachIndexed { index, bodyVentricleColorData ->

            if (position == index) {
                val data = bodyVentricleColorData.radialDrawable
                viewLayout.background = data
            }

        }
    }
}
