package com.qamar.data.datasoruce.remote

import com.qamar.data.BuildConfig
import com.qamar.domain.models.Movie
import com.qamar.domain.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MoviesApiService {
    @GET("discover/movie")
    suspend fun getMovies(): Response<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int): Response<Movie>

}