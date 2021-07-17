package com.sdwtech.warnetflix.di

import com.sdwtech.warnetflix.core.domain.usecase.WarnetflixInteractor
import com.sdwtech.warnetflix.core.domain.usecase.WarnetflixUseCase
import com.sdwtech.warnetflix.ui.detail.DetailViewModel
import com.sdwtech.warnetflix.ui.movie.MovieViewModel
import com.sdwtech.warnetflix.ui.tvshow.TvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<WarnetflixUseCase> { WarnetflixInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvShowViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}