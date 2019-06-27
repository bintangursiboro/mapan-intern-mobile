package com.internmapan.mvvmretrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //ViewModel can easily to test the data that will show into the UI
    var mList = ArrayList<String>()
    val mData : MutableLiveData<ArrayList<String>> by lazy {
        MutableLiveData<ArrayList<String>>()
    }

    init {
        //Adding mock data into list
        mList.add("wkwkwkwk")
        mList.add("hehehhe")
        mList.add("hohohoho")
        mList.add("yeaaaayy")

        //set data that will hold in LiveData
        mData.value = mList
    }

    fun addData(string: String){
        //Update the data into list
        mList.add(string)
        //Update the data that hold into the LiveData
        mData.value =mList
    }

}