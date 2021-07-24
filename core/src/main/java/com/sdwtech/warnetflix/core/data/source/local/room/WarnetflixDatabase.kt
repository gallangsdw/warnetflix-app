package com.sdwtech.warnetflix.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [com.sdwtech.warnetflix.core.data.source.local.entity.MovieEntity::class, com.sdwtech.warnetflix.core.data.source.local.entity.TvShowEntity::class],
    version = 1,
    exportSchema = false)
abstract class WarnetflixDatabase : RoomDatabase() {

    abstract fun warnetflixDao(): com.sdwtech.warnetflix.core.data.source.local.room.WarnetflixDao
}