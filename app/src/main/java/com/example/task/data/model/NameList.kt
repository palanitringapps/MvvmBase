package com.example.task.data.model

import com.google.gson.annotations.SerializedName

data class NameList(

    @SerializedName("id") val id: Int,
    @SerializedName("host") val host: String,
    @SerializedName("item_addon_cat") val item_addon_cat: Int,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("price") val price: Double,
    @SerializedName("background_color") val background_color: String,
    @SerializedName("font_color") val font_color: String,
    @SerializedName("pos") val pos: Int,
    @SerializedName("next_move") val next_move: String,
    @SerializedName("offer") val offer: String,
    @SerializedName("created_date") val created_date: String,
    @SerializedName("user") val user: String,
    @SerializedName("sys") val sys: String,
    @SerializedName("show_online") val show_online: Int,
    @SerializedName("show_on_receipt") val show_on_receipt: Int,
    @SerializedName("second_language_name") val second_language_name: String,
    @SerializedName("updated_at") val updated_at: String
)