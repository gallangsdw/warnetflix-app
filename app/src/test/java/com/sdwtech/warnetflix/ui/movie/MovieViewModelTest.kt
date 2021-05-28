package com.sdwtech.warnetflix.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.remote.response.Movies
import com.sdwtech.warnetflix.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var warnetflixRepository: WarnetflixRepository

    @Mock
    private lateinit var observer: Observer<Movies>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(warnetflixRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDummyMovie()
        val movies = MutableLiveData<Movies>()
        movies.value = dummyMovies

        `when`(warnetflixRepository.getMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMovies().value
        verify(warnetflixRepository).getMovies()
        assertNotNull(movieEntities)
        if (movieEntities != null) assertEquals(3,movieEntities.results.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}