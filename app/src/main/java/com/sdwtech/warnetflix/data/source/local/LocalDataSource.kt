package com.sdwtech.warnetflix.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity
import com.sdwtech.warnetflix.data.source.local.room.WarnetflixDao

class LocalDataSource private constructor(private val mWarnetflixDao: WarnetflixDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(warnetflixDao: WarnetflixDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(warnetflixDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mWarnetflixDao.getMovies()

    fun getMovieById(id: Int): LiveData<MovieEntity> = mWarnetflixDao.getMovieById(id)

    fun getTvShows(): DataSource.Factory<Int, TvShowEntity> = mWarnetflixDao.getTvShows()

    fun getTvShowId(id: Int): LiveData<TvShowEntity> = mWarnetflixDao.getTvShowById(id)

    fun insertMovies(movies: List<MovieEntity>) = mWarnetflixDao.insertMovies(movies)

    fun updateMovie(movie: MovieEntity) = mWarnetflixDao.updateMovie(movie)

    fun insertTvShows(tvShows: List<TvShowEntity>) = mWarnetflixDao.insertTvShows(tvShows)

    fun updateTvShow(tvShow: TvShowEntity) = mWarnetflixDao.updateTvShow(tvShow)

    fun getFavMovies(): DataSource.Factory<Int, MovieEntity> = mWarnetflixDao.getFavoriteMovies()

    fun setMovieFavorite(movie: MovieEntity, newSate: Boolean) {
        movie.isFavorite = newSate
        mWarnetflixDao.updateMovie(movie)
    }

    fun getFavTvShows(): DataSource.Factory<Int, TvShowEntity> = mWarnetflixDao.getFavoriteTvShows()

    fun setTvShowFavorite(tvShow: TvShowEntity, newSate: Boolean) {
        tvShow.isFavorite = newSate
        mWarnetflixDao.updateTvShow(tvShow)
    }
}