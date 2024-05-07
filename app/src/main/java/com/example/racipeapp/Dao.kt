package com.example.racipeapp

import androidx.room.Query
import androidx.room.Dao

@Dao
interface Dao{
    @Query("SELECT * FROM recipe")
    fun getall(): List<Recipe?>?
}