package org.tasnimulhasan.kmpmaster.navigation

import ProfileRoute
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.tasnimulhasan.home.HomeRoute
import kotlin.reflect.KClass

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val iconTextId: String,
    val titleTextId: String,
    val route: KClass<*>,
) {
    HOME(
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
        iconTextId = "Home",
        titleTextId = "Home",
        route = HomeRoute::class
    ),

    PROFILE(
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
        iconTextId = "Profile",
        titleTextId = "Profile",
        route = ProfileRoute::class
    ),
}