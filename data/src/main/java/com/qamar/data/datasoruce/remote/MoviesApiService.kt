package com.qamar.data.datasoruce.remote

import com.qamar.data.datasoruce.remote.model.MovieModel
import com.qamar.data.datasoruce.remote.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApiService {
    @GET("discover/movie")
    suspend fun getMovies(): Response<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int
    ): Response<MovieModel>

}