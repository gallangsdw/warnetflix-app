package com.sdwtech.warnetflix.data.source.remote

import android.util.Log
import com.sdwtech.warnetflix.BuildConfig
import com.sdwtech.warnetflix.data.source.remote.response.MovieResponse
import com.sdwtech.warnetflix.data.source.remote.response.Movies
import com.sdwtech.warnetflix.data.source.remote.response.TvResponse
import com.sdwtech.warnetflix.data.source.remote.response.TvShows
import com.sdwtech.warnetflix.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource()
        }
    }

    fun getMovies(callback: LoadMovieCallback) {
        ApiConfig.getApiService().getMovie(BuildConfig.MOVIEDB_API).enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                response.body()?.let { callback.onAllMovieReceived(it.results) }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.e("Remote Source", "getMovies onFailure: ${t.message}")
            }
        })
    }

    fun getDetailMovie(movieId: String?, callback: LoadDetailMovieCallback) {
        ApiConfig.getApiService().getDetailMovie(movieId, BuildConfig.MOVIEDB_API).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                response.body()?.let { callback.onDetailMovieReceived(it) }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("Remote Source", "getDetailMovie onFailure: ${t.message}")
            }

        })
    }

    fun getTvShow(callback: LoadTvShowCallback) {
        ApiConfig.getApiService().getTvShow(BuildConfig.MOVIEDB_API).enqueue(object : Callback<TvShows> {
            override fun onResponse(call: Call<TvShows>, response: Response<TvShows>) {
                response.body()?.let { callback.onAllTvShowReceived(it.results) }
            }

            override fun onFailure(call: Call<TvShows>, t: Throwable) {
                Log.e("Remote Source", "getTvShow onFailure: ${t.message}")
            }

        })
    }

    fun getDetailTvShow(tvShowId: String?, callback: LoadDetailTvShowCallback) {
        ApiConfig.getApiService().getDetailTvShow(tvShowId, BuildConfig.MOVIEDB_API).enqueue(object : Callback<TvResponse> {
            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                response.body()?.let { callback.onDetailTvShowReceived(it) }
            }

            override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                Log.e("Remote Source", "getDetailTvShow onFailure: ${t.message}")
            }

        })
    }

    interface LoadDetailTvShowCallback {
        fun onDetailTvShowReceived(tvResponse: TvResponse)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvShows: List<TvResponse>)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(movieResponse: MovieResponse)
    }

    interface LoadMovieCallback {
        fun onAllMovieReceived(movies: List<MovieResponse>)
    }
}