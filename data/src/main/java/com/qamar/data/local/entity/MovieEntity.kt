package com.qamar.data.local.entity

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "Movies")
data class MovieEntity(
    @PrimaryKey
    val id: Int = 0,
    val overview: String = "",
    val posterImage: String = "",
    val releaseDate: String = "",
    val title: String = "",
)