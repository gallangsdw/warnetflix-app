package com.sdwtech.warnetflix.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdwtech.warnetflix.core.domain.model.Movie
import com.sdwtech.warnetflix.favorite.R
import com.sdwtech.warnetflix.favorite.databinding.FragmentFavMovieBinding
import com.sdwtech.warnetflix.favorite.favModule
import com.sdwtech.warnetflix.ui.detail.DetailActivity
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.MOVIE
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavMovieFragment : Fragment(), FavMovieAdapter.OnItemClickCallBack {

    private val viewModel: FavMovieViewModel by viewModel()
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

        loadKoinModules(favModule)

        val favoriteMovieAdapter = FavMovieAdapter()
        favoriteMovieAdapter.setOnItemClickCallBack(this)

        viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { favorite ->
            if (favorite != null) {
                favoriteMovieAdapter.setData(favorite)
            }
        })

        with(favMovieBinding.rvFavMovie) {
            layoutManager = LinearLayoutManager(context)
            adapter = favoriteMovieAdapter
        }
    }

    override fun onItemClicked(movie: Movie) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, movie.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, MOVIE)

        Log.d("fav movie","intent fav:$intent")
        context?.startActivity(intent)
    }
}