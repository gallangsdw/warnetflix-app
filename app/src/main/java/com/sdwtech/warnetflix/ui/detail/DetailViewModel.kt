package com.sdwtech.warnetflix.ui.detail

import androidx.lifecycle.ViewModel
import com.sdwtech.warnetflix.data.Entity
import com.sdwtech.warnetflix.utils.DataDummy

class DetailViewModel: ViewModel() {
    private lateinit var movieId: String
    private lateinit var tvShowId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getMovie(): Entity {
        lateinit var movie: Entity
        val listMovies = DataDummy.generateDummyMovie()
        for (listMovie in listMovies) {
            if (listMovie.Id == movieId) {
                movie = listMovie
            }
        }
        return movie
    }

    fun getTvShow(): Entity {
        lateinit var tvShow: Entity
        val listTvShows = DataDummy.generateDummyTvShow()
        for (listTvShow in listTvShows) {
            if (listTvShow.Id == tvShowId) {
                tvShow = listTvShow
            }
        }
        return tvShow
    }
}