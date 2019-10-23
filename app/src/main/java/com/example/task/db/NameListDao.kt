package com.example.task.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NameListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(nameData: NameData)

    @Query("SELECT * FROM name_table")
    fun getNameList(): List<NameData>
}