package com.sdwtech.warnetflix.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.remote.response.DetailMovieResponse
import com.sdwtech.warnetflix.data.source.remote.response.DetailTvShowResponse

class DetailViewModel(private val warnetflixRepository: WarnetflixRepository): ViewModel() {
    private var movieId = 0
    private var tvShowId = 0

    fun setSelectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun setSelectedTvShow(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun getMovieDetail(): LiveData<DetailMovieResponse> = warnetflixRepository.getDetailMovie(movieId)

    fun getTvShowDetail(): LiveData<DetailTvShowResponse> = warnetflixRepository.getDetailTvShow(tvShowId)
}
