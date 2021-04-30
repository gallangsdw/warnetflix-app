package com.sdwtech.warnetflix.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.sdwtech.warnetflix.data.Entity
import com.sdwtech.warnetflix.databinding.ActivityDetailBinding

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

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            val tvShowId = extras.getString(EXTRA_TVSHOW)

            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                populate(viewModel.getMovie())
            } else if (tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId)
                populate(viewModel.getTvShow())
            }
        }
    }

    private fun populate(entity: Entity) {
        detailBinding.tvDetailTitle.text = entity.title
        detailBinding.tvDesc.text = entity.description
        detailBinding.tvRating.text = entity.rating

        Glide.with(this)
            .load(entity.imgTrailer)
            .transform(RoundedCorners(15))
            .into(detailBinding.imgTrailer)
    }
}