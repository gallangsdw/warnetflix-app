package com.sdwtech.warnetflix.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity
import com.sdwtech.warnetflix.vo.Resource

class DetailViewModel(private val warnetflixRepository: WarnetflixRepository): ViewModel() {

    companion object {
        const val MOVIE = "movie"
        const val TV_SHOW = "tv_show"
    }

    private lateinit var detailMovie: LiveData<Resource<MovieEntity>>
    private lateinit var detailTvShow: LiveData<Resource<TvShowEntity>>

    fun setType(id: Int, type: String) {
        when (type) {
            MOVIE -> {
                detailMovie = warnetflixRepository.getDetailMovie(id)
            }
            TV_SHOW -> {
                detailTvShow = warnetflixRepository.getDetailTvShow(id)
            }
        }
    }

    fun getMovieDetail() = detailMovie

    fun getTvShowDetail() = detailTvShow

    fun setFavoriteMovie() {
        val movieSource = detailMovie.value
        if (movieSource?.data != null) {
            val newState = !movieSource.data.isFavorite
            warnetflixRepository.setFavoriteMovie(movieSource.data, newState)
        }
    }

    fun setFavoriteTvShow() {
        val tvShowResource = detailTvShow.value
        if (tvShowResource?.data != null) {
            val newState = !tvShowResource.data.isFavorite
            warnetflixRepository.setFavoriteTvShow(tvShowResource.data, newState)
        }
    }
}
