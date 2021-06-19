package com.sdwtech.warnetflix.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.R
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity
import com.sdwtech.warnetflix.databinding.ActivityDetailBinding
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.MOVIE
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.sdwtech.warnetflix.viewmodel.ViewModelFactory
import com.sdwtech.warnetflix.vo.Status
import java.lang.StringBuilder

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var detailBinding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    private var type: String? = null

    companion object {
        const val EXTRA_ID = "extra_id"
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

        detailBinding.btnFav.setOnClickListener(this)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras

        val id = extras?.getInt(EXTRA_ID)
        type = extras?.getString(EXTRA_TYPE)

        Log.d("detail activity","id detail: $id , $type")

        if (type != null) {
            if (id != null) {
                viewModel.setType(id, type!!)
            }
            setupState()

            if (type == MOVIE) {
                viewModel.getMovieDetail().observe(this, { movie ->
                    if (movie != null) {
                        when (movie.status) {
                            Status.LOADING -> {
                                detailBinding.progressBar.visibility = View.VISIBLE
                            }
                            Status.SUCCESS ->
                                if (movie.data != null) {
                                    detailBinding.progressBar.visibility = View.GONE
                                    detailBinding.overview.visibility = View.VISIBLE
                                    populateMovie(movie.data)
                                }
                            Status.ERROR -> {
                                detailBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, "aduh, ada yang salah ni", Toast.LENGTH_SHORT).show()
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
                            }
                            Status.SUCCESS ->
                                if (tvShow.data != null) {
                                    detailBinding.progressBar.visibility = View.GONE
                                    detailBinding.overview.visibility = View.VISIBLE
                                    populateTvShow(tvShow.data)
                                }
                            Status.ERROR -> {
                                detailBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, "aduh, ada yang salah ni", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_fav -> {
                onFavClicked()
            }
        }
    }

    private fun setupState() {
        if (type == MOVIE) {
            viewModel.getMovieDetail().observe(this, { movie ->
                when (movie.status) {
                    Status.LOADING -> detailBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        if (movie.data != null) {
                            detailBinding.progressBar.visibility = View.GONE
                            val state = movie.data.isFavorite
                            setFavState(state)
                        }
                    }
                    Status.ERROR -> {
                        detailBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "aduh, ada yang salah ni, pasti kamu cowo", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        } else if (type == TV_SHOW) {
            viewModel.getTvShowDetail().observe(this, { tvShow ->
                when (tvShow.status) {
                    Status.LOADING -> detailBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        if (tvShow. data != null) {
                            detailBinding.progressBar.visibility = View.GONE
                            val state = tvShow.data.isFavorite
                            setFavState(state)
                        }
                    }
                    Status.ERROR -> {
                        detailBinding.progressBar.visibility =View.GONE
                        Toast.makeText(applicationContext,"aduh, ada yang salah ni, pasti kamu cowo", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

    private fun onFavClicked() {
        if (type == MOVIE) {
            viewModel.setFavoriteMovie()
        } else if (type == TV_SHOW) {
            viewModel.setFavoriteTvShow()
        }
    }

    private fun setFavState(isFav: Boolean) {
        if (isFav) {
            detailBinding.btnFav.setImageResource(R.drawable.ic_favorite_24)
        } else {
            detailBinding.btnFav.setImageResource(R.drawable.ic_favorite_border_24)
        }
    }

    private fun populateMovie(movie: MovieEntity) {
        val imgTrailer = "https://image.tmdb.org/t/p/w533_and_h300_bestv2"
        val imageUrl = "https://image.tmdb.org/t/p/original"
        detailBinding.tvDetailTitle.text = movie.title
        detailBinding.tvDesc.text = movie.overview
        detailBinding.tvRating.text = StringBuilder("Rating: " + movie.voteAverage)

        Glide.with(this)
                .load(imgTrailer + movie.backdropPath)
                .into(detailBinding.imgTrailer)

        Glide.with(this)
            .load(imageUrl + movie.posterPath)
            .transform(RoundedCorners(8))
            .into(detailBinding.imgPoster)
    }

    private fun populateTvShow(tvShow: TvShowEntity) {
        val imgTrailer = "https://image.tmdb.org/t/p/w533_and_h300_bestv2"
        val imageUrl = "https://image.tmdb.org/t/p/original"
        detailBinding.tvDetailTitle.text = tvShow.name
        detailBinding.tvDesc.text = tvShow.overview
        detailBinding.tvRating.text = StringBuilder("Rating: " + tvShow.voteAverage)

        Glide.with(this)
                .load(imgTrailer + tvShow.backdropPath)
                .into(detailBinding.imgTrailer)
        Glide.with(this)
            .load(imageUrl + tvShow.posterPath)
            .transform(RoundedCorners(8))
            .into(detailBinding.imgPoster)
    }
}