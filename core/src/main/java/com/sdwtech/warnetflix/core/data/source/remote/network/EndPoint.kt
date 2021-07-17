package com.sdwtech.warnetflix.core.data.source.remote.network

import com.sdwtech.warnetflix.core.BuildConfig
import com.sdwtech.warnetflix.core.data.source.remote.response.movie.DetailMovieResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.tvShow.DetailTvShowResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.movie.Movies
import com.sdwtech.warnetflix.core.data.source.remote.response.tvShow.TvShows
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPoint {

    @GET("movie/popular")
    suspend fun getMovie(@Query("api_key")
                 apiKey: String = BuildConfig.MOVIEDB_API): Movies

    @GET("movie/{movie_id}")
    suspend fun getDetailMovie(@Path("movie_id") MovieId: Int,
                       @Query("api_key") apiKey: String = BuildConfig.MOVIEDB_API): DetailMovieResponse

    @GET("tv/popular")
    suspend fun getTvShow(@Query("api_key")
                  apiKey: String = BuildConfig.MOVIEDB_API): TvShows

    @GET("tv/{tv_id}")
    suspend fun getDetailTvShow(@Path("tv_id") tvId: Int,
                        @Query("api_key") apiKey: String = BuildConfig.MOVIEDB_API): DetailTvShowResponse
}