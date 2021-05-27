package com.example.youtubeapilesson.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapilesson.BuildConfig.API_KEY
import com.example.youtubeapilesson.`object`.Constants
import com.example.youtubeapilesson.base.BaseViewModel
import com.example.youtubeapilesson.model.PlayList
import com.example.youtubeapilesson.network.RetrofitClient
import com.example.youtubeapilesson.network.YoutubeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : BaseViewModel() {

    private var youtubeApi: YoutubeApi = RetrofitClient.create()

    fun fetchAllPlayList(): LiveData<PlayList?> {
        return fetchYoutubeApiPlayList()
    }

    private fun fetchYoutubeApiPlayList(): LiveData<PlayList?> {
        val data = MutableLiveData<PlayList?>()

        youtubeApi.fetchAllPlayList(Constants.PART, Constants.CHANNEL_ID, API_KEY)
            .enqueue(object : Callback<PlayList> {

                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    data.value = response.body()

                }

                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    // 404 - не найдено, 403 - токен истек, 401 - нет доступа
                }

            })

        return data
    }

}