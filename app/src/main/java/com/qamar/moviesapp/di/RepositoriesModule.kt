package com.qamar.moviesapp.di

import com.qamar.data.local.dao.MoviesDao
import com.qamar.data.local.datasoruce.LocalMovieDataSource
import com.qamar.data.local.datasoruce.LocalMovieDataSourceImpl
import com.qamar.data.remote.datasource.RemoteMovieDataSource
import com.qamar.data.remote.datasource.RemoteMovieDataSourceImpl
import com.qamar.data.remote.service.MoviesApiService
import com.qamar.data.repository.MovieRepositoryImpl
import com.qamar.domain.repositories.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {

    @Provides
    fun provideLocalDataSource(dao: MoviesDao): LocalMovieDataSource {
        return LocalMovieDataSourceImpl(dao)
    }

    @Provides
    fun provideRemoteDataSource(apiService: MoviesApiService): RemoteMovieDataSource {
        return RemoteMovieDataSourceImpl(apiService)
    }

    @Provides
    fun provideRepository(
        localMovieDataSource: LocalMovieDataSource,
        remoteMovieDataSource: RemoteMovieDataSource
    ): MoviesRepository {
        return MovieRepositoryImpl(remoteMovieDataSource, localMovieDataSource)
    }
}