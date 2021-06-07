package com.example.youtubeapilesson.ui.main

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapilesson.R
import com.example.youtubeapilesson.base.BaseActivity
import com.example.youtubeapilesson.model.Items
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(R.layout.activity_main) {

    private val list = mutableListOf<Items>()
    private var mainAdapter: MainAdapter? = null
    private val viewModel: MainViewModel by viewModel()

    override fun setupUI() {

    }

    private fun setupRecyclerView() {
        mainAdapter = MainAdapter(list,this::onHolderClick)
        rv_playlist.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }
    }

    override fun setupLiveData() {

        viewModel?.fetchAllPlayList()?.observe(this, { response ->
            response?.items?.let { list.addAll(it) }
            setupRecyclerView()
            mainAdapter?.notifyDataSetChanged()
        })
    }

    override fun showDisconnectState() {

    }

    private fun onHolderClick(item: Items){
        Toast.makeText(this,item.id,Toast.LENGTH_SHORT).show()
    }

}