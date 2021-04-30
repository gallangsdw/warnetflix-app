package com.sdwtech.warnetflix.ui.detail

import com.sdwtech.warnetflix.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val movieId = dummyMovie.Id
    private val tvShowId = dummyTvShow.Id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getMovie() {
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.Id, movieEntity.Id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.imgPhoto, movieEntity.imgPhoto)
        assertEquals(dummyMovie.imgTrailer, movieEntity.imgTrailer)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.rating, movieEntity.rating)
        assertEquals(dummyMovie.showDate, movieEntity.showDate)
    }

    @Test
    fun getTvShow() {
        val tvShowEntity = viewModel.getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.Id, tvShowEntity.Id)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.imgPhoto, tvShowEntity.imgPhoto)
        assertEquals(dummyTvShow.imgTrailer, tvShowEntity.imgTrailer)
        assertEquals(dummyTvShow.description, tvShowEntity.description)
        assertEquals(dummyTvShow.showDate, tvShowEntity.showDate)
        assertEquals(dummyTvShow.rating, tvShowEntity.rating)

    }
}