package com.example.calculatorlove.di

import android.content.Context
import androidx.room.Room
import com.example.calculatorlove.App
import com.example.calculatorlove.MainPresenter
import com.example.calculatorlove.model.LoveApi
import com.example.calculatorlove.model.room.AppDatabase
import com.example.calculatorlove.model.room.LoveDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModel {



    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideMainPresenter(loveApi: LoveApi,loveDao: LoveDao): MainPresenter{
        return MainPresenter(loveApi, loveDao)
    }

    fun provideDao(appDatabase: AppDatabase): LoveDao{
        return appDatabase.getLoveDao()
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "love_list")
            .allowMainThreadQueries().build()
    }

    @Provides
    fun dao(@ApplicationContext context: Context): LoveDao {
        return provideDatabase(context).getLoveDao()
    }
}