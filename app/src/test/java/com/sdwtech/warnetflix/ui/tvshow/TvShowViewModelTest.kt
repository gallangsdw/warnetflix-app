package com.sdwtech.warnetflix.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.remote.response.TvShows
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
class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var warnetflixRepository: WarnetflixRepository

    @Mock
    private lateinit var observer: Observer<TvShows>

    @Before
    fun setUp(){
        viewModel = TvShowViewModel(warnetflixRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShows = DataDummy.generateDummyTvShow()
        val tvShows = MutableLiveData<TvShows>()
        tvShows.value = dummyTvShows

        `when`(warnetflixRepository.getTvShow()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTvShows().value
        verify(warnetflixRepository).getTvShow()
        assertNotNull(tvShowEntities)
        if (tvShowEntities != null) assertEquals(3, tvShowEntities.results.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}