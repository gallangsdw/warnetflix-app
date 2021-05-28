package com.sdwtech.warnetflix.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.Entity
import com.sdwtech.warnetflix.data.source.remote.response.Movies

class MovieViewModel(private val warnetflixRepository: WarnetflixRepository):ViewModel() {

    fun getMovies():LiveData<Movies> = warnetflixRepository.getMovies()
}
