package com.example.calculatorlove.ui.calculator.change.viewmodel

import androidx.lifecycle.ViewModel
import com.example.calculatorlove.Repository
import com.example.calculatorlove.model.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChangeViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun updateData(loveModel: LoveModel) {
        repository.updateData(loveModel)
    }
}


