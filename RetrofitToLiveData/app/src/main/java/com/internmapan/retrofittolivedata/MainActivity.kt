package com.internmapan.retrofittolivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.internmapan.retrofittolivedata.adapter.WisataAdapter
import com.internmapan.retrofittolivedata.model.Wisata
import com.internmapan.retrofittolivedata.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var adapter: WisataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Adapter and Recycler view
        adapter = WisataAdapter()
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

        val observer = Observer<ArrayList<Wisata>>{
            data ->
            //Update ui if data changes
            adapter.setData(data)

        }

        //observe LiveData
        viewModel.returnData().observe(this,observer)

    }
}
