package com.internmapan.retrofittolivedata.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance{
    //Instance of retrofit, so that class that need can direct call the function
    //OkHttpClient is used for debug the network response
    fun getInterceptor() : OkHttpClient{
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okhttp = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
        return okhttp
    }

    fun getNetwork() : Retrofit{
        return Retrofit.Builder().baseUrl("https://udacoding.com/api/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun api() : ApiInterface{
        //Set the retrofit
        return getNetwork().create(ApiInterface::class.java)
    }

}