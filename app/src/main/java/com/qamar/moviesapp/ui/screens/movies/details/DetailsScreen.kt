package com.qamar.moviesapp.ui.screens.movies.details

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.qamar.domain.models.Movie
import com.qamar.moviesapp.ui.core.LoadingView
import com.qamar.moviesapp.ui.core.components.AsyncImage
import com.qamar.moviesapp.ui.screens.movies.MoviesViewModel
import com.qamar.moviesapp.ui.screens.movies.state.MoviesUiState

@Composable
fun DetailsScreen(
    id: Int,
    viewModel: MoviesViewModel = hiltViewModel()
) {

    val viewState: MoviesUiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    /**
     * get movies from viewModel
     */

    LaunchedEffect(Unit) {
        viewModel.getMoviesDetails(id)
    }

    /**
     * Handle Ui state from flow
     */

    when (val state = viewState) {
        is MoviesUiState.Loading -> LoadingView()
        is MoviesUiState.Success -> {
            state.movie?.let { DetailsContent(it) }
        }

        is MoviesUiState.Failed -> {
            Toast.makeText(context, state.message, Toast.LENGTH_LONG).show()
        }
    }

}

@Composable
fun DetailsContent(movie: Movie) {
    Column(Modifier.fillMaxSize()) {
        AsyncImage(
            imageUrl = movie.posterPath,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            contentScale = ContentScale.Crop
        )
        Column(Modifier.padding(horizontal = 16.dp)) {
            Text(
                movie.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                movie.releaseDate,
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                movie.overview,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        }

    }

}

@Composable
@Preview
private fun DetailsContentPreview() {
    DetailsContent(
        movie = Movie(
            id = 9027,
            overview = "petentium",
            posterPath = "viderer",
            releaseDate = "turpis",
            title = "rhoncus"
        )
    )
}
