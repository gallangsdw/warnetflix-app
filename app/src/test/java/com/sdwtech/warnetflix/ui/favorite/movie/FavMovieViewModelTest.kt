package com.sdwtech.warnetflix.ui.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavMovieViewModelTest {

    private lateinit var viewModel: FavMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var warnetflixRepository: WarnetflixRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavMovieViewModel(warnetflixRepository)
    }

    @Test
    fun getFavoriteMovie() {
        val favDummyMovies = pagedList
        `when`(favDummyMovies.size).thenReturn(5)
        val favMovies = MutableLiveData<PagedList<MovieEntity>>()
        favMovies.value = favDummyMovies

        `when`(warnetflixRepository.getFavoriteMovie()).thenReturn(favMovies)
        val favMovieEntities = viewModel.getFavoriteMovie().value
        verify(warnetflixRepository).getFavoriteMovie()
        assertNotNull(favMovieEntities)
        assertEquals(5, favMovieEntities?.size)

        viewModel.getFavoriteMovie().observeForever(observer)
        verify(observer).onChanged(favDummyMovies)
    }
}