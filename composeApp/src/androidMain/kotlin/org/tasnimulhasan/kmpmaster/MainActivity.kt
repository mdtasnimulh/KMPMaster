package org.tasnimulhasan.kmpmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tasnimulhasan.onboarding.OnboardingScreen
import org.tasnimulhasan.kmpmaster.ui.KMPMasterApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            KMPMasterApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppAndroidPreview() {
    MaterialTheme {
        OnboardingScreen{}
    }
}