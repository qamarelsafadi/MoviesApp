package com.qamar.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.qamar.data.local.entity.MovieEntity

@Dao
interface MoviesDao {

    @Upsert
    suspend fun saveMovies(movie: MovieEntity)

    @Transaction
    @Query("Select * from movies")
    suspend fun getMovies(): List<MovieEntity>

    @Query("Select * from movies where :id=id ")
    suspend fun getMovie(id: Int): MovieEntity?


    @Query("DELETE FROM movies")
    suspend fun clearMovies()

}