package com.sdwtech.warnetflix.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Movies(
        @SerializedName("results")
        val results: List<MovieResponse>
)