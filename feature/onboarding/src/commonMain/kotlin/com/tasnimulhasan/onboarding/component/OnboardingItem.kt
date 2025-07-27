package com.tasnimulhasan.onboarding.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tasnimulhasan.kmpmaster.ui.core.theme.BackgroundBlack
import com.tasnimulhasan.kmpmaster.ui.core.theme.DullBlue
import com.tasnimulhasan.onboarding.OnboardingModel

@Composable
fun OnboardingItem(
    item: OnboardingModel,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .widthIn(max = 600.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            painter = item.image,
            contentDescription = "Onboarding Screen 1 Image",
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            text = item.title,
            style = MaterialTheme.typography.titleLarge,
            color = BackgroundBlack,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            text = item.description,
            style = MaterialTheme.typography.bodyLarge,
            color = DullBlue,
            textAlign = TextAlign.Center
        )
    }
}