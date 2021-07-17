package com.sdwtech.warnetflix.favorite

import com.sdwtech.warnetflix.favorite.movie.FavMovieViewModel
import com.sdwtech.warnetflix.favorite.tvshow.FavTvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favModule = module {
    viewModel { FavMovieViewModel(get()) }
    viewModel { FavTvShowViewModel(get()) }
}