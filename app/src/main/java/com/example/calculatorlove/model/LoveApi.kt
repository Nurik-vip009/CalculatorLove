package com.example.calculatorlove.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    //https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John
    //X-RapidAPI-Key: 933ca52712mshde8d52bcfc6bf59p11a0abjsnf5ddf9ab4794
    //X-RapidAPI-Host:  love-calculator.p.rapidapi.com
    @GET("getPercentage")
    fun getPercentage(
    @Query("fname") firstName: String,
    @Query("sname") secondName: String,
    @Header("X-RapidAPI-Key") key: String = "933ca52712mshde8d52bcfc6bf59p11a0abjsnf5ddf9ab4794",
    @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ) : Call<LoveModel>
}