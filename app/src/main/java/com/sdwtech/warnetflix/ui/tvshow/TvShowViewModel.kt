package com.sdwtech.warnetflix.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.remote.response.TvShows

class TvShowViewModel(private val warnetflixRepository: WarnetflixRepository): ViewModel() {

    fun getTvShows(): LiveData<TvShows> = warnetflixRepository.getTvShow()

}