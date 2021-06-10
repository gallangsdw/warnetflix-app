package com.sdwtech.warnetflix.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity
import com.sdwtech.warnetflix.vo.Resource

class TvShowViewModel(private val warnetflixRepository: WarnetflixRepository): ViewModel() {

    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = warnetflixRepository.getTvShow()

}