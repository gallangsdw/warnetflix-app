package com.sdwtech.warnetflix.favorite.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sdwtech.warnetflix.core.domain.usecase.WarnetflixUseCase

class FavMovieViewModel(private val warnetflixUseCase: WarnetflixUseCase) : ViewModel() {

    fun getFavoriteMovie() = warnetflixUseCase.getFavoriteMovie().asLiveData()
}