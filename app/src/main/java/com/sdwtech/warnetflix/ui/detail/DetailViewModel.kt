package com.sdwtech.warnetflix.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity
import com.sdwtech.warnetflix.vo.Resource

class DetailViewModel(private val warnetflixRepository: WarnetflixRepository): ViewModel() {

    companion object {
        const val MOVIE = "movie"
        const val TV_SHOW = "tv_show"
    }

    private lateinit var detailMovie: LiveData<Resource<MovieEntity>>
    private lateinit var detailTvShow: LiveData<Resource<TvShowEntity>>
    private var movieId = 0
    private var tvShowId = 0
    private var id: Int = 0

    fun setSelectedId(id: Int) {
        this.id = id
    }

    fun setType(id: Int, type: String) {
        when (type) {
            MOVIE -> {
                detailMovie = warnetflixRepository.getDetailMovie(id)
            }
            TV_SHOW -> {
                detailTvShow = warnetflixRepository.getDetailTvShow(id)
            }
        }
    }

    fun getMovieDetail(): LiveData<Resource<MovieEntity>> = warnetflixRepository.getDetailMovie(movieId)

    fun getTvShowDetail(): LiveData<Resource<TvShowEntity>> = warnetflixRepository.getDetailTvShow(tvShowId)
}
