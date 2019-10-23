package com.example.task.ui.namelist.news

import com.example.task.data.model.NewsPayload

interface NewsListItemView {
    fun showNewsList(payload: NewsPayload?)
    fun showLoadFailedMessage(error: String)
}