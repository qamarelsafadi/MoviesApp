package com.qamar.domain.usecases

import com.qamar.domain.repositories.MoviesRepository

class GetMovies(private val repository: MoviesRepository) {
    suspend fun getMovies(page: Int) = repository.getMovies(page)
    suspend fun getMovieDetails(id: Int) = repository.getMovieDetails(id)
}