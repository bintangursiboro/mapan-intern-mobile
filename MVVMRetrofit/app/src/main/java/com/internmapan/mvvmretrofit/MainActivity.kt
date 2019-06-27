package com.internmapan.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RvAdapter
    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Adapter for the Recycler View
        adapter = RvAdapter()
        //Layout manager for Recycler View
        recyclerView.layoutManager = LinearLayoutManager(this)
        //Set the Recycler View adapter
        recyclerView.adapter = adapter

        //Subscribe the viewmodel
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        //Observer variable to observe wether the LiveData changes or not
        val observer = Observer<ArrayList<String>>{
            data ->
            // if data change, update UI
            //this function is to update the current data for recyclerview item
            adapter.setData(data)
        }

        //view model observe the LiveData
        viewModel.mData.observe(this,observer)

        fab.setOnClickListener {
            //Sending signal to viewmodel, so that viewmodel update the livedata
            viewModel.addData("LOL")
        }

    }
}
