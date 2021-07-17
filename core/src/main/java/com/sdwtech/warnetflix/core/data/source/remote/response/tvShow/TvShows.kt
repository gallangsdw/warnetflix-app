package com.sdwtech.warnetflix.core.data.source.remote.response.tvShow

import com.google.gson.annotations.SerializedName
import com.sdwtech.warnetflix.core.data.source.remote.response.tvShow.TvResponse

data class TvShows(
        @SerializedName("results")
        val results: List<TvResponse>
)
