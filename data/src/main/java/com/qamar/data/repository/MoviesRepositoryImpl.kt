package com.qamar.data.repository

import com.qamar.data.datasoruce.local.dao.MoviesDao
import com.qamar.data.datasoruce.remote.MoviesApiService
import com.qamar.data.util.map
import com.qamar.domain.models.Movie
import com.qamar.domain.repositories.MoviesRepository
import com.qamar.domain.util.Resource

class MoviesRepositoryImpl(
    private val moviesApiService: MoviesApiService,
    private val dao: MoviesDao,
) : MoviesRepository {
    override suspend fun getMoviesFromRemote(): Resource<List<Movie>> {
        val response = moviesApiService.getMovies()
        return try {
            if (response.isSuccessful) {
                response.body()?.movies?.let {
                    dao.saveMovies(it.map())
                }
                Resource.Success(
                    dao.getMovies().map()
                )
            } else {
                Resource.Error(
                    response.message()
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(
                message = e.localizedMessage ?: ""
            )
        }
    }

    override suspend fun getMovieDetails(id: Int): Resource<Movie> {
        val response = moviesApiService.getMovieDetails(id)
        return try {
            if (response.isSuccessful) {
                Resource.Success(
                    response.body()
                )
            } else {
                Resource.Error(
                    response.message()
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(
                message = e.localizedMessage ?: ""
            )
        }
    }
}