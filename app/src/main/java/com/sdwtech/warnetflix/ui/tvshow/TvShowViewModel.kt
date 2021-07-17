package com.sdwtech.warnetflix.ui.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sdwtech.warnetflix.core.domain.usecase.WarnetflixUseCase

class TvShowViewModel(private val warnetflixUseCase: WarnetflixUseCase): ViewModel() {

    fun getTvShows() = warnetflixUseCase.getAllTvShows().asLiveData()

}