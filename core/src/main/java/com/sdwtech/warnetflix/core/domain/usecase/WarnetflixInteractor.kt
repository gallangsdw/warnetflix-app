package com.sdwtech.warnetflix.core.domain.usecase

import com.sdwtech.warnetflix.core.domain.model.Movie
import com.sdwtech.warnetflix.core.domain.model.TvShow
import com.sdwtech.warnetflix.core.domain.repository.IWarnetflixRepository
import kotlinx.coroutines.flow.Flow

class WarnetflixInteractor(private val warnetflixRepository: IWarnetflixRepository): WarnetflixUseCase {
    override fun getAllMovies(): Flow<com.sdwtech.warnetflix.core.data.Resource<List<Movie>>> = warnetflixRepository.getMovies()

    override fun getDetailMovie(movieId: Int): Flow<com.sdwtech.warnetflix.core.data.Resource<Movie>> = warnetflixRepository.getDetailMovie(movieId)

    override fun getAllTvShows(): Flow<com.sdwtech.warnetflix.core.data.Resource<List<TvShow>>> = warnetflixRepository.getTvShow()

    override fun getDetailTvShow(tvShowId: Int): Flow<com.sdwtech.warnetflix.core.data.Resource<TvShow>> = warnetflixRepository.getDetailTvShow(tvShowId)

    override fun getFavoriteMovie(): Flow<List<Movie>> = warnetflixRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: Movie, isFavorite: Boolean) = warnetflixRepository.setFavoriteMovie(movie, isFavorite)

    override fun getFavoriteTvShow(): Flow<List<TvShow>> = warnetflixRepository.getFavoriteTvShow()

    override fun setFavoriteTvShow(tvShow: TvShow, isFavorite: Boolean) = warnetflixRepository.setFavoriteTvShow(tvShow, isFavorite)

}