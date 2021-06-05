package com.onix.internship.infinity.pager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.onix.internship.infinity.databinding.FragmentPagerBinding


class PagerFragment : Fragment() {

    private lateinit var binding: FragmentPagerBinding
    private lateinit var pagerAdapter: PagerAdapter
    private lateinit var viewPager: ViewPager2


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPagerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pagerAdapter = PagerAdapter(this)
        viewPager = binding.pager
        viewPager.adapter = pagerAdapter
        TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "test1"
                else -> "test2"
            }
        }.attach()
    }

}
