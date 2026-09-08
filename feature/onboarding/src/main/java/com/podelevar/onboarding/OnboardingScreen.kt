package com.podelevar.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.podelevar.designsystem.components.PageIndicator
import com.podelevar.designsystem.components.PrimaryButton
import com.podelevar.designsystem.components.TextActionButton
import com.podelevar.feature.onboarding.R
import com.podelevar.onboarding.components.OnboardingTopBar
import com.podelevar.onboarding.pages.OnboardingPageOne
import com.podelevar.onboarding.pages.OnboardingPageThree
import com.podelevar.onboarding.pages.OnboardingPageTwo

@Composable
fun OnboardingScreen(
    onOnboardingFinished: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(pageCount = { uiState.totalPages })
    val isLastPage = uiState.currentPage == uiState.totalPages - 1

    LaunchedEffect(uiState.currentPage) {
        pagerState.animateScrollToPage(uiState.currentPage)
    }
    LaunchedEffect(uiState.isCompleted) {
        if (uiState.isCompleted) onOnboardingFinished()
    }

    // Spec seção 4 (Tela 1): back do sistema volta página; na primeira, encerra normalmente.
    BackHandler(enabled = uiState.currentPage > 0) {
        viewModel.onAction(OnboardingAction.PreviousPage)
    }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp),
        ) {
            Spacer(Modifier.height(16.dp))
            OnboardingTopBar(
                showSkip = !isLastPage,
                onSkip = { viewModel.onAction(OnboardingAction.Skip) },
            )
            Spacer(Modifier.height(24.dp))

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f),
                userScrollEnabled = false
            ) { page ->
                when (page) {
                    0 -> OnboardingPageOne()
                    1 -> OnboardingPageTwo()
                    else -> OnboardingPageThree()
                }
            }

            Spacer(Modifier.height(16.dp))
            PageIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                pageCount = uiState.totalPages,
                currentPage = uiState.currentPage
            )
            Spacer(Modifier.height(16.dp))

            if (uiState.currentPage == 0) {
                PrimaryButton(
                    text = stringResource(R.string.onboarding_continue_action),
                    onClick = { viewModel.onAction(OnboardingAction.NextPage) },
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = Icons.Default.ArrowForward,
                )
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TextActionButton(
                        text = stringResource(R.string.onboarding_back_action),
                        onClick = { viewModel.onAction(OnboardingAction.PreviousPage) },
                        leadingIcon = Icons.Default.ArrowBack,
                    )
                    PrimaryButton(
                        text = if (isLastPage) stringResource(R.string.onboarding_finish_action) else stringResource(
                            R.string.onboarding_continue_action
                        ),
                        onClick = { viewModel.onAction(OnboardingAction.NextPage) },
                        trailingIcon = if (isLastPage) Icons.Default.Check else Icons.Default.ArrowForward,
                    )
                }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Preview
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen({})
}