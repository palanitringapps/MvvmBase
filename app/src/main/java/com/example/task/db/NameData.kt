package com.example.task.db

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "name_table")
class NameData {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "host")
    var host: String = ""

    @ColumnInfo(name = "addon")
    var item_addon_cat: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "type")
    var type: String = ""

    @ColumnInfo(name = "price")
    var price: Double = 0.0

    @ColumnInfo(name = "second_lang")
    var second_language_name: String = ""

    @ColumnInfo(name = "offer")
    var offer: String = ""

    @ColumnInfo(name = "pos")
    var pos: Int = 0

    @ColumnInfo(name = "date")
    var created_date: String = ""

    @ColumnInfo(name = "user")
    var user: String = ""

    @ColumnInfo(name = "sys")
    var sys: String = ""

    @ColumnInfo(name = "online")
    var show_online: Int = 0

    @ColumnInfo(name = "receipt")
    var show_on_receipt: Int = 0

}