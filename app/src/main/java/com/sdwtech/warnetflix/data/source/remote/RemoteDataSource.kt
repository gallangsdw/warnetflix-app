package com.sdwtech.warnetflix.data.source.remote

import android.util.Log
import com.sdwtech.warnetflix.BuildConfig
import com.sdwtech.warnetflix.data.source.remote.response.*
import com.sdwtech.warnetflix.network.ApiConfig
import com.sdwtech.warnetflix.utils.EspressoIdlingResource
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
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMovie(BuildConfig.MOVIEDB_API).enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                response.body()?.let { callback.onAllMovieReceived(it) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.e("Remote Source", "getMovies onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getDetailMovie(movieId: Int, callback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailMovie(movieId, BuildConfig.MOVIEDB_API).enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(call: Call<DetailMovieResponse>, response: Response<DetailMovieResponse>) {
                response.body()?.let { callback.onDetailMovieReceived(it) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.e("Remote Source", "getDetailMovie onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }

        })
    }

    fun getTvShow(callback: LoadTvShowCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTvShow(BuildConfig.MOVIEDB_API).enqueue(object : Callback<TvShows> {
            override fun onResponse(call: Call<TvShows>, response: Response<TvShows>) {
                response.body()?.let { callback.onAllTvShowReceived(it) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShows>, t: Throwable) {
                Log.e("Remote Source", "getTvShow onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }

        })
    }

    fun getDetailTvShow(tvShowId: Int, callback: LoadDetailTvShowCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailTvShow(tvShowId, BuildConfig.MOVIEDB_API).enqueue(object : Callback<DetailTvShowResponse> {
            override fun onResponse(call: Call<DetailTvShowResponse>, response: Response<DetailTvShowResponse>) {
                response.body()?.let { callback.onDetailTvShowReceived(it) }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailTvShowResponse>, t: Throwable) {
                Log.e("Remote Source", "getDetailTvShow onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }

        })
    }

    interface LoadDetailTvShowCallback {
        fun onDetailTvShowReceived(tvResponse: DetailTvShowResponse)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvShows: TvShows)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(movieResponse: DetailMovieResponse)
    }

    interface LoadMovieCallback {
        fun onAllMovieReceived(movies: Movies)
    }
}