package com.example.calculatorlove.ui.onbord.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBordViewModel @Inject constructor(private val pref: SharedPreferences) : ViewModel() {

    fun isUserSeen(): Boolean {
        return pref.getBoolean(KEY_BORD, false)
    }

    fun saveUserSeen() {
        pref.edit().putBoolean(KEY_BORD, true).apply()
    }

    companion object {
        const val KEY_PREF = "pref"
        const val KEY_BORD = "bord"
    }
}
