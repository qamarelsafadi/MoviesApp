package com.qamar.data.repository

import android.util.Log
import com.qamar.data.local.datasoruce.LocalMovieDataSource
import com.qamar.data.remote.datasource.RemoteMovieDataSource
import com.qamar.data.mapper.mapEntityToUiModel
import com.qamar.data.mapper.mapToEntity
import com.qamar.data.mapper.mapToModel
import com.qamar.data.mapper.mapToUiModel
import com.qamar.domain.models.Movie
import com.qamar.domain.models.MovieResponse
import com.qamar.domain.repositories.MoviesRepository
import com.qamar.domain.util.Resource

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteMovieDataSource,
    private val localDataSource: LocalMovieDataSource
) : MoviesRepository {

    override suspend fun getMovies(page: Int): Resource<MovieResponse> {

        // Clear local data when fetching the first page
        if (page == 1) {
            localDataSource.clearMovies()
        }
        val movieResponses = remoteDataSource.getMovies(page)
        val movies = movieResponses.data?.movies?.map {
            it.mapToUiModel()
        }
        movies?.forEach {
            localDataSource.saveMovies(it)
        }
        val localMovies = localDataSource.getMovies().mapToModel()
        return Resource.Success(
            MovieResponse(
                totalPages = movieResponses.data?.totalPages ?: 0,
                movies = localMovies
            )
        )
    }

    override suspend fun getMovieDetails(id: Int): Resource<Movie> {
        val movie = localDataSource.getMovieDetails(id)
        return if (movie != null) {
            Resource.Success(movie.mapEntityToUiModel())
        } else {
            val movieResponses = remoteDataSource.getMovieDetails(id)
            val movies = movieResponses.data
            Resource.Success(movies)
        }
    }
}