package com.sdwtech.warnetflix.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sdwtech.warnetflix.data.source.local.entity.Entity
import com.sdwtech.warnetflix.data.source.remote.RemoteDataSource
import com.sdwtech.warnetflix.data.source.remote.response.MovieResponse
import com.sdwtech.warnetflix.data.source.remote.response.TvResponse

class WarnetflixRepository private constructor(private val remoteDataSource: RemoteDataSource): WarnetflixDataSource{

   companion object {
       @Volatile
       private var instance: WarnetflixRepository? = null

       fun getInstance(remoteData: RemoteDataSource): WarnetflixRepository = instance ?: synchronized(this) {
           WarnetflixRepository(remoteData).apply { instance = this }
       }
   }
    override fun getMovies(): LiveData<List<Entity>> {
        val movieResults = MutableLiveData<List<Entity>>()
        remoteDataSource.getMovies(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movies: List<MovieResponse>) {
                val moviesList = ArrayList<Entity>()
                for (response in movies) {
                    val movie =Entity(
                            response.id,
                            response.title,
                            response.posterPath,
                            response.backdropPath,
                            response.overview,
                            response.releaseDate,
                            response.voteAverage)
                    moviesList.add(movie)
                }
                movieResults.postValue(moviesList)
            }
        })
        return movieResults
    }

    override fun getDetailMovie(movieId: String?): LiveData<Entity> {
        val movieDetailResult = MutableLiveData<Entity>()
        remoteDataSource.getDetailMovie(movieId, object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieReceived(movieResponse: MovieResponse) {
                val movie = Entity(
                        movieResponse.id,
                        movieResponse.title,
                        movieResponse.posterPath,
                        movieResponse.backdropPath,
                        movieResponse.overview,
                        movieResponse.releaseDate,
                        movieResponse.voteAverage
                )
                movieDetailResult.postValue(movie)
            }
        })
        return movieDetailResult
    }

    override fun getTvShow(): LiveData<List<Entity>> {
        val tvShowResults = MutableLiveData<List<Entity>>()
        remoteDataSource.getTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShows: List<TvResponse>) {
                val tvShowList = ArrayList<Entity>()
                    for (response in tvShows) {
                        val tvShow = Entity(
                                response.id,
                                response.name,
                                response.posterPath,
                                response.backdropPath,
                                response.overview,
                                response.firstAirDate,
                                response.voteAverage)
                        tvShowList.add(tvShow)
                    }
                tvShowResults.postValue(tvShowList)
            }
        })
        return tvShowResults
    }

    override fun getDetailTvShow(tvShowId: String?): LiveData<Entity> {
        val tvShowDetailResult = MutableLiveData<Entity>()
        remoteDataSource.getDetailTvShow(tvShowId, object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onDetailTvShowReceived(tvResponse: TvResponse) {
                val tvShow = Entity(
                        tvResponse.id,
                        tvResponse.name,
                        tvResponse.posterPath,
                        tvResponse.backdropPath,
                        tvResponse.overview,
                        tvResponse.firstAirDate,
                        tvResponse.voteAverage
                )
                tvShowDetailResult.postValue(tvShow)
            }
        })
        return tvShowDetailResult
    }

}