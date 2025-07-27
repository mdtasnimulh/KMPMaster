package com.tasnimulhasan.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.tasnimulhasan.onboarding.component.OnboardingItem
import kmpmaster.feature.onboarding.generated.resources.Res
import kmpmaster.feature.onboarding.generated.resources.onboarding_1
import kmpmaster.feature.onboarding.generated.resources.onboarding_2
import kmpmaster.feature.onboarding.generated.resources.onboarding_3
import kmpmaster.feature.onboarding.generated.resources.onboarding_description_1
import kmpmaster.feature.onboarding.generated.resources.onboarding_description_2
import kmpmaster.feature.onboarding.generated.resources.onboarding_description_3
import kmpmaster.feature.onboarding.generated.resources.onboarding_title_1
import kmpmaster.feature.onboarding.generated.resources.onboarding_title_2
import kmpmaster.feature.onboarding.generated.resources.onboarding_title_3
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

data class OnboardingModel(
    val image: Painter,
    val title: String,
    val description: String
)

@Composable
fun OnboardingScreen(
    goToHome: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState { 3 }

    val onboardingItems = listOf(
        OnboardingModel(
            image = painterResource(Res.drawable.onboarding_1),
            title = stringResource(Res.string.onboarding_title_1),
            description = stringResource(Res.string.onboarding_description_1)
        ),
        OnboardingModel(
            image = painterResource(Res.drawable.onboarding_2),
            title = stringResource(Res.string.onboarding_title_2),
            description = stringResource(Res.string.onboarding_description_2)
        ),
        OnboardingModel(
            image = painterResource(Res.drawable.onboarding_3),
            title = stringResource(Res.string.onboarding_title_3),
            description = stringResource(Res.string.onboarding_description_3)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val isNextAvailable = remember { mutableStateOf(false) }
        val isPreviousAvailable = remember { mutableStateOf(false) }

        HorizontalPager(
            state = pagerState
        ) { page ->
            isNextAvailable.value = pagerState.currentPage < 2
            isPreviousAvailable.value = pagerState.currentPage > 0
            OnboardingItem(
                item = onboardingItems[page]
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .widthIn(max = 700.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(
                onClick = {
                    if (pagerState.currentPage == 1 || pagerState.currentPage == 2) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage-1)
                        }
                    } else if (pagerState.currentPage == 0) {
                        goToHome.invoke()
                    }
                }
            ) {
                if (isPreviousAvailable.value) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Onboarding Screen Previous Icon",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                }
                Text(
                    text = if (isPreviousAvailable.value) "Prev" else "Skip",
                )
            }
            TextButton(
                onClick = {
                    if (pagerState.currentPage == 0 || pagerState.currentPage == 1) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage+1)
                        }
                    } else if (pagerState.currentPage == 2) {
                        goToHome.invoke()
                    }
                }
            ) {
                Text(
                    text = if (isNextAvailable.value) "Next" else "Let's Go"
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Onboarding Screen Next Icon",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}