package com.qamar.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.qamar.data.datasoruce.local.dao.MoviesDao
import com.qamar.data.datasoruce.local.db.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): MoviesDatabase =Room.databaseBuilder(
        context.applicationContext,
        MoviesDatabase::class.java,
        "movies-db"
    ).build()

    @Provides
    @Singleton
    fun provideDao(db: MoviesDatabase): MoviesDao = db.dao

}