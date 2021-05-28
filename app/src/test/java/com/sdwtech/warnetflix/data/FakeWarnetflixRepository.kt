package com.sdwtech.warnetflix.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sdwtech.warnetflix.data.source.remote.RemoteDataSource
import com.sdwtech.warnetflix.data.source.remote.response.DetailMovieResponse
import com.sdwtech.warnetflix.data.source.remote.response.DetailTvShowResponse
import com.sdwtech.warnetflix.data.source.remote.response.Movies
import com.sdwtech.warnetflix.data.source.remote.response.TvShows

class FakeWarnetflixRepository (private val remoteDataSource: RemoteDataSource): WarnetflixDataSource{

    override fun getMovies(): LiveData<Movies> {
        val movieResults = MutableLiveData<Movies>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movies: Movies) {
                movieResults.postValue(movies)
            }
        })
        return movieResults
    }

    override fun getDetailMovie(movieId: Int): LiveData<DetailMovieResponse> {
        val movieDetailResult = MutableLiveData<DetailMovieResponse>()
        remoteDataSource.getDetailMovie(movieId, object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieReceived(movieResponse: DetailMovieResponse) {
                movieDetailResult.postValue(movieResponse)
            }
        })
        return movieDetailResult
    }

    override fun getTvShow(): LiveData<TvShows> {
        val tvShowResults = MutableLiveData<TvShows>()
        remoteDataSource.getTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShows: TvShows) {
                tvShowResults.postValue(tvShows)
            }
        })
        return tvShowResults
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<DetailTvShowResponse> {
        val tvShowDetailResult = MutableLiveData<DetailTvShowResponse>()
        remoteDataSource.getDetailTvShow(tvShowId, object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onDetailTvShowReceived(tvResponse: DetailTvShowResponse) {
                tvShowDetailResult.postValue(tvResponse)
            }
        })
        return tvShowDetailResult
    }

}