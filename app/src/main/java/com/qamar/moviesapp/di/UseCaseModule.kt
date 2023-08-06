package com.qamar.moviesapp.di

import com.qamar.domain.repositories.MoviesRepository
import com.qamar.domain.usecases.GetMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(repository: MoviesRepository): GetMovies {
        return GetMovies(repository)
    }
}