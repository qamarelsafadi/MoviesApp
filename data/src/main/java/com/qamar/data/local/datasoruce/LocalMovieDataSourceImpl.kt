package com.qamar.data.local.datasoruce

import com.qamar.data.local.dao.MoviesDao
import com.qamar.data.local.entity.MovieEntity
import com.qamar.data.mapper.mapToEntity
import com.qamar.domain.models.Movie

class LocalMovieDataSourceImpl(private val movieDao: MoviesDao) : LocalMovieDataSource {
    override suspend fun saveMovies(movies: MovieEntity) = movieDao.saveMovies(movies)

    override suspend fun getMovies(): List<MovieEntity> = movieDao.getMovies()

    override suspend fun getMovieDetails(id: Int) = movieDao.getMovie(id)

}