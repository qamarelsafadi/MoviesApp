package com.qamar.moviesapp.ui.screens.movies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qamar.domain.usecases.GetMovies
import com.qamar.domain.util.Resource
import com.qamar.moviesapp.ui.screens.movies.state.MoviesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val useCase: GetMovies
) : ViewModel() {

    /**
     * State Flows
     */
    private val _uiState = MutableStateFlow<MoviesUiState>(MoviesUiState.Loading)
    val uiState: StateFlow<MoviesUiState> = _uiState.asStateFlow()
    private val page = mutableStateOf(1)
    var canPaginate by mutableStateOf(false)

    /**
     * Fetching Data
     */

    fun getMovies() {
        viewModelScope.launch {
            val uiState = when (val response = useCase.getMovies(
                page.value
            )) {
                is Resource.Success -> {
                    val data = response.data
                    canPaginate = page.value < (data?.totalPages ?: 1)
                    if (canPaginate)
                        page.value++
                    MoviesUiState.Success(
                        movies =  response.data?.movies?.toImmutableList()
                    )
                }

                is Resource.Error ->
                    MoviesUiState.Failed(
                        response.message ?: ""
                    )
            }
            _uiState.update {
                uiState
            }
        }
    }

    fun getMoviesDetails(id: Int) {
        viewModelScope.launch {
            val uiState = when (val response = useCase.getMovieDetails(id)) {
                is Resource.Success -> {
                    val data = response.data
                    MoviesUiState.Success(
                        movie = data
                    )
                }

                is Resource.Error ->
                    MoviesUiState.Failed(
                        response.message ?: ""
                    )
            }
            _uiState.update {
                uiState
            }
        }
    }
}