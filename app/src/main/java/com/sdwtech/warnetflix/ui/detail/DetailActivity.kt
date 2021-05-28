package com.sdwtech.warnetflix.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

import com.sdwtech.warnetflix.data.source.remote.response.DetailMovieResponse
import com.sdwtech.warnetflix.data.source.remote.response.DetailTvShowResponse
import com.sdwtech.warnetflix.databinding.ActivityDetailBinding
import com.sdwtech.warnetflix.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.hide()

        detailBinding.btnBack.setOnClickListener {
            finish()
        }

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val movieId = intent.getIntExtra(EXTRA_MOVIE,0)
        val tvShowId = intent.getIntExtra(EXTRA_TVSHOW, 0)

        detailBinding.progressBar.visibility = View.VISIBLE
        detailBinding.tvRating.visibility = View.INVISIBLE
        detailBinding.tvDesc.visibility = View.INVISIBLE
        detailBinding.tvDetailTitle.visibility = View.INVISIBLE

        viewModel.setSelectedMovie(movieId)
        viewModel.getMovieDetail().observe(this, { movie ->
            populateMovie(movie)
            detailBinding.progressBar.visibility = View.GONE
            detailBinding.tvRating.visibility = View.VISIBLE
            detailBinding.tvDesc.visibility = View.VISIBLE
            detailBinding.tvDetailTitle.visibility = View.VISIBLE
        })

        viewModel.setSelectedTvShow(tvShowId)
        viewModel.getTvShowDetail().observe(this, {tvShow ->
            populateTvShow(tvShow)
            detailBinding.progressBar.visibility = View.GONE
            detailBinding.tvRating.visibility = View.VISIBLE
            detailBinding.tvDesc.visibility = View.VISIBLE
            detailBinding.tvDetailTitle.visibility = View.VISIBLE
        })
    }

    private fun populateMovie(movie: DetailMovieResponse) {
        val imageUrl = "https://image.tmdb.org/t/p/w500"
        detailBinding.tvDetailTitle.text = movie.title
        detailBinding.tvDesc.text = movie.overview
        detailBinding.tvRating.text = movie.voteAverage.toString()

        Glide.with(this)
                .load(imageUrl + movie.backdropPath)
                .transform(RoundedCorners(15))
                .into(detailBinding.imgTrailer)
    }

    private fun populateTvShow(tvShow: DetailTvShowResponse) {
        val imageUrl = "https://image.tmdb.org/t/p/w500"
        detailBinding.tvDetailTitle.text = tvShow.name
        detailBinding.tvDesc.text = tvShow.overview
        detailBinding.tvRating.text = tvShow.voteAverage.toString()

        Glide.with(this)
                .load(imageUrl + tvShow.backdropPath)
                .transform(RoundedCorners(15))
                .into(detailBinding.imgTrailer)
    }
}