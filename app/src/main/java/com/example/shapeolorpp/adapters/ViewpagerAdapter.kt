package com.example.shapeolorpp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.shapeolorpp.ui.FontSizeChangeFragment
import com.example.shapeolorpp.ui.FontStyleFragment
import com.example.shapeolorpp.ui.LinearColorFragment
import com.example.shapeolorpp.ui.RadialColorFragment

class ViewpagerAdapter(
    val list: ArrayList<Fragment>,
    fm: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fm,lifecycle) {

    override fun getItemCount() = list.size

    override fun createFragment(position: Int) =  list[position]



}