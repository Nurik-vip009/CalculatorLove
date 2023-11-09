package com.example.calculatorlove

import androidx.lifecycle.MutableLiveData
import com.example.calculatorlove.model.LoveApi
import com.example.calculatorlove.model.LoveModel
import com.example.calculatorlove.model.room.LoveDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class Repository @Inject constructor(private val loveApi: LoveApi, private val dao: LoveDao) {

    fun insert(loveModel: LoveModel) {
        dao.addData(loveModel)
    }

    fun getData(): List<LoveModel> {
        return dao.getList()
    }

    fun deleteData(loveModel: LoveModel) {
        dao.deleteData(loveModel)
    }

    fun updateData(loveModel: LoveModel){
        dao.updateData(loveModel)
    }

    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val mutableLiveData = MutableLiveData<LoveModel>()
        loveApi.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {

            }
        })
        return mutableLiveData
    }

}
