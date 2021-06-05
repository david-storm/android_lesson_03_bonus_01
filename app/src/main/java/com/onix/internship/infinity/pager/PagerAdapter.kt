package com.onix.internship.infinity.pager

import androidx.fragment.app.Fragment

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.onix.internship.infinity.infinity.InfinityFragment

class PagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> InfinityFragment()
            else -> InfinityFragment()
        }
    }
}