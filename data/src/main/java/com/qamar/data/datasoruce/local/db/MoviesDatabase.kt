package com.qamar.data.datasoruce.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.qamar.data.datasoruce.local.dao.MoviesDao
import com.qamar.data.datasoruce.local.entity.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MoviesDatabase : RoomDatabase() {
    abstract val dao : MoviesDao
}