package com.sdwtech.warnetflix.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity
import com.sdwtech.warnetflix.data.source.remote.response.DetailTvShowResponse
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.MOVIE
import com.sdwtech.warnetflix.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.sdwtech.warnetflix.utils.DataDummy
import com.sdwtech.warnetflix.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @Mock
    private lateinit var warnetflixRepository: WarnetflixRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(warnetflixRepository)
    }

    @Test
    fun getDetailMovie() {
        val detailMovie = Resource.success(DataDummy.generateDetailMovie())
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = detailMovie
        `when`(warnetflixRepository.getDetailMovie(movieId)).thenReturn(movie)

        viewModel.setType(movieId, MOVIE)
        viewModel.getMovieDetail().observeForever(movieObserver)
        verify(movieObserver).onChanged(detailMovie)
    }

    @Test
    fun setFavoriteMovie() {
        val detailMovie = Resource.success(DataDummy.generateDetailMovie())
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = detailMovie
        `when`(warnetflixRepository.getDetailMovie(movieId)).thenReturn(movie)

        viewModel.setType(movieId, MOVIE)
        viewModel.setFavoriteMovie()
        verify(warnetflixRepository).setFavoriteMovie(movie.value!!.data as MovieEntity, true)
        verifyNoMoreInteractions(movieObserver)
    }

    @Test
    fun getDetailTvShow() {
        val detailTvShow = Resource.success(DataDummy.generateDetailTvShow())
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = detailTvShow
        `when`(warnetflixRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow)

        viewModel.setType(tvShowId, TV_SHOW)
        viewModel.getTvShowDetail().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(detailTvShow)
    }

    @Test
    fun setFavoriteTvShow() {
        val detailTvShow = Resource.success(DataDummy.generateDetailTvShow())
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = detailTvShow
        `when`(warnetflixRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow)

        viewModel.setType(tvShowId, TV_SHOW)
        viewModel.setFavoriteTvShow()
        verify(warnetflixRepository).setFavoriteTvShow(tvShow.value!!.data as TvShowEntity, true)
        verifyNoMoreInteractions(tvShowObserver)
    }
}