package com.sdwtech.warnetflix.core.data

import com.sdwtech.warnetflix.core.data.source.remote.network.ApiResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.movie.DetailMovieResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.movie.MovieResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.tvShow.DetailTvShowResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.tvShow.TvResponse
import com.sdwtech.warnetflix.core.domain.model.Movie
import com.sdwtech.warnetflix.core.domain.model.TvShow
import com.sdwtech.warnetflix.core.domain.repository.IWarnetflixRepository
import com.sdwtech.warnetflix.core.utils.AppExecutors
import com.sdwtech.warnetflix.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WarnetflixRepository(
    private val remoteDataSource: com.sdwtech.warnetflix.core.data.source.remote.RemoteDataSource,
    private val localDataSource: com.sdwtech.warnetflix.core.data.source.local.LocalDataSource,
    private val appExecutors: AppExecutors): IWarnetflixRepository {

    override fun getMovies(): Flow<com.sdwtech.warnetflix.core.data.Resource<List<Movie>>> =
            object : com.sdwtech.warnetflix.core.data.NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
                override fun loadFromDB(): Flow<List<Movie>> {
                    return localDataSource.getAllMovies().map {
                        DataMapper.mapMovieEntitiesToDomain(it)
                    }
                }

                override fun shouldFetch(data: List<Movie>?): Boolean =
                        data == null || data.isEmpty()

                override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                        remoteDataSource.getMovies()

                override suspend fun saveCallResult(data: List<MovieResponse>) {
                    val movieList = DataMapper.mapMovieResponsesToEntities(data)
                    localDataSource.insertMovies(movieList)
                }
            }.asFlow()

    override fun getDetailMovie(movieId: Int): Flow<com.sdwtech.warnetflix.core.data.Resource<Movie>> {
        return object : com.sdwtech.warnetflix.core.data.NetworkBoundResource<Movie, DetailMovieResponse>(appExecutors) {
            override fun loadFromDB(): Flow<Movie> =
                    localDataSource.getMovieById(movieId).map {
                        DataMapper.mapMovieEntitiesToDetailDomain(it)
                    }

            override fun shouldFetch(data: Movie?): Boolean =
                    data == null

            override suspend fun createCall(): Flow<ApiResponse<DetailMovieResponse>> =
                    remoteDataSource.getDetailMovie(movieId)

            override suspend fun saveCallResult(data: DetailMovieResponse) {
                val movie = com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity(
                    data.id,
                    data.backdropPath,
                    data.overview,
                    data.originalTitle,
                    data.releaseDate,
                    data.voteAverage.toString(),
                    data.title,
                    data.posterPath
                )
                localDataSource.updateMovie(movie)
            }
        }.asFlow()
    }

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavMovies().map {
            DataMapper.mapMovieEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovie(movie: Movie, isFavorite: Boolean) {
        val movieEntity = DataMapper.mapDomainToMovieEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movieEntity, isFavorite) }
    }

    override fun getTvShow(): Flow<com.sdwtech.warnetflix.core.data.Resource<List<TvShow>>> =
        object : com.sdwtech.warnetflix.core.data.NetworkBoundResource<List<TvShow>, List<TvResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<TvShow>> {
                return localDataSource.getTvShows().map {
                    DataMapper.mapTvShowEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<TvShow>?): Boolean =
                    data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TvResponse>>> =
                    remoteDataSource.getTvShow()

            override suspend fun saveCallResult(data: List<TvResponse>) {
                val tvShowList = DataMapper.mapTvShowResponsesToEntities(data)
                localDataSource.insertTvShows(tvShowList)
            }
        }.asFlow()

        override fun getDetailTvShow(tvShowId: Int): Flow<com.sdwtech.warnetflix.core.data.Resource<TvShow>> {
            return object : com.sdwtech.warnetflix.core.data.NetworkBoundResource<TvShow, DetailTvShowResponse>(appExecutors) {
                override fun loadFromDB(): Flow<TvShow> =
                        localDataSource.getTvShowId(tvShowId).map {
                            DataMapper.mapTvShowEntitiesToDetailDomain(it)
                        }

                override fun shouldFetch(data: TvShow?): Boolean =
                        data == null

                override suspend fun createCall(): Flow<ApiResponse<DetailTvShowResponse>> =
                        remoteDataSource.getDetailTvShow(tvShowId)

                override suspend fun saveCallResult(data: DetailTvShowResponse) {
                    val tvShow = com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity(
                        data.id,
                        data.backdropPath,
                        data.firstAirDate,
                        data.overview,
                        data.originalName,
                        data.voteAverage.toString(),
                        data.name,
                        data.posterPath
                    )
                    localDataSource.updateTvShow(tvShow)
                }
            }.asFlow()
        }

        override fun getFavoriteTvShow(): Flow<List<TvShow>> {
            return localDataSource.getFavTvShows().map {
                DataMapper.mapTvShowEntitiesToDomain(it)
            }
        }

        override fun setFavoriteTvShow(tvShow: TvShow, isFavorite: Boolean) {
            val tvShowEntity = DataMapper.mapDomainToTvShowEntity(tvShow)
            appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvShowEntity, isFavorite) }
        }
    }