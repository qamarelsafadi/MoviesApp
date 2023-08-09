package com.qamar.data.repository

import com.qamar.data.local.datasoruce.LocalMovieDataSource
import com.qamar.data.mapper.mapEntityToUiModel
import com.qamar.data.mapper.mapToModel
import com.qamar.data.mapper.mapToUiModel
import com.qamar.data.remote.datasource.RemoteMovieDataSource
import com.qamar.domain.models.Movie
import com.qamar.domain.models.MovieResponse
import com.qamar.domain.repositories.MoviesRepository
import com.qamar.domain.util.Resource
import com.qamar.domain.util.handleSuccess
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteMovieDataSource,
    private val localDataSource: LocalMovieDataSource
) : MoviesRepository {

    override suspend fun getMovies(page: Int): Flow<Resource<MovieResponse>> {
        val movieResponses = remoteDataSource.getMovies(page)
        val movies = movieResponses.data?.movies?.map {
            it.mapToUiModel()
        }
        movies?.forEach {
            localDataSource.saveMovies(it)
        }
        val localMovies = localDataSource.getMovies().mapToModel()
        return handleSuccess(
            MovieResponse(
                totalPages = movieResponses.data?.totalPages ?: 0,
                movies = localMovies
            )
        )
    }

    override suspend fun getMovieDetails(id: Int): Flow<Resource<Movie>> {
        val movie = localDataSource.getMovieDetails(id)
        return if (movie != null) {
            handleSuccess(movie.mapEntityToUiModel())
        } else {
            val movieResponses = remoteDataSource.getMovieDetails(id)
            val movies = movieResponses.data
            handleSuccess(movies)
        }
    }
}