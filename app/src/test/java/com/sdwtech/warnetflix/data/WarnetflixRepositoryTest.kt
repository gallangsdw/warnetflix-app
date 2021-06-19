package com.sdwtech.warnetflix.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.sdwtech.warnetflix.data.source.remote.RemoteDataSource
import com.sdwtech.warnetflix.utils.DataDummy
import com.sdwtech.warnetflix.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.doAnswer
import com.sdwtech.warnetflix.data.source.local.LocalDataSource
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity
import com.sdwtech.warnetflix.utils.AppExecutors
import com.sdwtech.warnetflix.utils.PagedListUtil
import com.sdwtech.warnetflix.vo.Resource

class WarnetflixRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val warnetflixRepository = FakeWarnetflixRepository(remote, local, appExecutors)

    private val moviesResponses = DataDummy.generateRemoteMovie()
    private val tvShowResponses = DataDummy.generateRemoteTvShow()

    private val movieId = moviesResponses.results[0].id
    private val tvShowId = tvShowResponses.results[0].id

    private val detailMovie = DataDummy.generateRemoteDetailMovie()
    private val detailTvShow = DataDummy.generateRemoteDetailTvShow()

    @Test
    fun getMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        warnetflixRepository.getMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(moviesResponses.results.size, movieEntities.data?.size)
    }
    @Test
    fun getDetailMovie() {
        val dataMovie = MutableLiveData<MovieEntity>()
        dataMovie.value = DataDummy.generateDetailMovie()
        `when`(local.getMovieById(movieId)).thenReturn(dataMovie)

        val movieEntities = LiveDataTestUtil.getValue(warnetflixRepository.getDetailMovie(movieId))
        verify(local).getMovieById(movieId)
        assertNotNull(movieEntities.data)
        assertEquals(detailMovie.id, movieEntities.data?.id)
    }

    @Test
    fun getTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShows()).thenReturn(dataSourceFactory)
        warnetflixRepository.getTvShow()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponses.results.size, tvShowEntities.data?.size)
    }

    @Test
    fun getDetailTvShow() {
        val dataTvShow = MutableLiveData<TvShowEntity>()
        dataTvShow.value = DataDummy.generateDetailTvShow()
        `when`(local.getTvShowId(tvShowId)).thenReturn(dataTvShow)

        val tvShowEntities = LiveDataTestUtil.getValue(warnetflixRepository.getDetailTvShow(tvShowId))
        verify(local).getTvShowId(tvShowId)
        assertNotNull(tvShowEntities.data)
        assertEquals(detailTvShow.id, tvShowEntities.data?.id)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavMovies()).thenReturn(dataSourceFactory)
        warnetflixRepository.getFavoriteMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getFavMovies()
        assertNotNull(movieEntities)
        assertEquals(moviesResponses.results.size, movieEntities.data?.size)
    }

    @Test
    fun getFavoriteTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavTvShows()).thenReturn(dataSourceFactory)
        warnetflixRepository.getFavoriteTvShow()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getFavTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(moviesResponses.results.size, tvShowEntities.data?.size)
    }

    @Test
    fun setFavoriteMovie() {
        warnetflixRepository.setFavoriteMovie(DataDummy.generateDetailMovie(), true)
        verify(local).setMovieFavorite(DataDummy.generateDetailMovie(), true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun setFavoriteTvShow() {
        warnetflixRepository.setFavoriteTvShow(DataDummy.generateDetailTvShow(), true)
        verify(local).setTvShowFavorite(DataDummy.generateDetailTvShow(), true)
        verifyNoMoreInteractions(local)
    }
}