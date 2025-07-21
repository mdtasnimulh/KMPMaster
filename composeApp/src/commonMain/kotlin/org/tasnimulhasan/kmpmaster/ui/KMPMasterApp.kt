package org.tasnimulhasan.kmpmaster.ui

import ProfileRoute
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Segment
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.rememberNavController
import com.tasnimulhasan.home.HomeRoute
import org.koin.compose.KoinApplication
import org.tasnimulhasan.kmpmaster.navigation.KMPMasterNavHost
import com.tasnimulhasan.kmpmaster.ui.core.components.KMPMasterNavigationBar
import com.tasnimulhasan.kmpmaster.ui.core.components.KMPMasterNavigationBarItem
import com.tasnimulhasan.kmpmaster.ui.core.components.KMPMasterTopAppBar
import com.tasnimulhasan.kmpmaster.ui.core.theme.KMPMasterTheme
import kotlin.reflect.KClass

@Composable
fun KMPMasterApp() {
    KoinApplication(
        application = {

        }
    ) {
        KMPMasterTheme {
            val appState = rememberKMPMasterAppState()

            KMPMasterApp(
                appState = appState,
                onTopAppBarActionClick = {

                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun KMPMasterApp(
    appState: KMPMasterAppState,
    onTopAppBarActionClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val currentDestination = appState.currentDestination
    val navController = rememberNavController()

    val isTopLevelDestination = appState.topLevelDestination.any { destination ->
        currentDestination?.route?.contains(destination.name, true) == true
    }

    val currentTitleRes = when (currentDestination?.route) {
        HomeRoute::class.qualifiedName -> "Home"
        ProfileRoute::class.qualifiedName -> "Profile"
        else -> "Kmp Master"
    }

    val navigationIcon = if (isTopLevelDestination) Icons.AutoMirrored.Filled.Segment
    else Icons.AutoMirrored.Filled.ArrowBack

    val navigationIconContentDescription = if (isTopLevelDestination) "Top App Bar Menu Button"
    else "Top App Bar Back Button"

    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .background(MaterialTheme.colorScheme.background.copy(alpha = 0.05f))
            .statusBarsPadding()
            .navigationBarsPadding()
            .fillMaxSize()
    ) {
        Scaffold(
            modifier = modifier,
            topBar = {
                KMPMasterTopAppBar(
                    titleRes = currentTitleRes,
                    navigationIcon = navigationIcon,
                    navigationIconContentDescription = navigationIconContentDescription,
                    actionIcon = Icons.Filled.MoreVert,
                    actionIconsContentDescription = "Settings",
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Transparent),
                    onActionClick = { onTopAppBarActionClick() },
                    onNavigationClick = {
                        appState.navigateBack()
                        //if (!isTopLevelDestination) appState.navigateBack()
                        //else customDrawerState = customDrawerState.opposite()
                    }
                )
            },
            bottomBar = {
                if (isTopLevelDestination){
                    KMPMasterNavigationBar {
                        appState.topLevelDestination.forEach { destination ->
                            KMPMasterNavigationBarItem(
                                selected = currentDestination.isRouteInHierarchy(destination.route),
                                onClick = { appState.navigateToTopLevelDestination(destination) },
                                icon = { Icon(imageVector = destination.unSelectedIcon, contentDescription = null) },
                                selectedIcon = { Icon(imageVector = destination.selectedIcon, contentDescription = null) },
                                label = { Text(text = destination.iconTextId) },
                            )
                        }
                    }
                }
            },
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
        ) { padding ->
            Box(
                modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                    .padding(padding)
                    .consumeWindowInsets(padding)
            ) {
                GetContent(appState = appState)
            }
        }
    }

}

@Composable
private fun GetContent(appState: KMPMasterAppState) {
    Box(modifier = Modifier.consumeWindowInsets(WindowInsets.safeDrawing.only(WindowInsetsSides.Top))) {
        KMPMasterNavHost(
            appState = appState,
            navigateBack = {
                appState.navigateBack()
            },
        )
    }
}

private fun NavDestination?.isRouteInHierarchy(route: KClass<*>) =
    this?.hierarchy?.any {
        it.hasRoute(route)
    } ?: false