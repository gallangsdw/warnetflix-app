package com.sdwtech.warnetflix.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.Entity
import com.sdwtech.warnetflix.data.source.remote.response.DetailMovieResponse
import com.sdwtech.warnetflix.data.source.remote.response.DetailTvShowResponse
import com.sdwtech.warnetflix.data.source.remote.response.MovieResponse
import com.sdwtech.warnetflix.data.source.remote.response.Movies
import com.sdwtech.warnetflix.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val dummyMovie = DataDummy.generateRemoteDetailMovie()
    private val dummyTvShow = DataDummy.generateRemoteDetailTvShow()
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @Mock
    private lateinit var warnetflixRepository: WarnetflixRepository

    @Mock
    private lateinit var movieObserver: Observer<DetailMovieResponse>

    @Mock
    private lateinit var tvShowObserver: Observer<DetailTvShowResponse>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(warnetflixRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<DetailMovieResponse>()
        movie.value = dummyMovie

        `when`(warnetflixRepository.getDetailMovie(movieId)).thenReturn(movie)
        val movieEntity = viewModel.getMovieDetail().value as DetailMovieResponse
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.backdropPath, movieEntity.backdropPath)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.voteAverage.toInt(), movieEntity.voteAverage.toInt())
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)

        viewModel.getMovieDetail().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<DetailTvShowResponse>()
        tvShow.value = dummyTvShow

        `when`(warnetflixRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getTvShowDetail().value as DetailTvShowResponse
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.name, tvShowEntity.name)
        assertEquals(dummyTvShow.posterPath, tvShowEntity.posterPath)
        assertEquals(dummyTvShow.backdropPath, tvShowEntity.backdropPath)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.firstAirDate, tvShowEntity.firstAirDate)
        assertEquals(dummyTvShow.voteAverage.toInt(), tvShowEntity.voteAverage.toInt())

        viewModel.getTvShowDetail().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)

    }
}