package com.example.task.ui.namelist.news


class NewsItemRepository(var newsDataSource: NewsDataSource) {
    fun getNewsItemSuccessData(
        lang: String?,
        callBack: NewsDataSource.ResponseCallBack
    ) {
        newsDataSource.getNews(lang, callBack)
    }
}