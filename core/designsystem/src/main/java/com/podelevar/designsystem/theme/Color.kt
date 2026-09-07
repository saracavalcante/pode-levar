package com.podelevar.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val PodeLevarLightColorScheme: ColorScheme = lightColorScheme(
    primary = Blue.c800,
    onPrimary = Color.White,
    primaryContainer = Blue.c100,
    onPrimaryContainer = Blue.c900,

    secondary = Sky.c600,
    onSecondary = Color.White,
    secondaryContainer = Sky.c100,
    onSecondaryContainer = Sky.c900,

    tertiary = Emerald.c500,
    onTertiary = Color.White,
    tertiaryContainer = Emerald.c100,
    onTertiaryContainer = Emerald.c900,

    error = Red.c600,
    onError = Color.White,
    errorContainer = Red.c50,
    onErrorContainer = Red.c900,

    background = Slate.c50,
    onBackground = Slate.c900,
    surface = Color.White,
    onSurface = Slate.c900,
    surfaceVariant = Slate.c100,
    onSurfaceVariant = Slate.c600,
    outline = Slate.c400,
    outlineVariant = Slate.c200,
)

val PodeLevarDarkColorScheme: ColorScheme = darkColorScheme(
    primary = Blue.c300,
    onPrimary = Blue.c900,
    primaryContainer = Blue.c700,
    onPrimaryContainer = Blue.c100,

    secondary = Sky.c300,
    onSecondary = Sky.c900,
    secondaryContainer = Sky.c700,
    onSecondaryContainer = Sky.c100,

    tertiary = Emerald.c300,
    onTertiary = Emerald.c900,
    tertiaryContainer = Emerald.c700,
    onTertiaryContainer = Emerald.c100,

    error = Red.c700,
    onError = Color.White,
    errorContainer = Red.c900,
    onErrorContainer = Red.c50,

    background = Slate.c950,
    onBackground = Slate.c100,
    surface = Slate.c900,
    onSurface = Slate.c100,
    surfaceVariant = Slate.c800,
    onSurfaceVariant = Slate.c300,
    outline = Slate.c500,
    outlineVariant = Slate.c700,
)