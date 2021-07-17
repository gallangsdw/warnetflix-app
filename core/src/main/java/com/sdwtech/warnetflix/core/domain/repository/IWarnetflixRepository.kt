package com.sdwtech.warnetflix.core.domain.repository

import com.sdwtech.warnetflix.core.domain.model.Movie
import com.sdwtech.warnetflix.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface IWarnetflixRepository {
    fun getMovies(): Flow<com.sdwtech.warnetflix.core.data.Resource<List<Movie>>>

    fun getDetailMovie(movieId: Int): Flow<com.sdwtech.warnetflix.core.data.Resource<Movie>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, isFavorite: Boolean)

    fun getTvShow(): Flow<com.sdwtech.warnetflix.core.data.Resource<List<TvShow>>>

    fun getDetailTvShow(tvShowId: Int): Flow<com.sdwtech.warnetflix.core.data.Resource<TvShow>>

    fun getFavoriteTvShow(): Flow<List<TvShow>>

    fun setFavoriteTvShow(tvShow: TvShow, isFavorite: Boolean)
}