package com.example.task.ui.namelist.news

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.task.data.model.NewsPayload

import com.example.task.base.BaseViewModel
import com.example.task.util.NetworkConnectionUtil

class NewsListViewModel(
    app: Application,
    var repository: NewsItemRepository,
    var view: NewsListItemView
) : BaseViewModel(app), NewsDataSource.ResponseCallBack {

    private var newsLiveData: MutableLiveData<NewsPayload> = MutableLiveData()

    override fun onDataLoad(response: NewsPayload?) {
        newsLiveData.value = response
        view.showNewsList(newsLiveData.value)
    }

    override fun onFailure(result: String) {
        view.showLoadFailedMessage(result)
    }

    fun getNewsData() {
        if (NetworkConnectionUtil.isNetworkConnected(getApplication()))
            repository.getNewsItemSuccessData("en", this)
        else view.showLoadFailedMessage("Please check the internet connection")
    }

    class NewsListViewModelFactory(
        private val application: Application,
        private val repository: NewsItemRepository,
        private val view: NewsListItemView
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(
                Application::class.java, NewsItemRepository::class.java,
                NewsListItemView::class.java
            )
                .newInstance(application, repository, view)
        }
    }
}