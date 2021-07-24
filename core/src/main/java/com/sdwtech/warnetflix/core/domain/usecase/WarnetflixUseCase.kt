package com.sdwtech.warnetflix.core.domain.usecase

import com.sdwtech.warnetflix.core.domain.model.Movie
import com.sdwtech.warnetflix.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface WarnetflixUseCase {

    fun getAllMovies(): Flow<com.sdwtech.warnetflix.core.data.Resource<List<Movie>>>

    fun getDetailMovie(movieId: Int): Flow<com.sdwtech.warnetflix.core.data.Resource<Movie>>

    fun getAllTvShows(): Flow<com.sdwtech.warnetflix.core.data.Resource<List<TvShow>>>

    fun getDetailTvShow(tvShowId: Int): Flow<com.sdwtech.warnetflix.core.data.Resource<TvShow>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, isFavorite: Boolean)

    fun getFavoriteTvShow(): Flow<List<TvShow>>

    fun setFavoriteTvShow(tvShow: TvShow, isFavorite: Boolean)
}