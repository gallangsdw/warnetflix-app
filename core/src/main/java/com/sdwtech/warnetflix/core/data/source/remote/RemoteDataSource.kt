package com.sdwtech.warnetflix.core.data.source.remote

import android.util.Log
import com.sdwtech.warnetflix.core.BuildConfig
import com.sdwtech.warnetflix.core.data.source.remote.network.ApiResponse
import com.sdwtech.warnetflix.core.data.source.remote.network.EndPoint
import com.sdwtech.warnetflix.core.data.source.remote.response.movie.DetailMovieResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.movie.MovieResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.tvShow.DetailTvShowResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.tvShow.TvResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val endPoint: EndPoint){

    fun getMovies(): Flow<ApiResponse<List<MovieResponse>>> {
        //get data from api
        return flow {
            try {
                val response = endPoint.getMovie(BuildConfig.MOVIEDB_API)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("remote data source", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getDetailMovie(movieId: Int): Flow<ApiResponse<DetailMovieResponse>> {
        return flow {
            try {
                val response = endPoint.getDetailMovie(movieId, BuildConfig.MOVIEDB_API)
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("remote data source", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getTvShow(): Flow<ApiResponse<List<TvResponse>>> {
        return flow {
            try {
                val response = endPoint.getTvShow(BuildConfig.MOVIEDB_API)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("remote data source", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getDetailTvShow(tvShowId: Int): Flow<ApiResponse<DetailTvShowResponse>> {
        return flow {
            try {
                val response = endPoint.getDetailTvShow(tvShowId, BuildConfig.MOVIEDB_API)
                emit(ApiResponse.Success(response))
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("remote data source", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}