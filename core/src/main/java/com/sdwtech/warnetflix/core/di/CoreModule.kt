package com.sdwtech.warnetflix.core.di

import androidx.room.Room
import com.sdwtech.warnetflix.core.data.source.remote.network.EndPoint
import com.sdwtech.warnetflix.core.domain.repository.IWarnetflixRepository
import com.sdwtech.warnetflix.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<com.sdwtech.warnetflix.core.data.source.local.room.WarnetflixDatabase>().warnetflixDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("sdwtech".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            com.sdwtech.warnetflix.core.data.source.local.room.WarnetflixDatabase::class.java, "Warnetfilx.db"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(EndPoint::class.java)
    }
}

val repositoryModule = module {
    single { com.sdwtech.warnetflix.core.data.source.local.LocalDataSource(get()) }
    single { com.sdwtech.warnetflix.core.data.source.remote.RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IWarnetflixRepository> {
        com.sdwtech.warnetflix.core.data.WarnetflixRepository(
            get(),
            get(),
            get()
        )
    }
}