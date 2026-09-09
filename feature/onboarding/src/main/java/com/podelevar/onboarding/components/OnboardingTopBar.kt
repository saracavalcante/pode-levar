package com.podelevar.onboarding.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.podelevar.designsystem.components.TextActionButton
import com.podelevar.designsystem.components.TopAppBar
import com.podelevar.designsystem.components.TopAppBarLeading
import com.podelevar.designsystem.theme.IconSize
import com.podelevar.feature.onboarding.R.string.onboarding_offline_badge
import com.podelevar.feature.onboarding.R.string.onboarding_skip_action

@Composable
internal fun OnboardingTopBar(showSkip: Boolean, onSkip: () -> Unit) {
    TopAppBar(
        leading = TopAppBarLeading.BrandLockup,
        actions = {
            if (showSkip) {
                TextActionButton(
                    text = stringResource(onboarding_skip_action),
                    onClick = onSkip
                )
            } else {
                AssistChip(
                    onClick = {},
                    enabled = false,
                    label = { Text(stringResource(onboarding_offline_badge)) },
                    leadingIcon = {
                        Icon(
                            Icons.Default.WifiOff,
                            contentDescription = null,
                            modifier = Modifier.size(IconSize.xs)
                        )
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun OnboardingTopBarPreview() {
    Column {
        OnboardingTopBar(true) { }
        OnboardingTopBar(false) { }
    }
}