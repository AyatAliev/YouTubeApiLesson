package com.example.youtubeapilesson.ui.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapilesson.R
import com.example.youtubeapilesson.base.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_main) {

    private var viewModel: MainViewModel? = null

    override fun setupUI() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun setupLiveData() {

        viewModel?.fetchAllPlayList()?.observe(this, { response ->
            Toast.makeText(this, response?.kind.toString(), Toast.LENGTH_SHORT).show()
        })
    }

    override fun showDisconnectState() {

    }

}