package com.sdwtech.warnetflix.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.vo.Resource

class MovieViewModel(private val warnetflixRepository: WarnetflixRepository):ViewModel() {

    fun getMovies():LiveData<Resource<PagedList<MovieEntity>>> = warnetflixRepository.getMovies()
}
