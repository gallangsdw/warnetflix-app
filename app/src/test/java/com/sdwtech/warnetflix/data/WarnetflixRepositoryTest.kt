package com.sdwtech.warnetflix.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
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

class WarnetflixRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val warnetflixRepository = FakeWarnetflixRepository(remote)

    private val moviesResponses = DataDummy.generateRemoteMovie()
    private val tvShowResponses = DataDummy.generateRemoteTvShow()

    private val movieId = moviesResponses.results[0].id
    private val tvShowId = tvShowResponses.results[0].id

    private val detailMovie = DataDummy.generateRemoteDetailMovie()
    private val detailTvShow = DataDummy.generateRemoteDetailTvShow()

    @Test
    fun getMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback).onAllMovieReceived(moviesResponses)
            null
        }.`when`(remote).getMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(warnetflixRepository.getMovies())
        verify(remote).getMovies(any())
        assertNotNull(movieEntities)
        assertEquals(moviesResponses.results.size.toLong(), movieEntities.results.size.toLong())
    }
    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback).onDetailMovieReceived(detailMovie)
            null
        }.`when`(remote).getDetailMovie(eq(movieId), any())

        val detailMovieEntities = LiveDataTestUtil.getValue(warnetflixRepository.getDetailMovie(movieId))
        verify(remote).getDetailMovie(eq(movieId), any())
        assertNotNull(detailMovieEntities)
        assertEquals(detailMovie.id,detailMovieEntities.id)
    }

    @Test
    fun getTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback).onAllTvShowReceived(tvShowResponses)
            null
        }.`when`(remote).getTvShow(any())

        val tvShowEntities = LiveDataTestUtil.getValue(warnetflixRepository.getTvShow())
        verify(remote).getTvShow(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponses.results.size.toLong(), tvShowEntities.results.size.toLong())
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvShowCallback).onDetailTvShowReceived(detailTvShow)
            null
        }.`when`(remote).getDetailTvShow(eq(tvShowId), any())

        val detailTvShowEntities = LiveDataTestUtil.getValue(warnetflixRepository.getDetailTvShow(tvShowId))
        verify(remote).getDetailTvShow(eq(tvShowId), any())
        assertNotNull(detailTvShowEntities)
        assertEquals(detailTvShow.id,detailTvShowEntities.id)
    }
}