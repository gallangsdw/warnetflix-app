package com.sdwtech.warnetflix.network

import com.sdwtech.warnetflix.BuildConfig
import com.sdwtech.warnetflix.data.source.remote.response.MovieResponse
import com.sdwtech.warnetflix.data.source.remote.response.Movies
import com.sdwtech.warnetflix.data.source.remote.response.TvResponse
import com.sdwtech.warnetflix.data.source.remote.response.TvShows
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPoint {

    @GET("movie/popular")
    fun getMovie(@Query("api_key")
                 apiKey: String = BuildConfig.MOVIEDB_API): Call<Movies>

    @GET("movie/{movie_id}")
    fun getDetailMovie(@Path("Movie_id") MovieId: String?,
                       @Query("api_key") apiKey: String = BuildConfig.MOVIEDB_API): Call<MovieResponse>

    @GET("tv/popular")
    fun getTvShow(@Query("api_key")
                  apiKey: String = BuildConfig.MOVIEDB_API): Call<TvShows>

    @GET("tv/{tv_id}")
    fun getDetailTvShow(@Path("tv_id") tvId: String?,
                        @Query("api_key") apiKey: String = BuildConfig.MOVIEDB_API): Call<TvResponse>
}