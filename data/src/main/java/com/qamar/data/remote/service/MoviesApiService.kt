package com.qamar.data.remote.service

import com.qamar.data.remote.model.MovieModel
import com.qamar.data.remote.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApiService {
    @GET("discover/movie")
    suspend fun getMovies(
        @Query("page") page: Int = 1
    ): Response<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int
    ): Response<MovieModel>

}