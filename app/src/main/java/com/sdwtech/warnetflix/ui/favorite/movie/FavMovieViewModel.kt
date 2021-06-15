package com.sdwtech.warnetflix.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity

class FavMovieViewModel(private val warnetflixRepository: WarnetflixRepository) : ViewModel() {

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> = warnetflixRepository.getFavoriteMovie()
}