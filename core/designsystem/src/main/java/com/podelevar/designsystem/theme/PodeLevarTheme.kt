package com.podelevar.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PodeLevarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) PodeLevarDarkColorScheme else PodeLevarLightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = PodeLevarTypography,
        content = content,
    )
}
