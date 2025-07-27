package org.tasnimulhasan.kmpmaster.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.tasnimulhasan.home.HomeRoute
import com.tasnimulhasan.home.homeScreen
import com.tasnimulhasan.onboarding.OnboardingRoute
import com.tasnimulhasan.onboarding.onboardingScreen
import org.tasnimulhasan.kmpmaster.ui.KMPMasterAppState
import profileScreen

@Composable
fun KMPMasterNavHost(
    appState: KMPMasterAppState,
    isFistLaunch: String,
    modifier: Modifier = Modifier,
    goToHome: () -> Unit,
    navigateBack: () -> Unit,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = when (isFistLaunch) {
            "Y" -> OnboardingRoute
            "N" -> HomeRoute
            else -> {}
        },
        modifier = modifier,
    ) {
        homeScreen()
        profileScreen()
        onboardingScreen(navigateBack = navigateBack, goToHome = goToHome)
    }
}