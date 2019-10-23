package com.example.task.ui.namelist

class NameItemRepository(var dataSource: NameListDataSource) {
    fun getNameItemSuccessData(
        lang: String?,
        callBack: NameListDataSource.ResponseCallBack
    ) {
        dataSource.getData(lang, callBack)
    }

}