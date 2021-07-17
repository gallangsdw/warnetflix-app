package com.sdwtech.warnetflix.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sdwtech.warnetflix.core.domain.usecase.WarnetflixUseCase

class MovieViewModel(private val warnetflixUseCase: WarnetflixUseCase):ViewModel() {

    fun getMovies() = warnetflixUseCase.getAllMovies().asLiveData()

}
