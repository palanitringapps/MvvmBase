package com.example.task.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NameListDao::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun nameDao(): NameListDao


    companion object {
        private var INSTANCE: DataBase? = null

        private const val DB_NAME = "sample_db"

        private val lock = Any()

        fun getInstance(context: Context): DataBase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, DataBase::class.java,
                        DB_NAME
                    ).build()
                }
                return INSTANCE!!
            }
        }
    }
}