package com.podelevar.designsystem.components.topBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.podelevar.designsystem.theme.IconSize

private val TopBarSlotSize = 48.dp

@Composable
fun TopBarDecorativeIcon(
    painter: Painter,
    size: Dp = IconSize.lg
) {
    Box(
        modifier = Modifier.size(TopBarSlotSize),
        contentAlignment = Alignment.Center,
    ) {
        Image(painter = painter, contentDescription = null, modifier = Modifier.size(size))
    }
}
