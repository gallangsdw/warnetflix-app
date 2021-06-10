package com.sdwtech.warnetflix.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DetailTvShowResponse(
        @field:SerializedName("backdrop_path")
        val backdropPath: String = "",

        @field:SerializedName("first_air_date")
        val firstAirDate: String = "",

        @field:SerializedName("overview")
        val overview: String = "",

        @field:SerializedName("original_name")
        val originalName: String = "",

        @field:SerializedName("vote_average")
        val voteAverage: Double = 0.0,

        @field:SerializedName("name")
        val name: String = "",

        @field:SerializedName("id")
        val id: Int = 0,

        @field:SerializedName("poster_path")
        val posterPath: String = ""
)
