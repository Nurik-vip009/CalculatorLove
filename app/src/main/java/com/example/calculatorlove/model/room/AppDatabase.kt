package com.example.calculatorlove.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.calculatorlove.model.LoveModel

@Database(version = 1, entities = [LoveModel::class])
abstract class AppDatabase :RoomDatabase() {

    abstract fun getLoveDao(): LoveDao

}