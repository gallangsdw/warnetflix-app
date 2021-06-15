package com.sdwtech.warnetflix.ui.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdwtech.warnetflix.R
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity
import com.sdwtech.warnetflix.databinding.FragmentFavTvShowBinding
import com.sdwtech.warnetflix.ui.detail.DetailActivity
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.sdwtech.warnetflix.viewmodel.ViewModelFactory

class FavTvShowFragment : Fragment(), FavTvShowAdapter.OnItemClickCallback {

    private val favTvShowBinding : FragmentFavTvShowBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[FavTvShowViewModel::class.java]

        val favoriteTvShowAdapter = FavTvShowAdapter()
        favoriteTvShowAdapter.setOnItemClickCallback(this)

        viewModel.getFavoriteTvShow().observe(viewLifecycleOwner, { favorite ->
            if (favorite != null) {
                favoriteTvShowAdapter.submitList(favorite)
            }
        })

        with(favTvShowBinding.rvFavTvShow) {
            layoutManager = LinearLayoutManager(context)
            adapter = favoriteTvShowAdapter
        }
    }

    override fun onItemClicked(tvShow: TvShowEntity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_MOVIE, tvShow.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, TV_SHOW)

        Log.d("fav Tv Show", "intent fav: $intent")
        context?.startActivity(intent)
    }
}