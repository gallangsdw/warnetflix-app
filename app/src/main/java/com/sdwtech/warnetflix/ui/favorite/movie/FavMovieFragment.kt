package com.sdwtech.warnetflix.ui.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdwtech.warnetflix.R
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.databinding.FragmentFavMovieBinding
import com.sdwtech.warnetflix.ui.detail.DetailActivity
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.MOVIE
import com.sdwtech.warnetflix.viewmodel.ViewModelFactory

class FavMovieFragment : Fragment(), FavMovieAdapter.OnItemClickCallBack {

    private val favMovieBinding: FragmentFavMovieBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[FavMovieViewModel::class.java]

        val favoriteMovieAdapter = FavMovieAdapter()
        favoriteMovieAdapter.setOnItemClickCallBack(this)

        viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { favorite ->
            if (favorite != null) {
                favoriteMovieAdapter.submitList(favorite)
            }
        })

        with(favMovieBinding.rvFavMovie) {
            layoutManager = LinearLayoutManager(context)
            adapter = favoriteMovieAdapter
        }
    }

    override fun onItemClicked(movieEntity: MovieEntity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_MOVIE, movieEntity.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, MOVIE)

        Log.d("fav movie","intent fav:$intent")
        context?.startActivity(intent)
    }
}