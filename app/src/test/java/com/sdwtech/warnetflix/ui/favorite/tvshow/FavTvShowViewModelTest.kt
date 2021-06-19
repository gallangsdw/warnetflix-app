package com.sdwtech.warnetflix.ui.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity
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
class FavTvShowViewModelTest {

    private lateinit var viewModel: FavTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var warnetflixRepository: WarnetflixRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavTvShowViewModel(warnetflixRepository)
    }

    @Test
    fun getFavoriteTvShow() {
        val favDummyTvShows = pagedList
        `when`(favDummyTvShows.size).thenReturn(5)
        val favTvShows = MutableLiveData<PagedList<TvShowEntity>>()
        favTvShows.value = favDummyTvShows

        `when`(warnetflixRepository.getFavoriteTvShow()).thenReturn(favTvShows)
        val favTvShowEntities = viewModel.getFavoriteTvShow().value
        verify(warnetflixRepository).getFavoriteTvShow()
        assertNotNull(favTvShowEntities)
        assertEquals(5,favTvShowEntities?.size)

        viewModel.getFavoriteTvShow().observeForever(observer)
        verify(observer).onChanged(favDummyTvShows)
    }
}