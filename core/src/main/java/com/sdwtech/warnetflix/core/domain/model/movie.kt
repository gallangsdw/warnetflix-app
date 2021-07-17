package com.sdwtech.warnetflix.core.domain.model

data class Movie(
        val id: Int = 0,
        val backdropPath: String? = null,
        val overview: String? = null,
        val originalTitle: String? = null,
        val releaseDate: String? = null,
        val voteAverage: String? = null,
        val title: String? = null,
        val posterPath: String? = null,
        val isFavorite: Boolean = false
)