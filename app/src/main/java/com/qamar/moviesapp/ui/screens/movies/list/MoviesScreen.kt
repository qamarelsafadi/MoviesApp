package com.qamar.moviesapp.ui.screens.movies.list

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.qamar.moviesapp.ui.screens.movies.MoviesViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
    goToDetails: (Int) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
   LaunchedEffect(Unit){
       coroutineScope.launch {
           delay(2000)
           viewModel.getMovies()
       }
   }
    Button(onClick = {
        viewModel.getMovies()
    }) {

    }

}