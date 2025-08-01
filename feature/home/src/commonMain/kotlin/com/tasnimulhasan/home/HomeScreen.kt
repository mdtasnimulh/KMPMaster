package com.tasnimulhasan.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val isFirstLaunch = viewModel.isFirstLaunch.collectAsState()

    LaunchedEffect(isFirstLaunch.value) {
        println("Is First Launch Value: ${isFirstLaunch.value}")
        if (isFirstLaunch.value == "Y"){
            viewModel.setIsFirstLaunch("N")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Home Screen !!!",
            style = MaterialTheme.typography.titleLarge
        )
    }
}