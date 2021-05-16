package com.sdwtech.warnetflix.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sdwtech.warnetflix.data.WarnetflixRepository
import com.sdwtech.warnetflix.di.Injection
import com.sdwtech.warnetflix.ui.detail.DetailViewModel
import com.sdwtech.warnetflix.ui.movie.MovieViewModel
import com.sdwtech.warnetflix.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mWarnetflixRepository: WarnetflixRepository) : ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    ViewModelFactory(Injection.provideRepository(context)).apply { instance = this }
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mWarnetflixRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mWarnetflixRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mWarnetflixRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: "+ modelClass.name)
        }
    }
}