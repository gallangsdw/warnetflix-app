package com.sdwtech.warnetflix.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity

class FavTvShowViewModel(private val warnetflixRepository: WarnetflixRepository) : ViewModel() {

    fun getFavoriteTvShow() : LiveData<PagedList<TvShowEntity>> = warnetflixRepository.getFavoriteTvShow()
}