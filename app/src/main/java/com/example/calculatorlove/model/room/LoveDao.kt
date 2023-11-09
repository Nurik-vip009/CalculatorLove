package com.example.calculatorlove.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.calculatorlove.model.LoveModel


@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_list ORDER BY id DESC")
    fun getList(): List<LoveModel>

    @Insert
    fun addData(loveModel: LoveModel)

    @Delete
    fun deleteData(loveModel: LoveModel)

    @Update
    fun updateData(loveModel: LoveModel)
}