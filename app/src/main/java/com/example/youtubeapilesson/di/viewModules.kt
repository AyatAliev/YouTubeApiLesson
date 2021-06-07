package com.example.youtubeapilesson.di

import com.example.youtubeapilesson.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules : Module = module {
    viewModel { MainViewModel(get()) }
}