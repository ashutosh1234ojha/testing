package com.ashutosh1234ojha.unittestapp.di

import android.content.Context
import androidx.room.Room
import com.ashutosh1234ojha.unittestapp.data.local.ShoppingDao
import com.ashutosh1234ojha.unittestapp.data.local.ShoppingItemDatabase
import com.ashutosh1234ojha.unittestapp.data.remote.PixabayAPI
import com.ashutosh1234ojha.unittestapp.others.Constants.BASE_URL
import com.ashutosh1234ojha.unittestapp.others.Constants.DATABASE_NAME
import com.ashutosh1234ojha.unittestapp.repositories.DefaultShoppingRepository
import com.ashutosh1234ojha.unittestapp.repositories.ShoppingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Ashutosh Ojha on 29,October,2021
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideShoppingItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ShoppingItemDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideShoppingDao(
        database: ShoppingItemDatabase
    ) = database.shoppingDao()

    @Singleton
    @Provides
    fun providePixabayApi(): PixabayAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixabayAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideDefaultShoppingRepository(
        dao: ShoppingDao,
        api: PixabayAPI
    ) = DefaultShoppingRepository(dao, api) as ShoppingRepository


}