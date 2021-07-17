package com.sdwtech.warnetflix.core.domain.model

import androidx.room.ColumnInfo

data class TvShow(
        val id: Int = 0,
        val backdropPath: String? = null,
        val firstAirDate: String? = null,
        val overview: String? = null,
        val originalName: String? = null,
        val voteAverage: String? = null,
        val name: String? = null,
        val posterPath: String? = null,
        val isFavorite: Boolean = false
)