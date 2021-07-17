package com.sdwtech.warnetflix.core.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WarnetflixDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): Flow<List<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity>>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE id = :id")
    fun getMovieById(id: Int): Flow<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity>

    @Query("SELECT * FROM tvshowentities")
    fun getTvShows(): Flow<List<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity>>

    @Transaction
    @Query("SELECT * FROM tvshowentities WHERE id = :id")
    fun getTvShowById(id: Int): Flow<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity>)

    @Update
    fun updateMovie(movie: com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity>)

    @Update
    fun updateTvShow(tvShow: com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity)

    @Query("SELECT * FROM movieentities where isFavorite = 1")
    fun getFavoriteMovies(): Flow<List<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity>>

    @Query("SELECT * FROM tvshowentities where isFavorite = 1")
    fun getFavoriteTvShows(): Flow<List<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity>>

}