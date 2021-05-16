package com.sdwtech.warnetflix.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.data.source.local.entity.Entity
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

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            val tvShowId = extras.getString(EXTRA_TVSHOW)

            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                viewModel.getMovieDetail().observe(this, { movie ->
                    populate(movie)
                })
            } else if (tvShowId != null) {
                viewModel.getTvShowDetail().observe(this,{tvShow ->
                    populate(tvShow)
                })
            }
        }
    }

    private fun populate(entity: Entity) {
        val imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2"
        detailBinding.tvDetailTitle.text = entity.title
        detailBinding.tvDesc.text = entity.description
        detailBinding.tvRating.text = entity.rating.toString()

        Glide.with(this)
            .load(imageUrl + entity.imgTrailer)
            .transform(RoundedCorners(15))
            .into(detailBinding.imgTrailer)
    }
}