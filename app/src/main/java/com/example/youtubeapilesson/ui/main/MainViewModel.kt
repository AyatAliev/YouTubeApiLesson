package com.example.youtubeapilesson.ui.main

import androidx.lifecycle.LiveData
import com.example.youtubeapilesson.base.BaseViewModel
import com.example.youtubeapilesson.model.PlayList
import com.example.youtubeapilesson.ui.Repository

class MainViewModel(private val repo: Repository) : BaseViewModel() {

    fun fetchAllPlayList(): LiveData<PlayList?> {
        return repo.fetchYoutubeApiPlayList()
    }

}