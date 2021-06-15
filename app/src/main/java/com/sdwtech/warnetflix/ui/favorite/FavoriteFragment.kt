package com.sdwtech.warnetflix.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import com.sdwtech.warnetflix.R
import com.sdwtech.warnetflix.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment() {

    private val favoriteBinding : FragmentFavoriteBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPagerAdapter = ViewPagerAdapter(requireActivity(), childFragmentManager)
        favoriteBinding.viewPager.adapter = viewPagerAdapter
        favoriteBinding.tabLayout.setupWithViewPager(favoriteBinding.viewPager)
    }
}