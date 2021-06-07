package com.example.youtubeapilesson.di

import com.example.youtubeapilesson.ui.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules : Module = module {
    single { Repository(get()) }
}