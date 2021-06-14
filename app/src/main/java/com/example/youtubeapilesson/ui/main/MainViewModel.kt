package com.example.youtubeapilesson.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.youtubeapilesson.base.BaseViewModel
import com.example.youtubeapilesson.model.PlayList
import com.example.youtubeapilesson.network.result.Resource
import com.example.youtubeapilesson.ui.Repository

class MainViewModel(private val repo: Repository) : BaseViewModel() {

    val loading = MutableLiveData<Boolean>()

    private val _fetchAllPlayList = MutableLiveData<Boolean>()

    val fetchAllPlayList: LiveData<Resource<PlayList>> = _fetchAllPlayList.switchMap {
        repo.fetchYoutubeApiPlayList()
    }

    fun setBoolean(isPlaylist: Boolean) {
        _fetchAllPlayList.postValue(isPlaylist)
    }

}