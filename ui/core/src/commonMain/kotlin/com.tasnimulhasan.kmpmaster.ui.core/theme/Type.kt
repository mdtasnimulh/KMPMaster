package com.tasnimulhasan.kmpmaster.ui.core.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kmpmaster.ui.core.generated.resources.Res
import kmpmaster.ui.core.generated.resources.roboto_black
import kmpmaster.ui.core.generated.resources.roboto_bold
import kmpmaster.ui.core.generated.resources.roboto_italic
import kmpmaster.ui.core.generated.resources.roboto_light
import kmpmaster.ui.core.generated.resources.roboto_medium
import kmpmaster.ui.core.generated.resources.roboto_regular
import org.jetbrains.compose.resources.Font

@Composable
fun robotoFontFamily() = FontFamily(
    Font(Res.font.roboto_light, weight = FontWeight.Light),
    Font(Res.font.roboto_regular, weight = FontWeight.Normal),
    Font(Res.font.roboto_medium, weight = FontWeight.Medium),
    Font(Res.font.roboto_bold, weight = FontWeight.Bold),
    Font(Res.font.roboto_black, weight = FontWeight.Black),
    Font(Res.font.roboto_italic, weight = FontWeight.Normal, style = FontStyle.Italic)
)

@Composable
fun robotoTypography() = Typography().run {

    val fontFamily = robotoFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily =  fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}