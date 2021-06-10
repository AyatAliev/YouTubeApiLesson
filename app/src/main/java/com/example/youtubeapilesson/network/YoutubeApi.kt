package com.example.youtubeapilesson.network

import com.example.youtubeapilesson.model.PlayList
import com.example.youtubeapilesson.network.result.Resource
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("playlists")
    suspend fun fetchAllPlayList(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
    ): Response<PlayList>

}