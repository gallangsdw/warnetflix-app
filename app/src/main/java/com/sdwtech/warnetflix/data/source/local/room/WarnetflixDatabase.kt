package com.sdwtech.warnetflix.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sdwtech.warnetflix.data.source.local.entity.MovieEntity
import com.sdwtech.warnetflix.data.source.local.entity.TvShowEntity

@Database(entities = [MovieEntity::class, TvShowEntity::class],
    version = 1,
    exportSchema = false)
abstract class WarnetflixDatabase : RoomDatabase() {

    abstract fun warnetflixDao(): WarnetflixDao

    companion object {
        @Volatile
        private var INSTANCE: WarnetflixDatabase? = null

        fun getInstance(context: Context): WarnetflixDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    WarnetflixDatabase::class.java,
                    "warnetflix.db"
                ).build()
            }
    }
}