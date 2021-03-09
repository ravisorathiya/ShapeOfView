package com.example.shapeolorpp.ui.fragments.text

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.shapeolorpp.R
import com.example.shapeolorpp.databinding.FragmentSweepterBinding

class SweepFragment : Fragment(R.layout.fragment_sweepter) {


    private lateinit var binding: FragmentSweepterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSweepterBinding.bind(view)

    }

}