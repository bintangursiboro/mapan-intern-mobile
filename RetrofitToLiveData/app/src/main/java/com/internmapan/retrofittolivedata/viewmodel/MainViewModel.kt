package com.internmapan.retrofittolivedata.viewmodel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.internmapan.retrofittolivedata.model.Wisata
import com.internmapan.retrofittolivedata.model.WisataResponse
import com.internmapan.retrofittolivedata.network.RetrofitInstance
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    //Define MutableLiveData that hold data from  API
    private val listData by lazy {
        MutableLiveData<ArrayList<Wisata>>()
    }

    //Define retrofit
    val retrofit = RetrofitInstance.api()

    //Function that return LiveData, so that UI can observe Data by using this function
    fun returnData() : MutableLiveData<ArrayList<Wisata>>{
        getData()
        return listData
    }

    fun getData(){
        //Call function to get data from API, then implement callback function that return Wisata Response
        retrofit.getWisata().enqueue(object : Callback<WisataResponse> {
            //if the API call have a response or network is complete then, retrofit will call this callback
            override fun onResponse(call: Call<WisataResponse>, response: Response<WisataResponse>) {
                if (response.isSuccessful){
                    //If the response is success then update the livedata value
                    listData.value = response.body()!!.data
                    //after update the data, the UI will automatically update from observer that we define in UI Controller (Activity or Fragment)
                }
            }
            // if the API call is fail then retrofit will call this function
            override fun onFailure(call: Call<WisataResponse>, t: Throwable) {

            }

        })
    }
}