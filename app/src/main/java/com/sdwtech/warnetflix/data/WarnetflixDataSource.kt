package com.sdwtech.warnetflix.data

import androidx.lifecycle.LiveData
import com.sdwtech.warnetflix.data.source.local.entity.Entity

interface WarnetflixDataSource {
    fun getMovies(): LiveData<List<Entity>>

    fun getDetailMovie(movieId: String?): LiveData<Entity>

    fun getTvShow(): LiveData<List<Entity>>

    fun getDetailTvShow(tvShowId: String?): LiveData<Entity>
}