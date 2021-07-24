package com.sdwtech.warnetflix.core.data.source.remote.response.tvShow

import com.google.gson.annotations.SerializedName

data class TvShows(
        @SerializedName("results")
        val results: List<TvResponse>
)
