package com.qamar.moviesapp.ui.screens.movies.list

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qamar.domain.models.Movie
import com.qamar.moviesapp.ui.core.LoadingView
import com.qamar.moviesapp.ui.screens.movies.MoviesViewModel
import com.qamar.moviesapp.ui.screens.movies.list.item.MovieCard
import com.qamar.moviesapp.ui.screens.movies.state.MoviesUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
    goToDetails: (Int) -> Unit
) {

    val viewState: MoviesUiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    /**
     * get movies from viewModel
     */

    LaunchedEffect(Unit) {
        viewModel.getMovies()
    }

    /**
     * Handle Ui state from flow
     */

    when (val state = viewState) {
        is MoviesUiState.Loading -> LoadingView()
        is MoviesUiState.Success -> {
            HomeContent(
                movies = state.movies ?: persistentListOf(),
                onMovieClick = goToDetails
            )
        }

        is MoviesUiState.Failed -> {
            Toast.makeText(context, state.message, Toast.LENGTH_LONG).show()
        }
    }

}

@Composable
fun HomeContent(
    movies: ImmutableList<Movie>,
    onMovieClick: (Int) -> Unit
) {
    LazyColumn(contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)) {
        items(movies) { movie ->
            MovieCard(movie, onMovieClick)
        }
    }
}

