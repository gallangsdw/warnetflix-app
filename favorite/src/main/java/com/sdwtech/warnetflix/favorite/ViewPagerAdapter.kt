package com.sdwtech.warnetflix.favorite

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sdwtech.warnetflix.R
import com.sdwtech.warnetflix.favorite.movie.FavMovieFragment
import com.sdwtech.warnetflix.favorite.tvshow.FavTvShowFragment

class ViewPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private val TAB_TILES = intArrayOf(R.string.movie, R.string.tvShow)
    }
    override fun getCount(): Int {
        return TAB_TILES.size
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        if (position == 0) {
            fragment = FavMovieFragment()
        } else if (position == 1) {
            fragment = FavTvShowFragment()
        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TILES[position])
    }
}