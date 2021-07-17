package com.sdwtech.warnetflix

import android.app.Application
import com.sdwtech.warnetflix.core.di.databaseModule
import com.sdwtech.warnetflix.core.di.networkModule
import com.sdwtech.warnetflix.core.di.repositoryModule
import com.sdwtech.warnetflix.di.useCaseModule
import com.sdwtech.warnetflix.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}