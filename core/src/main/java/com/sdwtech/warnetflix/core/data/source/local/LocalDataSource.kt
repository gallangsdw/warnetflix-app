package com.sdwtech.warnetflix.core.data.source.local

import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val mWarnetflixDao: com.sdwtech.warnetflix.core.data.source.local.room.WarnetflixDao) {

    fun getAllMovies(): Flow<List<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity>> = mWarnetflixDao.getMovies()

    fun getMovieById(id: Int): Flow<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity> = mWarnetflixDao.getMovieById(id)

    fun getTvShows(): Flow<List<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity>> = mWarnetflixDao.getTvShows()

    fun getTvShowId(id: Int): Flow<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity> = mWarnetflixDao.getTvShowById(id)

    fun insertMovies(movies: List<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity>) = mWarnetflixDao.insertMovies(movies)

    fun updateMovie(movie: com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity) = mWarnetflixDao.updateMovie(movie)

    fun insertTvShows(tvShows: List<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity>) = mWarnetflixDao.insertTvShows(tvShows)

    fun updateTvShow(tvShow: com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity) = mWarnetflixDao.updateTvShow(tvShow)

    fun getFavMovies(): Flow<List<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity>> = mWarnetflixDao.getFavoriteMovies()

    fun setMovieFavorite(movie: com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity, newSate: Boolean) {
        movie.isFavorite = newSate
        mWarnetflixDao.updateMovie(movie)
    }

    fun getFavTvShows(): Flow<List<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity>> = mWarnetflixDao.getFavoriteTvShows()

    fun setTvShowFavorite(tvShow: com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity, newSate: Boolean) {
        tvShow.isFavorite = newSate
        mWarnetflixDao.updateTvShow(tvShow)
    }
}