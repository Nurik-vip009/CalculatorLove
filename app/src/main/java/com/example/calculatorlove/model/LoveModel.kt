package com.example.calculatorlove.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "love_list")
data class LoveModel (
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int
        ): Serializable