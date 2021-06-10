package com.example.youtubeapilesson.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapilesson.base.BaseViewModel
import com.example.youtubeapilesson.model.PlayList
import com.example.youtubeapilesson.network.result.Resource
import com.example.youtubeapilesson.ui.Repository

class MainViewModel(private val repo: Repository) : BaseViewModel() {

    val loading = MutableLiveData<Boolean>()

    fun fetchAllPlayList(): LiveData<Resource<PlayList>> {
        return repo.fetchYoutubeApiPlayList()
    }

}