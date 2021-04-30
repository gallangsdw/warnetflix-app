package com.sdwtech.warnetflix.ui.movie

import androidx.lifecycle.ViewModel
import com.sdwtech.warnetflix.data.Entity
import com.sdwtech.warnetflix.utils.DataDummy

class MovieViewModel:ViewModel() {

    fun getMovies():List<Entity> =DataDummy.generateDummyMovie()
}