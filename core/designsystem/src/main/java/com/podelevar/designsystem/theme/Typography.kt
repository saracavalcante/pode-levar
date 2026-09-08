package com.podelevar.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.podelevar.designsystem.R

private val InterFontFamily = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
)

val PodeLevarTypography = Typography().run {
    copy(
        displayLarge = displayLarge.copy(fontFamily = InterFontFamily),
        displayMedium = displayMedium.copy(fontFamily = InterFontFamily),
        displaySmall = displaySmall.copy(fontFamily = InterFontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = InterFontFamily, fontWeight = FontWeight.Bold),
        headlineMedium = headlineMedium.copy(fontFamily = InterFontFamily, fontWeight = FontWeight.Bold),
        headlineSmall = headlineSmall.copy(fontFamily = InterFontFamily, fontWeight = FontWeight.Bold),
        titleLarge = titleLarge.copy(fontFamily = InterFontFamily, fontWeight = FontWeight.SemiBold),
        titleMedium = titleMedium.copy(fontFamily = InterFontFamily, fontWeight = FontWeight.SemiBold),
        titleSmall = titleSmall.copy(fontFamily = InterFontFamily, fontWeight = FontWeight.Medium),
        bodyLarge = bodyLarge.copy(fontFamily = InterFontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = InterFontFamily),
        bodySmall = bodySmall.copy(fontFamily = InterFontFamily),
        labelLarge = labelLarge.copy(fontFamily = InterFontFamily, fontWeight = FontWeight.Medium),
        labelMedium = labelMedium.copy(fontFamily = InterFontFamily, fontWeight = FontWeight.Medium),
        labelSmall = labelSmall.copy(fontFamily = InterFontFamily, fontWeight = FontWeight.Medium),
    )
}