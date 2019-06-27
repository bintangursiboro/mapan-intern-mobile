package com.internmapan.retrofittolivedata.network

import com.internmapan.retrofittolivedata.model.WisataResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    //interface function to get data response from API
    @GET("?action=findAll")
    fun getWisata() : Call<WisataResponse>

}