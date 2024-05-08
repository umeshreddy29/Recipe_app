package com.example.racipeapp.Databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.racipeapp.Recipe


@Database(entities = [Recipe::class], exportSchema = false, version =1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): Dao
}