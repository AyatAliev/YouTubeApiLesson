package com.example.youtubeapilesson.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapilesson.BuildConfig
import com.example.youtubeapilesson.`object`.Constants
import com.example.youtubeapilesson.model.PlayList
import com.example.youtubeapilesson.network.YoutubeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val youtubeApi: YoutubeApi) {

    fun fetchYoutubeApiPlayList(): LiveData<PlayList?> {
        val data = MutableLiveData<PlayList?>()

        youtubeApi.fetchAllPlayList(Constants.PART, Constants.CHANNEL_ID, BuildConfig.API_KEY)
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