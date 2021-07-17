package com.sdwtech.warnetflix.core.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class Movies(
        @SerializedName("results")
        val results: List<MovieResponse>
)