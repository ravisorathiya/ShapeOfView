package com.example.shapeolorpp.ui.bottomshits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.BodyHorizontalAdapter
import com.example.shapeolorpp.models.BodyHorizontalData
import com.example.shapeolorpp.utills.BodyHorizontal
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomShitHorizontalFragment : BottomSheetDialogFragment(),
    BodyHorizontalAdapter.OnBodyColorClick {
    private lateinit var listBodyColor: ArrayList<BodyHorizontalData>


    lateinit var viewLayout: ConstraintLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_bodyhorizontal_color, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecylcleBodyColor()
    }

    private fun setupRecylcleBodyColor() {
        val adapterBodyColor = BodyHorizontalAdapter(this)
        val rvBody = view?.findViewById<RecyclerView>(R.id.rv_back_color)
        listBodyColor = BodyHorizontal.colorCollector()
        rvBody?.setHasFixedSize(true)
        rvBody?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        adapterBodyColor.submitList(listBodyColor)
        rvBody?.adapter = adapterBodyColor
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