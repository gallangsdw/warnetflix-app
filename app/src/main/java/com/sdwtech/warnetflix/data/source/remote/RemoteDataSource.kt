package com.sdwtech.warnetflix.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun getMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MovieResponse>>>()

        ApiConfig.getApiService().getMovie(BuildConfig.MOVIEDB_API).enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                resultMovies.value = ApiResponse.success(response.body()?.results as List<MovieResponse>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.e("Remote Source", "getMovies onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })

        return resultMovies
    }

    fun getDetailMovie(movieId: Int): LiveData<ApiResponse<DetailMovieResponse>> {
        EspressoIdlingResource.increment()
        val resultDetailMovie = MutableLiveData<ApiResponse<DetailMovieResponse>>()

        ApiConfig.getApiService().getDetailMovie(movieId, BuildConfig.MOVIEDB_API).enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(call: Call<DetailMovieResponse>, response: Response<DetailMovieResponse>) {
                resultDetailMovie.value = ApiResponse.success(response.body() as DetailMovieResponse)
                EspressoIdlingResource.decrement()

            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.e("Remote Source", "getDetailMovie onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }

        })

        return resultDetailMovie
    }

    fun getTvShow(): LiveData<ApiResponse<List<TvResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<TvResponse>>>()

        ApiConfig.getApiService().getTvShow(BuildConfig.MOVIEDB_API).enqueue(object : Callback<TvShows> {
            override fun onResponse(call: Call<TvShows>, response: Response<TvShows>) {
                resultTvShows.value = ApiResponse.success(response.body()?.results as List<TvResponse>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShows>, t: Throwable) {
                Log.e("Remote Source", "getTvShow onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })

        return resultTvShows
    }

    fun getDetailTvShow(tvShowId: Int): LiveData<ApiResponse<DetailTvShowResponse>> {
        EspressoIdlingResource.increment()
        val resultDetailTvShow = MutableLiveData<ApiResponse<DetailTvShowResponse>>()

        ApiConfig.getApiService().getDetailTvShow(tvShowId, BuildConfig.MOVIEDB_API).enqueue(object : Callback<DetailTvShowResponse> {
            override fun onResponse(call: Call<DetailTvShowResponse>, response: Response<DetailTvShowResponse>) {
                resultDetailTvShow.value = ApiResponse.success(response.body() as DetailTvShowResponse)
                EspressoIdlingResource.decrement()

            }

            override fun onFailure(call: Call<DetailTvShowResponse>, t: Throwable) {
                Log.e("Remote Source", "getDetailTvShow onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }

        })

        return resultDetailTvShow
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