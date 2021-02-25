package com.example.shapeolorpp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shapeolorpp.R
import com.example.shapeolorpp.adapters.ViewpagerAdapter
import com.example.shapeolorpp.databinding.DialogRootShitBinding
import com.example.shapeolorpp.ui.fragments.text.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator


class EditorBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: DialogRootShitBinding


    /*  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

          return super.onCreateDialog(savedInstanceState).apply {

              setOnShowListener {
                  val bottomSheet = findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
                  bottomSheet.setBackgroundResource(android.R.color.transparent)
              }
          }
      }*/

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
            FontSpacerFragment(),
            LinearColorFragment(),
            RadialColorFragment(),
            FontColorFragment()
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
                2 -> tab.setIcon(R.drawable.ic_spacer)
                3 -> tab.setIcon(R.drawable.ic_linear)
                4 -> tab.setIcon(R.drawable.ic_greadient)
                5 -> tab.setIcon(R.drawable.ic_colors)
            }
            binding.viewPagertFragment.setCurrentItem(tab.position, true)
        }.attach()

    }


}