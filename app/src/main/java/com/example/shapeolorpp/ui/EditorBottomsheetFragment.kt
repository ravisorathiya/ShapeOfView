package com.example.shapeolorpp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.ViewpagerAdapter
import com.example.shapeolorpp.databinding.DialogRootShitBinding
import com.example.shapeolorpp.ui.fragments.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.dialog_root_shit.view.*

class EditorBottomsheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: DialogRootShitBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_root_shit, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DialogRootShitBinding.bind(view)

        setupTabViewPager()


    }

    private fun setupTabViewPager() {
        val fragmentList = arrayListOf(
            FontStyleFragment(),
            FontSizeChangeFragment(),
            LinearColorFragment(),
            RadialColorFragment(),
            ColorFragment()
        )

        val pagerAdapter = ViewpagerAdapter(
            fragmentList,
            activity?.supportFragmentManager!!,
            lifecycle
        )

        binding.viewPagertFragment.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPagertFragment) { tab, position ->
            when (position) {
                0 -> tab.setIcon(R.drawable.ic_font)
                1 -> tab.setIcon(R.drawable.ic_textsize)
                2 -> tab.setIcon(R.drawable.ic_linear)
                3 -> tab.setIcon(R.drawable.ic_greadient)
                4 -> tab.setIcon(R.drawable.ic_greadient)
            }
            binding.viewPagertFragment.setCurrentItem(tab.position, true)
        }.attach()

    }


}