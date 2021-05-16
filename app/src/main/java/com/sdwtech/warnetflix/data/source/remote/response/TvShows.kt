package com.sdwtech.warnetflix.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShows(
        @SerializedName("results")
        val results: List<TvResponse>
)
