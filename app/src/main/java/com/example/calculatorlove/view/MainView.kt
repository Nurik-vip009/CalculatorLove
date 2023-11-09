package com.example.calculatorlove.view

import com.example.calculatorlove.MainPresenter
import com.example.calculatorlove.model.LoveApi
import com.example.calculatorlove.model.LoveModel

interface MainView {
    fun changeScreen(loveModel: LoveModel)
    fun MainPresenter(loveApi: LoveApi): MainPresenter
}