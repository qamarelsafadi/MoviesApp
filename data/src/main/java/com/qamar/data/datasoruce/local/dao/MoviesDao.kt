package com.qamar.data.datasoruce.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.qamar.data.datasoruce.local.entity.MovieEntity

@Dao
interface MoviesDao {

    @Upsert
    suspend fun saveMovies(movie: List<MovieEntity>)

    @Query("Select * from movies")
    suspend fun getMovies(): List<MovieEntity>

    @Query("Select * from movies where :id=id ")
    suspend fun getMovie(id: Int): MovieEntity?

}