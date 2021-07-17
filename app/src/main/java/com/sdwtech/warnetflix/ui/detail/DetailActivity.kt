package com.sdwtech.warnetflix.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.R
import com.sdwtech.warnetflix.core.data.Resource
import com.sdwtech.warnetflix.core.domain.model.Movie
import com.sdwtech.warnetflix.core.domain.model.TvShow
import com.sdwtech.warnetflix.databinding.ActivityDetailBinding
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.MOVIE
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.TV_SHOW
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var detailBinding: ActivityDetailBinding
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

        val extras = intent.extras

        val id = extras?.getInt(EXTRA_ID)
        type = extras?.getString(EXTRA_TYPE)

        Log.d("detail activity","id detail: $id , $type")

        if (type != null) {
            if (id != null) {
                detailViewModel.setType(id, type!!)
            }
            setupState()

            if (type == MOVIE) {
                detailViewModel.getMovieDetail().observe(this, { movie ->
                    if (movie != null) {
                        when (movie) {
                            is Resource.Loading -> {
                                detailBinding.progressBar.visibility = View.VISIBLE
                            }
                            is Resource.Success ->
                                if (movie.data != null) {
                                    detailBinding.progressBar.visibility = View.GONE
                                    detailBinding.overview.visibility = View.VISIBLE
                                    populateMovie(movie.data!!)
                                }
                            is Resource.Error -> {
                                detailBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, "aduh, ada yang salah ni", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            } else if (type == TV_SHOW) {
                detailViewModel.getTvShowDetail().observe(this, { tvShow ->
                    if (tvShow != null) {
                        when (tvShow) {
                            is Resource.Loading -> {
                                detailBinding.progressBar.visibility = View.VISIBLE
                            }
                            is Resource.Success ->
                                if (tvShow.data != null) {
                                    detailBinding.progressBar.visibility = View.GONE
                                    detailBinding.overview.visibility = View.VISIBLE
                                    populateTvShow(tvShow.data!!)
                                }
                            is Resource.Error -> {
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
            detailViewModel.getMovieDetail().observe(this, { movie ->
                when (movie) {
                    is Resource.Loading -> detailBinding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        if (movie.data != null) {
                            detailBinding.progressBar.visibility = View.GONE
                            val state = movie.data!!.isFavorite
                            setFavState(state)
                        }
                    }
                    is Resource.Error -> {
                        detailBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "aduh, ada yang salah ni, pasti kamu cowo", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        } else if (type == TV_SHOW) {
            detailViewModel.getTvShowDetail().observe(this, { tvShow ->
                when (tvShow) {
                    is Resource.Loading -> detailBinding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        if (tvShow. data != null) {
                            detailBinding.progressBar.visibility = View.GONE
                            val state = tvShow.data!!.isFavorite
                            setFavState(state)
                        }
                    }
                    is Resource.Error -> {
                        detailBinding.progressBar.visibility =View.GONE
                        Toast.makeText(applicationContext,"aduh, ada yang salah ni, pasti kamu cowo", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

    private fun onFavClicked() {
        if (type == MOVIE) {
            detailViewModel.setFavoriteMovie()
        } else if (type == TV_SHOW) {
            detailViewModel.setFavoriteTvShow()
        }
    }

    private fun setFavState(isFav: Boolean) {
        if (isFav) {
            detailBinding.btnFav.setImageResource(R.drawable.ic_favorite_24)
        } else {
            detailBinding.btnFav.setImageResource(R.drawable.ic_favorite_border_24)
        }
    }

    private fun populateMovie(movie: Movie) {
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

    private fun populateTvShow(tvShow: TvShow) {
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