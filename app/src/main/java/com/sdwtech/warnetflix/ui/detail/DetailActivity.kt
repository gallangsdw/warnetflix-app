package com.sdwtech.warnetflix.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity
import com.sdwtech.warnetflix.databinding.ActivityDetailBinding
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.MOVIE
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.sdwtech.warnetflix.viewmodel.ViewModelFactory
import com.sdwtech.warnetflix.vo.Status

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    private var type: String? = null

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TVSHOW = "extra_tvshow"
        const val EXTRA_TYPE = "extra_type"
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
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras

        type = extras?.getString(EXTRA_TYPE)
        val id = intent.getIntExtra(EXTRA_MOVIE,0)
        val tvShowId = intent.getIntExtra(EXTRA_TVSHOW, 0)

        type?.let {
            viewModel.setType(id, it)
        }

        if (type == MOVIE) {
            viewModel.getMovieDetail().observe(this, { movie ->
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> {
                            detailBinding.progressBar.visibility = View.VISIBLE
                            detailBinding.tvDetailTitle.visibility = View.GONE
                            detailBinding.tvDesc.visibility = View.GONE
                            detailBinding.tvRating.visibility = View.GONE
                            detailBinding.imgTrailer.visibility = View.GONE
                            detailBinding.overview.visibility = View.GONE
                        }
                        Status.SUCCESS ->
                            if (movie.data != null) {
                                detailBinding.progressBar.visibility = View.GONE
                                detailBinding.overview.visibility = View.VISIBLE
                                populateMovie(movie.data)
                            }
                        Status.ERROR -> {
                            detailBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext,"aduh, ada yang salah ni, pasti kamu cowo", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        } else if (type == TV_SHOW) {
            viewModel.getTvShowDetail().observe(this, { tvShow ->
                if (tvShow != null) {
                    when (tvShow.status) {
                        Status.LOADING -> {
                            detailBinding.progressBar.visibility = View.VISIBLE
                            detailBinding.progressBar.visibility = View.VISIBLE
                            detailBinding.tvDetailTitle.visibility = View.GONE
                            detailBinding.tvDesc.visibility = View.GONE
                            detailBinding.tvRating.visibility = View.GONE
                            detailBinding.imgTrailer.visibility = View.GONE
                            detailBinding.overview.visibility = View.GONE
                        }
                        Status.SUCCESS ->
                            if (tvShow.data != null) {
                                detailBinding.progressBar.visibility = View.GONE
                                detailBinding.overview.visibility = View.GONE
                                populateTvShow(tvShow.data)
                            }
                        Status.ERROR -> {
                            detailBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "aduh, ada yang salah ni, pasti kamu cowo", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
    }

    private fun populateMovie(movie: MovieEntity) {
        val imageUrl = "https://image.tmdb.org/t/p/w500"
        detailBinding.tvDetailTitle.text = movie.title
        detailBinding.tvDesc.text = movie.overview
        detailBinding.tvRating.text = movie.voteAverage

        Glide.with(this)
                .load(imageUrl + movie.backdropPath)
                .transform(RoundedCorners(15))
                .into(detailBinding.imgTrailer)
    }

    private fun populateTvShow(tvShow: TvShowEntity) {
        val imageUrl = "https://image.tmdb.org/t/p/w500"
        detailBinding.tvDetailTitle.text = tvShow.name
        detailBinding.tvDesc.text = tvShow.overview
        detailBinding.tvRating.text = tvShow.voteAverage

        Glide.with(this)
                .load(imageUrl + tvShow.backdropPath)
                .transform(RoundedCorners(15))
                .into(detailBinding.imgTrailer)
    }
}