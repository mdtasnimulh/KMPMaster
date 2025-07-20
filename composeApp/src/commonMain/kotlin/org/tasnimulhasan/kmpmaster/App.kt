package org.tasnimulhasan.kmpmaster

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tasnimulhasan.home.HomeRoute
import com.tasnimulhasan.home.homeRoutes
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(
        application = {

        }
    ) {
        MaterialTheme {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = HomeRoute
            ) {
                homeRoutes()
            }
        }
    }
}