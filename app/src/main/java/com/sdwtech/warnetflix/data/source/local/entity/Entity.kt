package com.sdwtech.warnetflix.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Entity(
        var Id: Int,
        var title: String,
        var imgPhoto: String,
        var imgTrailer: String,
        var description: String,
        var showDate: String,
        var rating: Double
): Parcelable