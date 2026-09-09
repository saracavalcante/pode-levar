package com.podelevar.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.podelevar.designsystem.R
import com.podelevar.designsystem.theme.IconSize
import com.podelevar.designsystem.theme.Spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    leading: TopAppBarLeading,
    modifier: Modifier = Modifier,
    title: String? = null,
    actions: @Composable () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            if (title != null) {
                Text(
                    title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        navigationIcon = {
            when (leading) {
                TopAppBarLeading.BrandIcon -> BrandLogo()
                is TopAppBarLeading.BrandLockup -> {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        BrandLogo()
                        Text(
                            text = stringResource(R.string.designsystem_brand_name),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                is TopAppBarLeading.Back -> {
                    IconButton(onClick = leading.onBackClick) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                        )
                    }
                }
            }
        },
        actions = { actions() },
    )
}

@Composable
private fun BrandLogo() {
    Box(
        modifier = Modifier.minimumInteractiveComponentSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.ic_brand_logo),
            contentDescription = null,
            modifier = Modifier.size(IconSize.lg)
        )
    }
}

@Preview
@Composable
private fun TopAppBarPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(Spacing.sm)) {
        TopAppBar(
            title = "Minhas Viagens",
            leading = TopAppBarLeading.BrandIcon,
            actions = {
                IconButton(onClick = {}, enabled = false) {
                    Icon(
                        painter = painterResource(R.drawable.ic_profile),
                        contentDescription = null,
                    )
                }
            }
        )
        TopAppBar(
            title = "Minhas viagens",
            leading = TopAppBarLeading.Back({})
        )
        TopAppBar(
            leading = TopAppBarLeading.BrandLockup,
            actions = {
                TextActionButton(text = "Pular", onClick = {})
            }
        )
    }
}
