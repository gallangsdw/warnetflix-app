package com.sdwtech.warnetflix.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvResponse(

	@field:SerializedName("backdrop_path")
	val backdropPath: String,

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("original_name")
	val originalName: String,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("poster_path")
	val posterPath: String
)
