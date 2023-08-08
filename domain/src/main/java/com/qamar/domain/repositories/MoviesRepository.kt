package com.qamar.domain.repositories

import com.qamar.domain.models.Movie
import com.qamar.domain.models.MovieResponse
import com.qamar.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getMovies(page: Int): Flow<Resource<MovieResponse>>
    suspend fun getMovieDetails(id: Int): Flow<Resource<Movie>>
}