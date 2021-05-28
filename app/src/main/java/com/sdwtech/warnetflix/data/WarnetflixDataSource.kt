package com.sdwtech.warnetflix.data

import androidx.lifecycle.LiveData
import com.sdwtech.warnetflix.data.source.remote.response.DetailMovieResponse
import com.sdwtech.warnetflix.data.source.remote.response.DetailTvShowResponse
import com.sdwtech.warnetflix.data.source.remote.response.Movies
import com.sdwtech.warnetflix.data.source.remote.response.TvShows

interface WarnetflixDataSource {
    fun getMovies(): LiveData<Movies>

    fun getDetailMovie(movieId: Int): LiveData<DetailMovieResponse>

    fun getTvShow(): LiveData<TvShows>

    fun getDetailTvShow(tvShowId: Int): LiveData<DetailTvShowResponse>
}