package com.tasnimulhasan.onboarding

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable object OnboardingRoute

fun NavController.navigateToOnboardingScreen(navOptions: NavOptionsBuilder.() -> Unit = {}){
    navigate(route = OnboardingRoute){
        navOptions()
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.onboardingScreen(
    navigateBack: () -> Unit,
) {
    composable<OnboardingRoute>(
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
        popEnterTransition = { fadeIn() },
        popExitTransition = { fadeOut() }
    ) {
        OnboardingScreen()
    }
}