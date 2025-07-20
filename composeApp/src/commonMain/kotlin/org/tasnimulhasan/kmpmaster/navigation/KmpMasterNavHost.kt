package org.tasnimulhasan.kmpmaster.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.tasnimulhasan.home.HomeRoute
import com.tasnimulhasan.home.homeScreen
import org.tasnimulhasan.kmpmaster.ui.KMPMasterAppState
import profileScreen

@Composable
fun KMPMasterNavHost(
    appState: KMPMasterAppState,
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier,
    ) {
        homeScreen()
        profileScreen()
    }
}