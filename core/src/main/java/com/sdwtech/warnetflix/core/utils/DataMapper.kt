package com.sdwtech.warnetflix.core.utils

import com.sdwtech.warnetflix.core.data.source.remote.response.movie.MovieResponse
import com.sdwtech.warnetflix.core.data.source.remote.response.tvShow.TvResponse
import com.sdwtech.warnetflix.core.domain.model.Movie
import com.sdwtech.warnetflix.core.domain.model.TvShow

object DataMapper {

    //response to entities
    fun mapMovieResponsesToEntities(input: List<MovieResponse>): List<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity> {
        val moviesList = ArrayList<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity>()
        input.map {
            val movie = com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity(
                id = it.id,
                backdropPath = it.backdropPath,
                overview = it.overview,
                originalTitle = it.originalTitle,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage.toString(),
                title = it.title,
                posterPath = it.posterPath,
                isFavorite = false
            )
            moviesList.add(movie)
        }
        return moviesList
    }

    fun mapTvShowResponsesToEntities(input: List<TvResponse>): List<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity> {
        val tvShowList = ArrayList<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity>()
        input.map {
            val tvShow = com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity(
                id = it.id,
                backdropPath = it.backdropPath,
                firstAirDate = it.firstAirDate,
                overview = it.overview,
                originalName = it.originalName,
                voteAverage = it.voteAverage.toString(),
                name = it.name,
                posterPath = it.posterPath,
                isFavorite = false
            )
            tvShowList.add(tvShow)
        }
        return tvShowList
    }

    //entities to domain
    fun mapMovieEntitiesToDomain(input: List<com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity>): List<Movie> =
        input.map {
            Movie(
                    id = it.id,
                    backdropPath = it.backdropPath,
                    overview = it.overview,
                    originalTitle = it.originalTitle,
                    releaseDate = it.releaseDate,
                    voteAverage = it.voteAverage.toString(),
                    title = it.title,
                    posterPath = it.posterPath,
                    isFavorite = it.isFavorite
            )
        }

    fun mapTvShowEntitiesToDomain(input: List<com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity>): List<TvShow> =
            input.map {
                TvShow(
                        id = it.id,
                        backdropPath = it.backdropPath,
                        firstAirDate = it.firstAirDate,
                        overview = it.overview,
                        originalName = it.originalName,
                        voteAverage = it.voteAverage.toString(),
                        name = it.name,
                        posterPath = it.posterPath,
                        isFavorite = false
                )
            }

    fun mapMovieEntitiesToDetailDomain(input: com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity): Movie =
            Movie(
                    id = input.id,
                    backdropPath = input.backdropPath,
                    overview = input.overview,
                    originalTitle = input.originalTitle,
                    releaseDate = input.releaseDate,
                    voteAverage = input.voteAverage,
                    title = input.title,
                    posterPath = input.posterPath,
                    isFavorite = input.isFavorite
            )

    fun mapTvShowEntitiesToDetailDomain(input: com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity): TvShow =
            TvShow(
                    id = input.id,
                    backdropPath = input.backdropPath,
                    overview = input.overview,
                    originalName = input.originalName,
                    firstAirDate = input.firstAirDate,
                    voteAverage = input.voteAverage,
                    name = input.name,
                    posterPath = input.posterPath,
                    isFavorite = input.isFavorite
            )

    //domain to entity
    fun mapDomainToMovieEntity(input: Movie) =
        com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity(
            id = input.id,
            backdropPath = input.backdropPath,
            overview = input.overview,
            originalTitle = input.originalTitle,
            releaseDate = input.releaseDate,
            voteAverage = input.voteAverage,
            title = input.title,
            posterPath = input.posterPath,
            isFavorite = input.isFavorite
        )

    fun mapDomainToTvShowEntity(input: TvShow) =
        com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity(
            id = input.id,
            backdropPath = input.backdropPath,
            overview = input.overview,
            originalName = input.originalName,
            firstAirDate = input.firstAirDate,
            voteAverage = input.voteAverage,
            name = input.name,
            posterPath = input.posterPath,
            isFavorite = input.isFavorite
        )
}