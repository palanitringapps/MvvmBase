package com.example.task.data.rest

import com.dysisdemo.data.model.LoginRequest
import com.dysisdemo.data.model.LoginResponse
import com.example.task.data.model.NewsPayload
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*
import java.util.*
import java.util.concurrent.TimeUnit


interface ApiServices {

    companion object {
        private const val BASEAPI = "https://qa-api.t2scdn.com/"
        private const val timeoutTime = 30

        private val defaultHttpClient = OkHttpClient.Builder()
            /*.addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .header("passstore", "288")
                    .build()
                chain.proceed(request)
            }*/
            .connectTimeout(timeoutTime.toLong(), TimeUnit.SECONDS)
            .writeTimeout(timeoutTime.toLong(), TimeUnit.SECONDS)
            .readTimeout(timeoutTime.toLong(), TimeUnit.SECONDS).build()


        private val sessionRetrofit = Retrofit.Builder()
            .baseUrl(BASEAPI)
            /*.addConverterFactory(ScalarsConverterFactory.create())*/
            .addConverterFactory(GsonConverterFactory.create())
            .client(defaultHttpClient)
            .build()


        val service = sessionRetrofit.create(ApiServices::class.java)

        //val scalarService : ScalarService = sessionRetrofit.create(Scalar)
    }

    @GET("consumer/menu/options/")
    fun getData(@Header("store") string: String): Call<JsonObject>


    @GET("public/v1/news")
    fun getNewsList(@Query("local") language: String?): Call<NewsPayload>

    /*@GET("repos/{owner}/{name}")
    fun getRepo(@Path("owner") owner: String, @Path("name") name: String): Single<Repo>*/
}