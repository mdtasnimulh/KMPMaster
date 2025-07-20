package com.tasnimulhasan.kmpmaster.ui.core.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItemColors
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.KMPMasterNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alwaysShowLabel: Boolean = true,
    icon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit = icon,
    label: @Composable (() -> Unit)? = null
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = KMPMasterNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = KMPMasterNavigationDefaults.navigationContentColor(),
            selectedTextColor = KMPMasterNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = KMPMasterNavigationDefaults.navigationContentColor(),
            indicatorColor = KMPMasterNavigationDefaults.navigationIndicatorColor(),
        )
    )
}

@Composable
fun KMPMasterNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        contentColor = KMPMasterNavigationDefaults.navigationContentColor(),
        tonalElevation = 0.dp,
        content = content,
    )
}

@Composable
fun KMPMasterNavigationRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alwaysShowLabel: Boolean = true,
    icon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit = icon,
    label: @Composable (() -> Unit)? = null
) {
    NavigationRailItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationRailItemDefaults.colors(
            selectedIconColor = KMPMasterNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = KMPMasterNavigationDefaults.navigationContentColor(),
            selectedTextColor = KMPMasterNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = KMPMasterNavigationDefaults.navigationContentColor(),
            indicatorColor = KMPMasterNavigationDefaults.navigationIndicatorColor(),
        ),
    )
}

@Composable
fun KMPMasterNavigationRail(
    modifier: Modifier = Modifier,
    header: @Composable (ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    NavigationRail(
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = KMPMasterNavigationDefaults.navigationContentColor(),
        header = header,
        content = content,
    )
}

@Composable
fun KMPMasterNavigationSuiteScaffold(
    navigationSuiteItems: KMPMasterNavigationSuiteScope.() -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val navigationSuiteItemColors = NavigationSuiteItemColors(
        navigationBarItemColors = NavigationBarItemDefaults.colors(
            selectedIconColor = KMPMasterNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = KMPMasterNavigationDefaults.navigationContentColor(),
            selectedTextColor = KMPMasterNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = KMPMasterNavigationDefaults.navigationContentColor(),
            indicatorColor = KMPMasterNavigationDefaults.navigationIndicatorColor(),
        ),
        navigationRailItemColors = NavigationRailItemDefaults.colors(
            selectedIconColor = KMPMasterNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = KMPMasterNavigationDefaults.navigationContentColor(),
            selectedTextColor = KMPMasterNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = KMPMasterNavigationDefaults.navigationContentColor(),
            indicatorColor = KMPMasterNavigationDefaults.navigationIndicatorColor(),
        ),
        navigationDrawerItemColors = NavigationDrawerItemDefaults.colors(
            selectedIconColor = KMPMasterNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = KMPMasterNavigationDefaults.navigationContentColor(),
            selectedTextColor = KMPMasterNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = KMPMasterNavigationDefaults.navigationContentColor(),
        ),
    )

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            KMPMasterNavigationSuiteScope(
                navigationSuiteScope = this,
                navigationSuiteItemColors = navigationSuiteItemColors,
            ).run(navigationSuiteItems)
        },
        containerColor = Color.Transparent,
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContentColor = KMPMasterNavigationDefaults.navigationContentColor(),
            navigationRailContainerColor = Color.Transparent,
        ),
        modifier = modifier,
    ) {
        content()
    }
}

class KMPMasterNavigationSuiteScope internal constructor(
    private val navigationSuiteScope: NavigationSuiteScope,
    private val navigationSuiteItemColors: NavigationSuiteItemColors,
) {
    fun item(
        selected: Boolean,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        icon: @Composable () -> Unit,
        selectedIcon: @Composable () -> Unit = icon,
        label: @Composable (() -> Unit)? = null,
    ) = navigationSuiteScope.item(
        selected = selected,
        onClick = onClick,
        icon = {
            if (selected) {
                selectedIcon()
            } else {
                icon()
            }
        },
        label = label,
        colors = navigationSuiteItemColors,
        modifier = modifier,
    )
}

object KMPMasterNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}