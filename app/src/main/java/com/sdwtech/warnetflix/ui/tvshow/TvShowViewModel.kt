package com.sdwtech.warnetflix.ui.tvshow

import androidx.lifecycle.ViewModel
import com.sdwtech.warnetflix.data.Entity
import com.sdwtech.warnetflix.utils.DataDummy

class TvShowViewModel: ViewModel() {

    fun getTvShows(): List<Entity> = DataDummy.generateDummyTvShow()

}