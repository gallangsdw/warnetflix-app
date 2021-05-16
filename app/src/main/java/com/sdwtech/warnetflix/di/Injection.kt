package com.sdwtech.warnetflix.di

import android.content.Context
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): WarnetflixRepository{

        val remoteRepository = RemoteDataSource.getInstance()

        return WarnetflixRepository.getInstance(remoteRepository)
    }
}