package com.sdwtech.warnetflix.favorite.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sdwtech.warnetflix.core.domain.usecase.WarnetflixUseCase

class FavTvShowViewModel(private val warnetflixUseCase: WarnetflixUseCase) : ViewModel() {

    fun getFavoriteTvShow() = warnetflixUseCase.getFavoriteTvShow().asLiveData()
}