package com.tasnimulhasan.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

fun NavGraphBuilder.homeRoutes(

) {
    composable<HomeRoute>(

    ){
        HomeScreen()
    }
}