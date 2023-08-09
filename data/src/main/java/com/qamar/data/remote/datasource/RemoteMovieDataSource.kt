package com.qamar.data.remote.datasource

import com.qamar.data.remote.model.MovieResponse
import com.qamar.domain.models.Movie
import com.qamar.domain.util.Resource

interface RemoteMovieDataSource {
    suspend fun getMovies(page: Int): Resource<MovieResponse>
    suspend fun getMovieDetails(id: Int): Resource<Movie>
}