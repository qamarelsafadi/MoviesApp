package com.qamar.moviesapp.di

import com.qamar.data.datasoruce.local.dao.MoviesDao
import com.qamar.data.datasoruce.remote.MoviesApiService
import com.qamar.data.repository.MoviesRepositoryImpl
import com.qamar.domain.repositories.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {
    @Provides
    fun provideRepository(apiService: MoviesApiService, dao: MoviesDao): MoviesRepository {
        return MoviesRepositoryImpl(apiService,dao)
    }
}