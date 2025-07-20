package com.tasnimulhasan.kmpmaster.ui.core.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KMPMasterTopAppBar(
    titleRes: String,
    navigationIcon: ImageVector,
    navigationIconContentDescription: String,
    actionIcon: ImageVector,
    actionIconsContentDescription: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(text = titleRes, color = MaterialTheme.colorScheme.onBackground) },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = navigationIconContentDescription,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconsContentDescription,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        },
        colors = colors,
        modifier = modifier.testTag("melodicTopAppBar"),
    )
}