package com.sdwtech.warnetflix.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Entity(
        var Id: String,
        var title: String,
        var imgPhoto: String,
        var imgTrailer: String,
        var description: String,
        var showDate: String,
        var rating: String
): Parcelable