package com.qamar.data.local.datasoruce

import com.qamar.data.local.entity.MovieEntity
import com.qamar.domain.models.Movie

interface LocalMovieDataSource {
    suspend fun saveMovies(movies: Movie)
    suspend fun getMovies(): List<MovieEntity>
    suspend fun getMovieDetails(id: Int): MovieEntity?
    suspend fun clearMovies()
}