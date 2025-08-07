package org.tasnimulhasan.kmpmaster.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import com.tasnimulhasan.home.HomeRoute
import com.tasnimulhasan.home.homeScreen
import com.tasnimulhasan.onboarding.OnboardingRoute
import com.tasnimulhasan.onboarding.onboardingScreen
import org.koin.android.annotation.KoinViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.tasnimulhasan.kmpmaster.ui.KMPMasterAppState
import org.tasnimulhasan.kmpmaster.ui.KmpMasterViewModel
import profileScreen

@Composable
fun KMPMasterNavHost(
    appState: KMPMasterAppState,
    modifier: Modifier = Modifier,
    goToHome: () -> Unit,
    navigateBack: () -> Unit,
) {
    val navController = appState.navController
    val viewModel: KmpMasterViewModel = koinViewModel()

    NavHost(
        navController = navController,
        startDestination = viewModel.determineStartDestination(),
        modifier = modifier,
    ) {
        homeScreen()
        profileScreen()
        onboardingScreen(navigateBack = navigateBack, goToHome = goToHome)
    }
}