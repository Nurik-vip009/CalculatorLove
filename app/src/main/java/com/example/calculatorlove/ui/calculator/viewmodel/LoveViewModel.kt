package com.example.calculatorlove.ui.calculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.calculatorlove.Repository
import com.example.calculatorlove.model.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoveViewModel @Inject constructor(
    private var repository: Repository
) : ViewModel() {

    fun getLoveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getPercentage(firstName, secondName)
    }

    fun insert(loveModel: LoveModel){
        repository.insert(loveModel)
    }
}