package com.sdwtech.warnetflix.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.Entity

class DetailViewModel(private val warnetflixRepository: WarnetflixRepository): ViewModel() {
    lateinit var movieId: String
    lateinit var tvShowId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getMovieDetail(): LiveData<Entity> = warnetflixRepository.getDetailMovie(movieId)

    fun getTvShowDetail(): LiveData<Entity> = warnetflixRepository.getDetailTvShow(tvShowId)
}