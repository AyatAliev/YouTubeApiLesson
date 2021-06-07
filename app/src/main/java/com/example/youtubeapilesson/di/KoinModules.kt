package com.example.youtubeapilesson.di

import com.example.youtubeapilesson.network.networkModule

val koinModules = listOf(
    networkModule,
    viewModules,
    repoModules
)