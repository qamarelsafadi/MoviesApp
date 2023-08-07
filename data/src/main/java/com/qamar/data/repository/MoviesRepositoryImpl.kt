package com.qamar.data.repository

import com.qamar.data.datasoruce.local.dao.MoviesDao
import com.qamar.data.datasoruce.remote.MoviesApiService
import com.qamar.data.util.mapEntityToUiModel
import com.qamar.data.util.mapToEntity
import com.qamar.data.util.mapToModel
import com.qamar.data.util.mapToUiModel
import com.qamar.domain.models.Movie
import com.qamar.domain.repositories.MoviesRepository
import com.qamar.domain.util.Resource
import java.net.UnknownHostException

class MoviesRepositoryImpl(
    private val moviesApiService: MoviesApiService,
    private val dao: MoviesDao,
) : MoviesRepository {

    override suspend fun getMovies(): Resource<List<Movie>> {
        return try {
            val response = moviesApiService.getMovies()
            response.body()?.movies?.let {
                dao.saveMovies(it.mapToEntity())
            }
            Resource.Success(
                dao.getMovies().mapToModel()
            )
        } catch (e: UnknownHostException) {
            e.printStackTrace()
            Resource.Success(
                dao.getMovies().mapToModel()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(
                message = e.localizedMessage ?: ""
            )
        }
    }

    override suspend fun getMovieDetails(id: Int): Resource<Movie> {
        return try {
            val movie = dao.getMovie(id)
            if (movie != null) {
                Resource.Success(
                    movie.mapEntityToUiModel()
                )
            } else {
                val response = moviesApiService.getMovieDetails(id)
                if (response.isSuccessful) {
                    Resource.Success(
                        response.body()?.mapToUiModel()
                    )
                } else {
                    Resource.Error(
                        response.message()
                    )
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(
                message = e.localizedMessage ?: ""
            )
        }
    }
}