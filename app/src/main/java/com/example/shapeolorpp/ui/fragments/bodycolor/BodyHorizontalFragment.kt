package com.example.shapeolorpp.ui.fragments.bodycolor

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.BodyHorizontalAdapter
import com.example.shapeolorpp.utills.BodyHorizontal

class BodyHorizontalFragment : Fragment(R.layout.dialog_bodyhorizontal_color),
    BodyHorizontalAdapter.OnBodyColorClick {

    private lateinit var listBodyColor: ArrayList<com.example.shapeolorpp.models.BackgrondHorizontal>
    lateinit var viewLayout: ConstraintLayout


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecylcleBodyColor()
    }

    private fun setupRecylcleBodyColor() {
        val adapterBodyColor = BodyHorizontalAdapter(this)
        listBodyColor = BodyHorizontal.colorCollector()
        adapterBodyColor.submitList(listBodyColor)

        val rvBody = view?.findViewById<RecyclerView>(R.id.rv_back_color)

        rvBody?.apply {
            setHasFixedSize(true)
//             layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            layoutManager = GridLayoutManager(context,6)
            adapter = adapterBodyColor
        }
    }

    override fun changeBodyColor(position: Int) {

        viewLayout = requireActivity().findViewById(R.id.const_layout)
        listBodyColor.forEachIndexed { index, backColorData ->
            if (position == index) {
                val data = backColorData.radialDrawable
                viewLayout.background = data
            }
        }
    }

}