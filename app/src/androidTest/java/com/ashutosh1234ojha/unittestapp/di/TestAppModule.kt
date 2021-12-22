package com.ashutosh1234ojha.unittestapp.di

import android.content.Context
import androidx.room.Room
import com.ashutosh1234ojha.unittestapp.data.local.ShoppingItemDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

/**
 * Created by Ashutosh Ojha on 10,November,2021
 */
@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Named("test_db")
    fun provideInMemoryDb(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(context,  ShoppingItemDatabase::class.java)
            .allowMainThreadQueries()
            .build()
}