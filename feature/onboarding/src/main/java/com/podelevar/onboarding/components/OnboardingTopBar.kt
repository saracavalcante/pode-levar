package com.podelevar.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.podelevar.designsystem.R
import com.podelevar.designsystem.components.TextActionButton
import com.podelevar.feature.onboarding.R.string.onboarding_skip_action
import com.podelevar.feature.onboarding.R.string.onboarding_offline_badge

@Composable
internal fun OnboardingTopBar(showSkip: Boolean, onSkip: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(R.drawable.ic_logo),
                contentDescription = "Logo Pode Levar",
                modifier = Modifier.height(27.dp)
            )
        }
        if (showSkip) {
            TextActionButton(text = stringResource(onboarding_skip_action), onClick = onSkip)
        } else {
            AssistChip(
                onClick = {},
                enabled = false,
                label = { Text(stringResource(onboarding_offline_badge)) },
                leadingIcon = {
                    Icon(
                        Icons.Default.WifiOff,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnboardingTopBarPreview() {
    Column {
        OnboardingTopBar(true) { }
        OnboardingTopBar(false) { }
    }
}