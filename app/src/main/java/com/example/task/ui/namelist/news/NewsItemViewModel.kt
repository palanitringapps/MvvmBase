package com.example.task.ui.namelist.news

import androidx.lifecycle.ViewModel
import com.example.task.data.model.NewsData

class NewsItemViewModel(var newsPayload: NewsData) : ViewModel() {

    fun imagePath(): String? {
        return newsPayload.image
    }
}