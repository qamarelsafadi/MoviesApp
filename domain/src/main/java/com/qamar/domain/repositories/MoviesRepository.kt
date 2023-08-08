package com.qamar.domain.repositories

import com.qamar.domain.models.Movie
import com.qamar.domain.models.MovieResponse
import com.qamar.domain.util.Resource

interface MoviesRepository {
    suspend fun getMovies(page: Int): Resource<MovieResponse>
    suspend fun getMovieDetails(id: Int): Resource<Movie>
}