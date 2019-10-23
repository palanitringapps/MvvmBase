package com.example.task.ui.namelist.news

import com.example.task.data.model.NewsPayload

interface NewsDataSource {

    interface ResponseCallBack {
        fun onDataLoad(response: NewsPayload?)

        fun onFailure(result: String)
    }

    fun getNews(language: String?, callBack: ResponseCallBack)
}