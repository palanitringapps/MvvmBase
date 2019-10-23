package com.example.task.ui.namelist

import android.app.Application
import com.example.task.base.BaseViewModel
import com.example.task.data.model.NameList
import com.example.task.ui.namelist.news.NewsListItemView
import com.example.task.util.NetworkConnectionUtil

class NameListViewModel(
    app: Application,
    var repository: NameItemRepository,
    var view: NewsListItemView
) : BaseViewModel(app), NameListDataSource.ResponseCallBack {

    override fun onDataLoad(response: NameList?) {

    }

    override fun onFailure(result: String) {

    }

    fun getNewsData() {
        if (NetworkConnectionUtil.isNetworkConnected(getApplication()))
            repository.getNameItemSuccessData("288", this)
        else view.showLoadFailedMessage("Please check the internet connection")
    }
}