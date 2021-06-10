package com.sdwtech.warnetflix.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DetailMovieResponse(
        @field:SerializedName("backdrop_path")
        val backdropPath: String = "",

        @field:SerializedName("overview")
        val overview: String = "",

        @field:SerializedName("original_title")
        val originalTitle: String = "",

        @field:SerializedName("release_date")
        val releaseDate: String = "",

        @field:SerializedName("vote_average")
        val voteAverage: Double = 0.0,

        @field:SerializedName("id")
        val id: Int = 0,

        @field:SerializedName("title")
        val title: String = "",

        @field:SerializedName("poster_path")
        val posterPath: String = ""
)

