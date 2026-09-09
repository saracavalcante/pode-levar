package com.podelevar.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.podelevar.designsystem.theme.Spacing

private const val ILLUSTRATION_ASPECT_RATIO = 176f / 200f
private const val ILLUSTRATION_WIDTH_FRACTION = 0.45f

@Composable
fun EmptyState(
    illustration: Painter,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    primaryAction: (@Composable () -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Spacing.xl),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(0.8f))
        Image(
            painter = illustration,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(ILLUSTRATION_WIDTH_FRACTION)
                .aspectRatio(ILLUSTRATION_ASPECT_RATIO)
        )
        Text(
            title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(Spacing.sm))
        Text(
            description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
        primaryAction?.let {
            Spacer(Modifier.height(Spacing.xl))
            it()
        }

        Spacer(Modifier.weight(1.2f))
    }
}
