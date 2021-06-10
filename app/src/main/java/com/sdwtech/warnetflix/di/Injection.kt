package com.sdwtech.warnetflix.di

import android.content.Context
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.local.LocalDataSource
import com.sdwtech.warnetflix.data.source.local.room.WarnetflixDatabase
import com.sdwtech.warnetflix.data.source.remote.RemoteDataSource
import com.sdwtech.warnetflix.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): WarnetflixRepository{

        val database = WarnetflixDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.warnetflixDao())
        val appExecutors = AppExecutors()

        return WarnetflixRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}