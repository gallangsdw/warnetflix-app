package com.sdwtech.warnetflix.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: Int = 0,

        @ColumnInfo(name = "backdrop_path")
        var backdropPath: String? = null,

        @ColumnInfo(name = "overview")
        var overview: String? = null,

        @ColumnInfo(name = "original_title")
        var originalTitle: String? = null,

        @ColumnInfo(name = "release_date")
        var releaseDate: String? = null,

        @ColumnInfo(name = "vote_average")
        var voteAverage: String? = null,

        @ColumnInfo(name = "title")
        var title: String? = null,

        @ColumnInfo(name = "poster_path")
        var posterPath: String? = null,

        @ColumnInfo(name = "isFavorite")
        var isFavorite: Boolean = false
)