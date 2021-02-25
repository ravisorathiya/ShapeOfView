package com.example.shapeolorpp.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.ViewpagerAdapter
import com.example.shapeolorpp.databinding.BottomshitBodyBinding
import com.example.shapeolorpp.ui.fragments.bodycolor.BodyHorizontalFragment
import com.example.shapeolorpp.ui.fragments.bodycolor.BodyVerticleFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator


class BodyColorFragment : BottomSheetDialogFragment() {

    private lateinit var binding: BottomshitBodyBinding

   override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return super.onCreateDialog(savedInstanceState).apply {

            setOnShowListener {
                val bottomSheet = findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
                bottomSheet.setBackgroundResource(android.R.color.transparent)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.bottomshit_body, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = BottomshitBodyBinding.bind(view)

        setupTabViewPager()

    }


    private fun setupTabViewPager() {

        val fragmentList = arrayListOf(
            BodyHorizontalFragment(),
            BodyVerticleFragment()
        )

        val pagerAdapter = ViewpagerAdapter(
            fragmentList,
            activity?.supportFragmentManager!!,
            lifecycle
        )

        binding.viewPagerBody.adapter = pagerAdapter

        TabLayoutMediator(binding.tabBodyColor, binding.viewPagerBody) { tab, position ->
            when (position) {
                0 -> tab.setIcon(R.drawable.ic_hori)
                1 -> tab.setIcon(R.drawable.ic_verticle)
            }
            binding.viewPagerBody.setCurrentItem(tab.position, true)
        }.attach()

    }
}