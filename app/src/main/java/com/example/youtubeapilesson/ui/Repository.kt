package com.example.youtubeapilesson.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.youtubeapilesson.BuildConfig
import com.example.youtubeapilesson.`object`.Constants
import com.example.youtubeapilesson.model.PlayList
import com.example.youtubeapilesson.network.YoutubeApi
import com.example.youtubeapilesson.network.result.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val youtubeApi: YoutubeApi) {

    fun fetchYoutubeApiPlayList(): LiveData<Resource<PlayList>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val response = youtubeApi.fetchAllPlayList(Constants.PART,Constants.CHANNEL_ID,BuildConfig.API_KEY)
        emit(if (response.isSuccessful) Resource.success(response.body())
        else Resource.error(response.message(),response.body(),response.code()))
    }
}