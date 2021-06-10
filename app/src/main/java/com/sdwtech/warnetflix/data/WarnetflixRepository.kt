package com.sdwtech.warnetflix.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sdwtech.warnetflix.data.source.local.LocalDataSource
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity
import com.sdwtech.warnetflix.data.source.remote.ApiResponse
import com.sdwtech.warnetflix.data.source.remote.RemoteDataSource
import com.sdwtech.warnetflix.data.source.remote.response.DetailMovieResponse
import com.sdwtech.warnetflix.data.source.remote.response.DetailTvShowResponse
import com.sdwtech.warnetflix.data.source.remote.response.MovieResponse
import com.sdwtech.warnetflix.data.source.remote.response.TvResponse
import com.sdwtech.warnetflix.utils.AppExecutors
import com.sdwtech.warnetflix.vo.Resource

class WarnetflixRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors): WarnetflixDataSource{

    companion object {
        @Volatile
        private var instance: WarnetflixRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): WarnetflixRepository =
            instance ?: synchronized(this) {
            WarnetflixRepository(remoteData, localData, appExecutors).apply { instance = this }
        }
    }
    override fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                    data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                    remoteDataSource.getMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                            response.id,
                            response.backdropPath,
                            response.overview,
                            response.originalTitle,
                            response.releaseDate,
                            response.voteAverage.toString(),
                            response.title,
                            response.posterPath,
                            isFavorite = false)
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, DetailMovieResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getMovieById(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                    data == null

            override fun createCall(): LiveData<ApiResponse<DetailMovieResponse>> =
                    remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(detailMovieResponses: DetailMovieResponse) {
                val movie = MovieEntity(
                        detailMovieResponses.id,
                        detailMovieResponses.backdropPath,
                        detailMovieResponses.overview,
                        detailMovieResponses.originalTitle,
                        detailMovieResponses.releaseDate,
                        detailMovieResponses.voteAverage.toString(),
                        detailMovieResponses.title,
                        detailMovieResponses.posterPath)
                localDataSource.updateMovie(movie)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavMovies(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, isFavorite: Boolean) =
        appExecutors.diskIO().execute {localDataSource.setMovieFavorite(movie,isFavorite)}

    override fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<TvResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                remoteDataSource.getTvShow()

            override fun saveCallResult(data: List<TvResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(
                            response.id,
                            response.backdropPath,
                            response.firstAirDate,
                            response.overview,
                            response.originalName,
                            response.voteAverage.toString(),
                            response.name,
                            response.posterPath,
                            isFavorite = false)
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, DetailTvShowResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getTvShowId(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<DetailTvShowResponse>> =
                remoteDataSource.getDetailTvShow(tvShowId)

            override fun saveCallResult(detailTvShowResponses: DetailTvShowResponse) {
                val tvShow = TvShowEntity(
                        detailTvShowResponses.id,
                        detailTvShowResponses.backdropPath,
                        detailTvShowResponses.firstAirDate,
                        detailTvShowResponses.overview,
                        detailTvShowResponses.originalName,
                        detailTvShowResponses.voteAverage.toString(),
                        detailTvShowResponses.name,
                        detailTvShowResponses.posterPath)
                localDataSource.updateTvShow(tvShow)
            }
        }.asLiveData()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavTvShows(), config).build()
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity, isFavorite: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvShow,isFavorite) }

}