package com.qamar.data.remote.datasource

import android.util.Log
import com.qamar.data.local.dao.MoviesDao
import com.qamar.data.local.entity.MovieEntity
import com.qamar.data.mapper.mapToEntity
import com.qamar.data.mapper.mapToUiModel
import com.qamar.data.remote.model.MovieResponse
import com.qamar.data.remote.service.MoviesApiService
import com.qamar.domain.models.Movie
import com.qamar.domain.util.Resource
import java.lang.Exception

class RemoteMovieDataSourceImpl(
    private val moviesApiService: MoviesApiService
) : RemoteMovieDataSource {
    override suspend fun getMovies(page: Int): Resource<MovieResponse> {
        return try {
            val response = moviesApiService.getMovies(page)
            if (response.isSuccessful) {
                Resource.Success(response.body())
            } else {
                Resource.Error(response.message())
            }

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.localizedMessage ?: "")
        }
    }

    override suspend fun getMovieDetails(id: Int): Resource<Movie> {
        return try {
            val response = moviesApiService.getMovieDetails(id)
            if (response.isSuccessful) {
                Resource.Success(response.body()?.mapToUiModel())
            } else {
                Resource.Error(response.message())
            }

        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "")
        }
    }
}