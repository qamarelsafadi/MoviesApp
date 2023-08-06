package com.qamar.moviesapp.navigation

import androidx.navigation.NavController
import com.qamar.moviesapp.navigation.AppDestinationsArgs.ID_ARGS
import com.qamar.moviesapp.navigation.AppScreens.DETAILS_SCREEN


object AppDestinationsArgs {
    const val ID_ARGS = "id"
}

private object AppScreens {
    const val DETAILS_SCREEN = "Details"
}

object AppDestinations {
    const val DETAILS_ROUTE = "$DETAILS_SCREEN/{$ID_ARGS}"
}

enum class Screens {
    Movies,
    Details(),
}

class NavigationActions(private val navController: NavController) {
    fun navigateToDetails(id: Int) {
        navController.navigate("$DETAILS_SCREEN/$id")
    }
}