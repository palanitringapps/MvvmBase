package com.example.task.ui.namelist

import com.example.task.data.model.NameList

interface NameListDataSource {

    interface ResponseCallBack {
        fun onDataLoad(response: NameList?)

        fun onFailure(result: String)
    }

    fun getData(language: String?, callBack: NameListDataSource.ResponseCallBack)
}