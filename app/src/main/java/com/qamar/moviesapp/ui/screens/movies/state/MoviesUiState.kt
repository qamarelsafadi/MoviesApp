package com.qamar.moviesapp.ui.screens.movies.state

import com.qamar.domain.models.Movie
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf


/**
 * using sealed interface for UiState to make the code more readable when handle it on the view screen
 * I know that I can directly use data class but it will not be as readable as this is when using it
 * in the view screen ( a personal point of view that has no solid resource ^_^" )
 */

sealed interface MoviesUiState {
    object Loading : MoviesUiState
    data class Success(
        val movies: ImmutableList<Movie>? = persistentListOf(),
        val movie: Movie? = null,
    ) : MoviesUiState

    data class Failed(
        val message: String,
    ) : MoviesUiState

}