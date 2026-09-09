package com.podelevar.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.podelevar.designsystem.components.EmptyState
import com.podelevar.designsystem.components.PrimaryButton
import com.podelevar.designsystem.components.topBar.TopAppBar
import com.podelevar.designsystem.components.topBar.TopAppBarLeading
import com.podelevar.designsystem.components.topBar.TopBarDecorativeIcon
import com.podelevar.feature.home.R
import com.podelevar.designsystem.R as RUikit

@Composable
fun HomeScreen(
    onCreateTripClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        TopAppBar(
            leading = TopAppBarLeading.BrandIcon,
            title = stringResource(R.string.home_toolbar_title),
            actions = {
                TopBarDecorativeIcon(
                    painter = painterResource(RUikit.drawable.ic_profile)
                )
            }
        )
        EmptyState(
            illustration = painterResource(R.drawable.home_empty_illustration),
            title = stringResource(R.string.home_empty_title),
            description = stringResource(R.string.home_empty_description),
            modifier = Modifier.weight(1f),
            primaryAction = {
                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.home_create_first_trip_action),
                    onClick = onCreateTripClick,
                    leadingIcon = Icons.Default.Add,
                )
            }
        )
    }
}
