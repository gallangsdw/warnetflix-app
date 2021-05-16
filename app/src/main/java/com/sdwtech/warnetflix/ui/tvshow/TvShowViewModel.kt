package com.sdwtech.warnetflix.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.Entity

class TvShowViewModel(private val warnetflixRepository: WarnetflixRepository): ViewModel() {

    fun getTvShows(): LiveData<List<Entity>> = warnetflixRepository.getTvShow()

}