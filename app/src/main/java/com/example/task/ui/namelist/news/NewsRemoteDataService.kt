package com.example.task.ui.namelist.news

import com.example.task.data.model.NewsPayload
import com.example.task.data.rest.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRemoteDataService : NewsDataSource {
    override fun getNews(language: String?, callBack: NewsDataSource.ResponseCallBack) {
        var getNews = ApiServices.service.getNewsList(language)
        getNews.enqueue(object : Callback<NewsPayload> {
            override fun onFailure(call: Call<NewsPayload>, t: Throwable) {
                callBack.onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<NewsPayload>, response: Response<NewsPayload>) {
                if (response.isSuccessful) {
                    callBack.onDataLoad(response.body())
                } else callBack.onFailure(response.errorBody().toString())
            }
        })
    }
}