package com.example.calculatorlove

import android.util.Log
import androidx.room.Insert
import com.example.calculatorlove.model.LoveApi
import com.example.calculatorlove.model.LoveModel
import com.example.calculatorlove.model.RetrofitService
import com.example.calculatorlove.model.room.LoveDao
import com.example.calculatorlove.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainPresenter @Inject constructor(private val loveApi: LoveApi, private val dao: LoveDao) {

    val api = RetrofitService().api
    val TAG = "ololo"

    lateinit var view: MainView

    fun getData(firstName: String, secondName: String){
        api.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    val model = response.body()
                    model?.let {
                        App.appDatabase.getLoveDao().insert(it)
                        view.changeScreen(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e(TAG,"onFailure: ${t.message}")
            }

        })
    }
    fun attachView(view: MainView){
        this.view = view
    }
}