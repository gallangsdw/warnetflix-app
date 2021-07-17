package com.sdwtech.warnetflix.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sdwtech.warnetflix.core.domain.model.Movie
import com.sdwtech.warnetflix.core.domain.model.TvShow
import com.sdwtech.warnetflix.core.domain.usecase.WarnetflixUseCase

class DetailViewModel(private val warnetflixUseCase: WarnetflixUseCase): ViewModel() {

    companion object {
        const val MOVIE = "movie"
        const val TV_SHOW = "tv_show"
    }

    private lateinit var detailMovie: LiveData<com.sdwtech.warnetflix.core.data.Resource<Movie>>
    private lateinit var detailTvShow: LiveData<com.sdwtech.warnetflix.core.data.Resource<TvShow>>

    fun setType(id: Int, type: String) {
        when (type) {
            MOVIE -> {
                detailMovie = warnetflixUseCase.getDetailMovie(id).asLiveData()
            }
            TV_SHOW -> {
                detailTvShow = warnetflixUseCase.getDetailTvShow(id).asLiveData()
            }
        }
    }

    fun getMovieDetail() = detailMovie

    fun getTvShowDetail() = detailTvShow

    fun setFavoriteMovie() {
        val movieSource = detailMovie.value
        if (movieSource?.data != null) {
            val newState = !movieSource.data!!.isFavorite
            warnetflixUseCase.setFavoriteMovie(movieSource.data!!, newState)
        }
    }

    fun setFavoriteTvShow() {
        val tvShowResource = detailTvShow.value
        if (tvShowResource?.data != null) {
            val newState = !tvShowResource.data!!.isFavorite
            warnetflixUseCase.setFavoriteTvShow(tvShowResource.data!!, newState)
        }
    }
}
