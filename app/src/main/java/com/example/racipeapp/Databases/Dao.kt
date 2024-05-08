package com.example.racipeapp.Databases

import androidx.room.Query
import androidx.room.Dao
import com.example.racipeapp.Recipe

@Dao
interface Dao{
    @Query("SELECT * FROM recipe")
    fun getall(): List<Recipe?>?
}