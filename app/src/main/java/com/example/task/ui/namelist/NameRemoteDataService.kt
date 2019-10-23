package com.example.task.ui.namelist

import com.example.task.data.rest.ApiServices
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class NameRemoteDataService : NameListDataSource {
    override fun getData(language: String?, callBack: NameListDataSource.ResponseCallBack) {
        val nameListCall = ApiServices.service.getData("288")
        nameListCall.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                callBack.onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.isSuccessful) {
                    convertBase64(response.body())
                    //callBack.onDataLoad(response.body())
                } else callBack.onFailure(response.errorBody().toString())
            }

        })
    }

    fun convertBase64(jsonObject: JsonObject?) {
        var data: JsonArray? = jsonObject?.getAsJsonArray("data")
    }




}