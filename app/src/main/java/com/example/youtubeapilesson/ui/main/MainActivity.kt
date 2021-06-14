package com.example.youtubeapilesson.ui.main

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapilesson.R
import com.example.youtubeapilesson.base.BaseActivity
import com.example.youtubeapilesson.extension.visible
import com.example.youtubeapilesson.model.Items
import com.example.youtubeapilesson.network.result.Status
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(R.layout.activity_main) {

    private val list = arrayListOf<Items>()
    private val mainAdapter: MainAdapter by lazy { MainAdapter(list, this::onHolderClick) }
    private val viewModel: MainViewModel by viewModel()

    override fun setupUI() {

    }

    private fun setupRecyclerView() {
        rv_playlist.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }
    }

    override fun setupLiveData() {

        viewModel.setBoolean(true)

        viewModel.loading.observe(this, {
            progress_bar.visible = it
        })

        viewModel.fetchAllPlayList.observe(this, { response ->
            when (response.status) {
                Status.SUCCESS -> {

                    response.data?.kind
                    response?.data?.items.let { it?.let { it1 -> list.addAll(it1) } }
                    setupRecyclerView()
                    mainAdapter.notifyDataSetChanged()
                    viewModel.loading.postValue(false)
                }
                Status.ERROR -> {
                    viewModel.loading.postValue(false)
                    Toast.makeText(this, response.code.toString(), Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> viewModel.loading.postValue(true)
            }
        })
    }

    override fun showDisconnectState() {

    }

    private fun onHolderClick(item: Items) {
        Toast.makeText(this, item.id, Toast.LENGTH_SHORT).show()
    }

}