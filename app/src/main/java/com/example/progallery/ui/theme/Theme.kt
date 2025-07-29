package com.example.progallery.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary    = md_theme_light_primary,
    onPrimary  = md_theme_light_onPrimary,
    secondary  = md_theme_light_primary,
    background = Color.White,
    surface    = Color.White
)

private val DarkColors = darkColorScheme(
    primary    = md_theme_dark_primary,
    onPrimary  = md_theme_dark_onPrimary,
    secondary  = md_theme_dark_primary,
    background = Color.Black,
    surface    = Color.Black
)

@Composable
fun ProGalleryTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content:     @Composable () -> Unit
) {
    val colors = if (useDarkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography  = Typography,
        shapes      = Shapes,
        content     = content
    )
}