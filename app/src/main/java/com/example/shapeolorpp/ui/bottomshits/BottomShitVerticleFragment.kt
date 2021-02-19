package com.example.shapeolorpp.ui.bottomshits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.BodyVerticleAdapter
import com.example.shapeolorpp.models.BodyVerticleData
import com.example.shapeolorpp.utills.BodyVerticle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomShitVerticleFragment : BottomSheetDialogFragment() ,  BodyVerticleAdapter.VerticleColorSet {
    private lateinit var listVerticleColor: ArrayList<BodyVerticleData>
    lateinit var viewLayout: ConstraintLayout


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dailog_bodyverticle_color,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecylcleBodyColor()
    }


    private fun setupRecylcleBodyColor() {
        val rvVerticle = view?.findViewById<RecyclerView>(R.id.rv_verticle_body_color)
        val verticleAdapter = BodyVerticleAdapter(this)
        rvVerticle?.setHasFixedSize(true)
        listVerticleColor = BodyVerticle.verticleColor()
        BodyVerticleAdapter(this)
        verticleAdapter.submitList(listVerticleColor)
        rvVerticle?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        rvVerticle?.adapter = verticleAdapter
    }

    override fun onVerticle(position: Int) {
        viewLayout = requireActivity().findViewById(R.id.const_layout)
        listVerticleColor.forEachIndexed { index, bodyVerticleColorData ->

            if (position == index) {
                val data = bodyVerticleColorData.radialDrawable
                viewLayout.background = data
            }

        }
    }
}
